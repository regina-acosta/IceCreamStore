package com.example.icecream.controller;

import com.example.icecream.dto.TopFlavorDTO;
import com.example.icecream.dto.VoteDTO;
import com.example.icecream.model.Vote;

import com.example.icecream.service.VoteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/votes")
public class VoteController {

    private final VoteService voteService;


    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<?> castVote(@Valid @RequestBody VoteDTO voteDTO) {
        try {
            Vote savedVote = voteService.saveVote(voteDTO);

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
        dto.setCreatedAt(vote.getCreatedAt());
        return dto;
    }
}
