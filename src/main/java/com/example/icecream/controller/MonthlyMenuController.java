package com.example.icecream.controller;

import com.example.icecream.dto.MenuItemDTO;
import com.example.icecream.model.MenuItem;
import com.example.icecream.service.MenuItemService;
import jakarta.persistence.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/monthly-menu")
public class MonthlyMenuController {

    private final MenuItemService monthlyMenuItemService;

    public MonthlyMenuController(MenuItemService monthlyMenuItemService) {
        this.monthlyMenuItemService = monthlyMenuItemService;
    }

    @PostMapping("/generate-menu")
    public ResponseEntity<List<MenuItemDTO>> generateMenuFrom(
            @RequestParam(defaultValue = "0.5") Double voteWeight,
            @RequestParam(defaultValue = "0.5") Double purchaseWeight) {

        List<MenuItemDTO> result = monthlyMenuItemService.generateMonthlyMenu(voteWeight, purchaseWeight);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<MenuItemDTO> getMenuItemsByMonthAndYear(@PathVariable int month, @PathVariable int year) {
        return monthlyMenuItemService.getMenuItemsByMonthAndYear(month, year)
                .stream()
                .map(MenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
