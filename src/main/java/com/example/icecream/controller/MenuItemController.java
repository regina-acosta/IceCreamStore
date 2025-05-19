package com.example.icecream.controller;

import com.example.icecream.dto.MenuItemDTO;
import com.example.icecream.model.Flavor;
import com.example.icecream.model.MenuItem;
import com.example.icecream.repository.FlavorRepository;
import com.example.icecream.service.MenuItemService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/menu-item")
public class MenuItemController {

    private final MenuItemService monthlyMenuItemService;
    private final FlavorRepository flavorRepository;

    @Autowired
    public MenuItemController(MenuItemService monthlyMenuItemService, FlavorRepository flavorRepository) {
        this.monthlyMenuItemService = monthlyMenuItemService;
        this.flavorRepository = flavorRepository;
    }

    @GetMapping
    public List<MenuItemDTO> getAllMenuItems() {
        return monthlyMenuItemService.getAllMenuItems()
                .stream()
                .map(MenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDTO> getMenuItemById(@PathVariable UUID id) {
        return monthlyMenuItemService.getMenuItemById(id)
                .map(item -> ResponseEntity.ok(MenuItemDTO.fromEntity(item)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/month/{month}")
    public List<MenuItemDTO> getMenuItemsByMonth(@PathVariable int month) {
        return monthlyMenuItemService.getMenuItemsByMonth(month)
                .stream()
                .map(MenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/year/{year}")
    public List<MenuItemDTO> getMenuItemsByYear(@PathVariable int year) {
        return monthlyMenuItemService.getMenuItemsByYear(year)
                .stream()
                .map(MenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/flavor/id/{flavorId}")
    public List<MenuItemDTO> getMenuItemsByFlavorId(@PathVariable UUID flavorId) {
        return monthlyMenuItemService.getMenuItemsByFlavorId(flavorId)
                .stream()
                .map(MenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/flavor/name/{flavorName}")
    public List<MenuItemDTO> getMenuItemsByFlavorName(@PathVariable String flavorName) {
        return monthlyMenuItemService.getMenuItemsByFlavorName(flavorName)
                .stream()
                .map(MenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/month/{month}/year/{year}/rank")
    public List<MenuItemDTO> getMenuItemsByRankRange(
            @PathVariable int month,
            @PathVariable int year,
            @RequestParam double min,
            @RequestParam double max) {
        return monthlyMenuItemService.getMenuItemsByMonthYearAndRankRange(month, year, min, max)
                .stream()
                .map(MenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    record CreateMenuItemPayload(
            @NotEmpty(message = "Flavor ID is required")
            String flavorId,
            Double rankScore,
            int menuMonth,
            int menuYear) {}
    @PostMapping
    public ResponseEntity<?> saveMenuItem(@Valid @RequestBody CreateMenuItemPayload payload) {
        try{
            // Retrieve the Flavor entity using the Flavor ID from the DTO
            Flavor flavor = flavorRepository.findById(UUID.fromString(payload.flavorId()))
                    .orElseThrow(() -> new EntityNotFoundException("Flavor not found"));

            // Create a new MonthlyMenuItem and set the values from the request payload
            MenuItem item = new MenuItem();
            item.setFlavor(flavor);
            item.setYear(payload.menuYear());
            item.setMonth(payload.menuMonth());
            item.setRankScore(payload.rankScore());
            item.setUnitPrice(flavor.getUnitPrice());

            // Save the MonthlyMenuItem entity
            MenuItem savedItem = monthlyMenuItemService.saveMenuItem(item);

            // Return the saved MonthlyMenuItem, converting it to a DTO
            MenuItemDTO savedItemDTO = MenuItemDTO.fromEntity(savedItem);
            return new ResponseEntity<>(savedItemDTO, HttpStatus.CREATED);

        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }


    }

}
