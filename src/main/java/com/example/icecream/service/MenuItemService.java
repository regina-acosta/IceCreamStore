package com.example.icecream.service;

import com.example.icecream.dto.MenuItemDTO;
import com.example.icecream.model.Flavor;
import com.example.icecream.model.MenuItem;
import com.example.icecream.repository.FlavorRepository;
import com.example.icecream.repository.MenuItemRepository;
import jakarta.persistence.Cacheable;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuItemService {

    private final MenuItemRepository monthlyMenuItemRepository;
    private final VoteService voteService;
    private final FlavorRepository flavorRepository;
    private final PurchaseService purchaseService;

    @Autowired
    public MenuItemService(MenuItemRepository monthlyMenuItemRepository,
                           VoteService voteService,
                           FlavorRepository flavorRepository, PurchaseService purchaseService) {
        this.monthlyMenuItemRepository = monthlyMenuItemRepository;
        this.voteService = voteService;
        this.flavorRepository = flavorRepository;
        this.purchaseService = purchaseService;
    }

    public List<MenuItem> getAllMenuItems() {
        return monthlyMenuItemRepository.findAll();
    }

    public Optional<MenuItem> getMenuItemById(UUID id) {
        return monthlyMenuItemRepository.findById(id);
    }

    public List<MenuItem> getMenuItemsByMonth(int month) {
        return monthlyMenuItemRepository.findByMenuMonth(month);
    }

    public List<MenuItem> getMenuItemsByYear(int year) {
        return monthlyMenuItemRepository.findByMenuYear(year);
    }
    
    public List<MenuItem> getMenuItemsByMonthAndYear(int month, int year) {
        return monthlyMenuItemRepository.findByMenuMonthAndMenuYear(month, year);
    }

    public List<MenuItem> getMenuItemsByFlavorId(UUID flavorId) {
        return monthlyMenuItemRepository.findByFlavor_Id(flavorId);
    }

    public List<MenuItem> getMenuItemsByFlavorName(String flavorName) {
        return monthlyMenuItemRepository.findByFlavor_FlavorName(flavorName);
    }

    public List<MenuItem> getMenuItemsByMonthYearAndRankRange(int month, int year, double rankMin, double rankMax) {
        return monthlyMenuItemRepository.findByMenuMonthAndMenuYearAndRankScoreBetween(month, year, rankMin, rankMax);
    }

    public MenuItem saveMenuItem(MenuItem item) {
        return monthlyMenuItemRepository.save(item);
    }

    public List<MenuItemDTO> generateMonthlyMenu(Double voteWeight, Double purchaseWeight) {

        YearMonth now = YearMonth.now();
        List<Object[]> flavorsVoteCount = voteService.calculateFlavorsVoteCount();

        Map<UUID, Integer> purchaseCountMap =  purchaseService.calculatePurchaseCountsByFlavor();
        Map<UUID, Double> flavorPopularity = new HashMap<>();


        for (Object[] row : flavorsVoteCount) {

            UUID flavorId = (UUID) row[0];
            Flavor flavor = flavorRepository.findById(flavorId)
                    .orElseThrow(() -> new EntityNotFoundException("Flavor not found"));

            long voteCount = (long) row[2];

            int purchaseCount = purchaseCountMap.getOrDefault(flavorId, 0);

            // You can adjust these weights to control how much each metric contributes to popularity
            Double popularity = (voteCount * voteWeight) + (purchaseCount * purchaseWeight);
            // Normalize the popularity score to a range of 0-1
            popularity = Math.min(popularity, 1.0);

            flavorPopularity.put(flavorId, popularity);
        }

        List<Map.Entry<UUID, Double>> top5Flavors = flavorPopularity.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .limit(5)
                .collect(Collectors.toList());

        // Create MonthlyMenuItem objects for the top 25 flavors of the month
        List<MenuItemDTO> monthlyMenuItems = new ArrayList<>(25);
        System.out.println("Top 25 Flavors: " + top5Flavors.size());

        for (Map.Entry<UUID, Double> entry : top5Flavors) {
            UUID flavorId = entry.getKey();
            Double popularity = entry.getValue();

            Flavor flavor = flavorRepository.findById(flavorId)
                    .orElseThrow(() -> new EntityNotFoundException("Flavor not found"));

            MenuItem item = new MenuItem();
            item.setFlavor(flavor);
            item.setMonth(now.getMonthValue());
            item.setYear(now.getYear());
            item.setUnitPrice(flavor.getUnitPrice());
            item.setRankScore(popularity);   // new item, not yet voted


            // Save the MonthlyMenuItem entity
            MenuItem savedItem = saveMenuItem(item);

            // Return the saved MonthlyMenuItem, converting it to a DTO
            MenuItemDTO savedItemDTO = MenuItemDTO.fromEntity(item);
            monthlyMenuItems.add(savedItemDTO);

        }

        // get the last month's menu items
        List<MenuItem> lastMonthMenuItems = getMenuItemsByMonthAndYear(now.getMonthValue() - 1, now.getYear());
        System.out.println("lastMonthMenuItems: " + lastMonthMenuItems.size());

        // get all the flavors
        List<Flavor> allFlavors = flavorRepository.findAll();
        System.out.println("allFlavors: " + allFlavors.size());

        // filter out the flavors that are already in the top 5
        Set<UUID> top5FlavorIds = top5Flavors.stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        Set<UUID> lastMonthFlavorIds = lastMonthMenuItems.stream()
                .map(menuItem -> menuItem.getFlavor().getId())
                .collect(Collectors.toSet());

        List<Flavor> filteredFlavors = allFlavors.stream()
                .filter(flavor -> !top5FlavorIds.contains(flavor.getId()))
                .collect(Collectors.toList());
        System.out.println("filteredFlavors without top 5: " + filteredFlavors.size());

        filteredFlavors = filteredFlavors.stream()
                .filter(flavor -> !lastMonthFlavorIds.contains(flavor.getId()))
                .collect(Collectors.toList());
        System.out.println("filteredFlavors without last month's menu items: " + filteredFlavors.size());

        if (filteredFlavors.size() < 20) {
            throw new IllegalStateException("Not enough flavors to generate 20 menu items");
        }
        // generate an additional 20 items that aren't the top 5 flavors
        // or flavors from the last month's menu
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            // get a random item from remaining flavors

            int randomIndex = random.nextInt(filteredFlavors.size());

            // find the flavor
            Flavor unusedFlavor = filteredFlavors.get(randomIndex);

            // create a new item
            MenuItem newItem = new MenuItem();
            newItem.setFlavor(unusedFlavor);
            newItem.setMonth(now.getMonthValue());
            newItem.setYear(now.getYear());
            newItem.setUnitPrice(unusedFlavor.getUnitPrice());
            newItem.setRankScore(0.0);   // start fresh each month for new items

            // Save the MonthlyMenuItem entity
            MenuItem savedNewItem = saveMenuItem(newItem);

            // Return the saved MonthlyMenuItem, converting it to a DTO
            MenuItemDTO savedNewItemDTO = MenuItemDTO.fromEntity(newItem);
            monthlyMenuItems.add(savedNewItemDTO);

            // Remove the flavor from the filteredFlavors list so we do not add it to the monthly menu again
            filteredFlavors.remove(randomIndex);
        }

        return monthlyMenuItems;

    }

}

