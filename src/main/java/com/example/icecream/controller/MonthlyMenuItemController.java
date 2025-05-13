package com.example.icecream.controller;

import com.example.icecream.dto.MonthlyMenuItemDTO;
import com.example.icecream.model.Flavor;
import com.example.icecream.model.MonthlyMenuItem;
import com.example.icecream.repository.FlavorRepository;
import com.example.icecream.service.MonthlyMenuItemService;
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
@RequestMapping("/api/monthly-menu")
public class MonthlyMenuItemController {

    private final MonthlyMenuItemService monthlyMenuItemService;
    private final FlavorRepository flavorRepository;

    @Autowired
    public MonthlyMenuItemController(MonthlyMenuItemService monthlyMenuItemService, FlavorRepository flavorRepository) {
        this.monthlyMenuItemService = monthlyMenuItemService;
        this.flavorRepository = flavorRepository;
    }

    @GetMapping
    public List<MonthlyMenuItemDTO> getAllMenuItems() {
        return monthlyMenuItemService.getAllMenuItems()
                .stream()
                .map(MonthlyMenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthlyMenuItemDTO> getMenuItemById(@PathVariable UUID id) {
        return monthlyMenuItemService.getMenuItemById(id)
                .map(item -> ResponseEntity.ok(MonthlyMenuItemDTO.fromEntity(item)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/month/{month}")
    public List<MonthlyMenuItemDTO> getMenuItemsByMonth(@PathVariable int month) {
        return monthlyMenuItemService.getMenuItemsByMonth(month)
                .stream()
                .map(MonthlyMenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/year/{year}")
    public List<MonthlyMenuItemDTO> getMenuItemsByYear(@PathVariable int year) {
        return monthlyMenuItemService.getMenuItemsByYear(year)
                .stream()
                .map(MonthlyMenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<MonthlyMenuItemDTO> getMenuItemsByMonthAndYear(@PathVariable int month, @PathVariable int year) {
        return monthlyMenuItemService.getMenuItemsByMonthAndYear(month, year)
                .stream()
                .map(MonthlyMenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/flavor/id/{flavorId}")
    public List<MonthlyMenuItemDTO> getMenuItemsByFlavorId(@PathVariable UUID flavorId) {
        return monthlyMenuItemService.getMenuItemsByFlavorId(flavorId)
                .stream()
                .map(MonthlyMenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/flavor/name/{flavorName}")
    public List<MonthlyMenuItemDTO> getMenuItemsByFlavorName(@PathVariable String flavorName) {
        return monthlyMenuItemService.getMenuItemsByFlavorName(flavorName)
                .stream()
                .map(MonthlyMenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/month/{month}/year/{year}/rank")
    public List<MonthlyMenuItemDTO> getMenuItemsByRankRange(
            @PathVariable int month,
            @PathVariable int year,
            @RequestParam int min,
            @RequestParam int max) {
        return monthlyMenuItemService.getMenuItemsByMonthYearAndRankRange(month, year, min, max)
                .stream()
                .map(MonthlyMenuItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    record CreateMenuItemPayload(
            @NotEmpty(message = "Flavor ID is required")
            String flavorId, // This will be the UUID of the Flavor entity
            long unitPrice,
            int rankScore,
            int menuMonth,
            int menuYear) {}
    @PostMapping
    public ResponseEntity<MonthlyMenuItemDTO> saveMenuItem(@Valid @RequestBody CreateMenuItemPayload payload) {
        // Retrieve the Flavor entity using the Flavor ID from the DTO
        Flavor flavor = flavorRepository.findById(UUID.fromString(payload.flavorId()))
                .orElseThrow(() -> new EntityNotFoundException("Flavor not found"));

        // Create a new MonthlyMenuItem and set the values from the request payload
        MonthlyMenuItem item = new MonthlyMenuItem();
        item.setFlavor(flavor);  // Set the Flavor entity (not DTO)
        item.setYear(payload.menuYear());
        item.setMonth(payload.menuMonth());
        item.setRankScore(payload.rankScore());
        item.setUnitPrice(payload.unitPrice());

        // Save the MonthlyMenuItem entity
        MonthlyMenuItem savedItem = monthlyMenuItemService.saveMenuItem(item);

        // Return the saved MonthlyMenuItem, converting it to a DTO
        MonthlyMenuItemDTO savedItemDTO = MonthlyMenuItemDTO.fromEntity(savedItem);
        return new ResponseEntity<>(savedItemDTO, HttpStatus.CREATED);
    }

}
