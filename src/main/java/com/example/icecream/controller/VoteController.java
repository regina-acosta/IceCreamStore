package com.example.icecream.controller;

import com.example.icecream.model.Vote;
import com.example.icecream.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<Vote> castVote(@RequestBody Vote vote) {
        try {
            Vote savedVote = voteService.saveVote(vote);
            return ResponseEntity.ok(savedVote);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable UUID id) {
        return voteService.getVoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Optional<Vote>> getVotesByCustomer(@PathVariable UUID customerId) {
        return ResponseEntity.ok(voteService.getVoteByCustomerId(customerId));
    }

    @GetMapping("/month-year")
    public List<Vote> getVotesByMonthAndYear(@RequestParam @Min(1) @Max(12) int month,
                                             @RequestParam int year) {
        return voteService.getVotesByMonthAndYear(month, year);
    }

    @GetMapping("/top-flavors")
    public List<Object[]> getTopVotedFlavors(@RequestParam int month, @RequestParam int year) {
        return voteService.getVoteCountsByFlavor(month, year);
    }
}

