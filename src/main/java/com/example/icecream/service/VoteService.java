package com.example.icecream.service;

import com.example.icecream.dto.VoteDTO;
import com.example.icecream.model.Customer;
import com.example.icecream.model.Flavor;
import com.example.icecream.model.Vote;
import com.example.icecream.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final FlavorService flavorService;
    private final CustomerService customerService;

    @Autowired
    public VoteService(VoteRepository voteRepository, FlavorService flavorService, CustomerService customerService) {
        this.voteRepository = voteRepository;
        this.customerService = customerService;
        this.flavorService = flavorService;
    }
    private final static int VOTE_LIMIT = 5;

    public Vote saveVote(VoteDTO voteDTO) {
        int voteMonth = LocalDate.now().getMonthValue();
        int voteYear = LocalDate.now().getYear();
        int voteCount = getVoteCountByCustomerIdAndMonthAndYear(voteDTO.getCustomerId(), voteMonth, voteYear);

        if (voteCount >= VOTE_LIMIT) {
            throw new IllegalArgumentException("Customer has already voted " + voteCount + " times this month.");
        }

        Customer customer = customerService.getCustomerById(voteDTO.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        Flavor flavor = flavorService.getFlavorById(voteDTO.getFlavorId())
                .orElseThrow(() -> new IllegalArgumentException("Flavor not found"));

        Vote vote = new Vote();
        vote.setCustomer(customer);
        vote.setFlavor(flavor);
        vote.setVoteMonth(voteMonth);
        vote.setVoteYear(voteYear);

        return voteRepository.save(vote);
    }

    public Optional<Vote> getVoteById(UUID id) {
        return voteRepository.findById(id);
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public List<Vote> getVotesByCustomerId(UUID customerId) {
        return voteRepository.findByCustomer_Id(customerId);
    }

    public int getVoteCountByCustomerIdAndMonthAndYear(UUID customerId, int voteMonth, int voteYear) {

        List<Vote> votes  = voteRepository.findByCustomer_IdAndVoteMonthAndVoteYear(customerId, voteMonth, voteYear);
        return votes.size();
    }

    public List<Vote> getVotesByCustomerName(String customerName) {
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
        return voteRepository.findVoteCountByFlavorIds(voteMonth, voteYear);
    }

    public List<Object[]> calculateFlavorsVoteCount() {
        LocalDate currentDate = LocalDate.now();
        int previousMonth = currentDate.minusMonths(1).getMonthValue();
        int voteYear = LocalDate.now().getYear();
        // If the previous month is December, we need to adjust the year
        if (previousMonth == 12) {
            voteYear--;
        }
        return voteRepository.findVoteCountByFlavorIds(previousMonth, voteYear);
    }
}

