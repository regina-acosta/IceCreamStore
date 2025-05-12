package com.example.icecream.controller;

import com.example.icecream.model.MonthlyMenuItem;
import com.example.icecream.service.MonthlyMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/monthly-menu")
public class MonthlyMenuItemController {

    private final MonthlyMenuItemService monthlyMenuItemService;

    @Autowired
    public MonthlyMenuItemController(MonthlyMenuItemService monthlyMenuItemService) {
        this.monthlyMenuItemService = monthlyMenuItemService;
    }

    @GetMapping
    public List<MonthlyMenuItem> getAllMenuItems() {
        return monthlyMenuItemService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthlyMenuItem> getMenuItemById(@PathVariable UUID id) {
        return monthlyMenuItemService.getMenuItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/month/{month}")
    public List<MonthlyMenuItem> getMenuItemsByMonth(@PathVariable int month) {
        return monthlyMenuItemService.getMenuItemsByMonth(month);
    }

    @GetMapping("/year/{year}")
    public List<MonthlyMenuItem> getMenuItemsByYear(@PathVariable int year) {
        return monthlyMenuItemService.getMenuItemsByYear(year);
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<MonthlyMenuItem> getMenuItemsByMonthAndYear(@PathVariable int month, @PathVariable int year) {
        return monthlyMenuItemService.getMenuItemsByMonthAndYear(month, year);
    }

    @GetMapping("/flavor/id/{flavorId}")
    public List<MonthlyMenuItem> getMenuItemsByFlavorId(@PathVariable UUID flavorId) {
        return monthlyMenuItemService.getMenuItemsByFlavorId(flavorId);
    }

    @GetMapping("/flavor/name/{flavorName}")
    public List<MonthlyMenuItem> getMenuItemsByFlavorName(@PathVariable String flavorName) {
        return monthlyMenuItemService.getMenuItemsByFlavorName(flavorName);
    }

    @GetMapping("/month/{month}/year/{year}/rank")
    public List<MonthlyMenuItem> getMenuItemsByRankRange(
            @PathVariable int month,
            @PathVariable int year,
            @RequestParam int min,
            @RequestParam int max) {
        return monthlyMenuItemService.getMenuItemsByMonthYearAndRankRange(month, year, min, max);
    }

    @PostMapping
    public ResponseEntity<MonthlyMenuItem> saveMenuItem(@RequestBody MonthlyMenuItem item) {
        MonthlyMenuItem savedItem = monthlyMenuItemService.saveMenuItem(item);
        return ResponseEntity.ok(savedItem);
    }
}

