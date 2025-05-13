package com.example.icecream.controller;

import com.example.icecream.dto.TopFlavorDTO;
import com.example.icecream.dto.VoteDTO;
import com.example.icecream.model.Customer;
import com.example.icecream.model.Flavor;
import com.example.icecream.model.MonthlyMenuItem;
import com.example.icecream.model.Vote;
import com.example.icecream.service.CustomerService;
import com.example.icecream.service.FlavorService;
import com.example.icecream.service.MonthlyMenuItemService;
import com.example.icecream.service.VoteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private final VoteService voteService;
    private final CustomerService customerService;
    private final MonthlyMenuItemService monthlyMenuItemService;
    private final FlavorService flavorService;

    @Autowired
    public VoteController(VoteService voteService, CustomerService customerService, MonthlyMenuItemService monthlyMenuItemService, FlavorService flavorService) {
        this.voteService = voteService;
        this.customerService = customerService;
        this.monthlyMenuItemService = monthlyMenuItemService;
        this.flavorService = flavorService;
    }

    @PostMapping
    public ResponseEntity<?> castVote(@Valid @RequestBody VoteDTO voteDTO) {
        try {
            Customer customer = customerService.getCustomerById(voteDTO.getCustomerId())
                    .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

            Flavor flavor = flavorService.getFlavorById(voteDTO.getFlavorId())
                    .orElseThrow(() -> new IllegalArgumentException("Flavor not found"));

            Vote vote = new Vote();
            vote.setCustomer(customer);
            vote.setFlavor(flavor);
            vote.setVoteMonth(LocalDate.now().getMonthValue());
            vote.setVoteYear(LocalDate.now().getYear());

            Vote savedVote = voteService.saveVote(vote);

            VoteDTO savedDTO = toDTO(savedVote);
            return ResponseEntity.ok(savedDTO);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoteDTO> getVoteById(@PathVariable UUID id) {
        return voteService.getVoteById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<VoteDTO> getAllVotes() {
        return voteService.getAllVotes().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<VoteDTO>> getVotesByCustomer(@PathVariable UUID customerId) {
        List<VoteDTO> votes = voteService.getVotesByCustomerId(customerId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(votes);
    }

    @GetMapping("/month-year")
    public List<VoteDTO> getVotesByMonthAndYear(@RequestParam @Min(1) @Max(12) int month,
                                                @RequestParam int year) {
        return voteService.getVotesByMonthAndYear(month, year).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/top-flavors")
    public List<TopFlavorDTO> getTopVotedFlavors(@RequestParam int month, @RequestParam int year) {
        List<Object[]> rawData = voteService.getVoteCountsByFlavor(month, year);

        return rawData.stream().map(row -> new TopFlavorDTO(
                (UUID) row[0],
                (String) row[1],
                ((Number) row[2]).longValue()
        )).toList();
    }


    private VoteDTO toDTO(Vote vote) {
        VoteDTO dto = new VoteDTO();
        dto.setId(vote.getId());
        dto.setCustomerId(vote.getCustomer().getId());
        dto.setFlavorId(vote.getFlavor().getId());
        dto.setYear(vote.getVoteYear());
        dto.setMonth(vote.getVoteMonth());
        return dto;
    }
}
