package com.example.icecream.service;

import com.example.icecream.model.MonthlyMenuItem;
import com.example.icecream.repository.MonthlyMenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MonthlyMenuItemService {

    private final MonthlyMenuItemRepository monthlyMenuItemRepository;

    @Autowired
    public MonthlyMenuItemService(MonthlyMenuItemRepository monthlyMenuItemRepository) {
        this.monthlyMenuItemRepository = monthlyMenuItemRepository;
    }

    public List<MonthlyMenuItem> getAllMenuItems() {
        return monthlyMenuItemRepository.findAll();
    }

    public Optional<MonthlyMenuItem> getMenuItemById(UUID id) {
        return monthlyMenuItemRepository.findById(id);
    }

    public List<MonthlyMenuItem> getMenuItemsByMonth(int month) {
        return monthlyMenuItemRepository.findByMenuMonth(month);
    }

    public List<MonthlyMenuItem> getMenuItemsByYear(int year) {
        return monthlyMenuItemRepository.findByMenuYear(year);
    }

    public List<MonthlyMenuItem> getMenuItemsByMonthAndYear(int month, int year) {
        return monthlyMenuItemRepository.findByMenuMonthAndMenuYear(month, year);
    }

    public List<MonthlyMenuItem> getMenuItemsByFlavorId(UUID flavorId) {
        return monthlyMenuItemRepository.findByFlavor_Id(flavorId);
    }

    public List<MonthlyMenuItem> getMenuItemsByFlavorName(String flavorName) {
        return monthlyMenuItemRepository.findByFlavor_FlavorName(flavorName);
    }

    public List<MonthlyMenuItem> getMenuItemsByMonthYearAndRankRange(int month, int year, int rankMin, int rankMax) {
        return monthlyMenuItemRepository.findByMenuMonthAndMenuYearAndRankScoreBetween(month, year, rankMin, rankMax);
    }

    public MonthlyMenuItem saveMenuItem(MonthlyMenuItem item) {
        return monthlyMenuItemRepository.save(item);
    }
}

