package com.example.icecream.repository;

import com.example.icecream.model.Vote;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, UUID> {

    public Optional<Vote> findById(UUID id);
    public List<Vote> findAll();
    public List<Vote> findByCustomer_Id(UUID id);
    public List<Vote> findByCustomer_Name(String customerName);
    // find votes customer id for the current month and year
    List<Vote> findByCustomer_IdAndVoteMonthAndVoteYear(UUID customerId, @Min(value = 1) @Max(value = 12) int voteMonth, int voteYear);

    public List<Vote> findByFlavor_FlavorName(String flavorFlavorName);
    public List<Vote> findByFlavor_Id(UUID id);

    public List<Vote> findByVoteMonth(@Min(value = 1) @Max(value = 12) int voteMonth);
    public List<Vote> findByVoteYear(int voteYear);
    public List<Vote> findByVoteMonthAndVoteYear(@Min(value = 1) @Max(value = 12) int voteMonth, int voteYear);

    @Query("SELECT v.flavor.id, v.flavor.flavorName, COUNT(v) AS total_votes " +
            "FROM Vote v " +
            "WHERE v.voteMonth = :month AND v.voteYear = :year " +
            "GROUP BY v.flavor.id " +
            "ORDER BY COUNT(v) DESC")
    List<Object[]> findVoteCountByFlavorIds(@Param("month") int month, @Param("year") int year);

}
