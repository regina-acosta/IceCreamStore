package com.example.icecream.service;

import com.example.icecream.entity.Vote;
import com.example.icecream.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote saveVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Optional<Vote> getVoteById(UUID id) {
        return voteRepository.findById(id);
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Optional<Vote> getVoteByCustomerId(UUID customerId) {
        return voteRepository.findByCustomer_Id(customerId);
    }

    public Optional<Vote> getVoteByCustomerIdAndMonthAndYear(UUID customerId, int voteMonth, int voteYear) {
        return voteRepository.findByCustomer_IdAndVoteMonthAndVoteYear(customerId, voteMonth, voteYear);
    }

    public Optional<Vote> getVoteByCustomerName(String customerName) {
        return voteRepository.findByCustomer_Name(customerName);
    }

    public List<Vote> getVotesByFlavorName(String flavorName) {
        return voteRepository.findByFlavor_FlavorName(flavorName);
    }

    public List<Vote> getVotesByFlavorId(UUID flavorId) {
        return voteRepository.findByFlavor_Id(flavorId);
    }

    public List<Vote> getVotesByMonth(@Min(1) @Max(12) int voteMonth) {
        return voteRepository.findByVoteMonth(voteMonth);
    }

    public List<Vote> getVotesByYear(int voteYear) {
        return voteRepository.findByVoteYear(voteYear);
    }

    public List<Vote> getVotesByMonthAndYear(@Min(1) @Max(12) int voteMonth, int voteYear) {
        return voteRepository.findByVoteMonthAndVoteYear(voteMonth, voteYear);
    }

    /**
     * Gets the count of votes per flavor for a given month and year.
     *
     * @param voteMonth the month of voting
     * @param voteYear the year of voting
     * @return list of Object[]: [flavorId, flavorName, voteCount]
     */
    public List<Object[]> getVoteCountsByFlavor(int voteMonth, int voteYear) {
        return voteRepository.countVotesByFlavor_Id(voteMonth, voteYear);
    }
}

