package com.example.icecream.repository;

import com.example.icecream.model.Vote;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, UUID> {

    public Optional<Vote> findById(UUID id);
    public List<Vote> findAll();
    public Optional<Vote> findByCustomer_Id(UUID id);

    Optional<Vote> findByCustomer_IdAndVoteMonthAndVoteYear(UUID customerId, @Min(value = 1) @Max(value = 12) int voteMonth, int voteYear);
    public Optional<Vote> findByCustomer_Name(String customerName);
    public List<Vote> findByFlavor_FlavorName(String flavorFlavorName);
    public List<Vote> findByFlavor_Id(UUID id);

    public List<Vote> findByVoteMonth(@Min(value = 1) @Max(value = 12) int voteMonth);
    public List<Vote> findByVoteYear(int voteYear);
    public List<Vote> findByVoteMonthAndVoteYear(@Min(value = 1) @Max(value = 12) int voteMonth, int voteYear);

    @Query("SELECT v.flavor.id, v.flavor.flavorName, COUNT(v) " +
            "FROM Vote v " +
            "WHERE v.voteMonth = :month AND v.voteYear = :year " +
            "GROUP BY v.flavor.flavorName " +
            "ORDER BY COUNT(v) DESC")
    List<Object[]> countVotesByFlavor_Id(@Param("month") int month, @Param("year") int year);
}
