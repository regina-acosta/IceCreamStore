package com.example.icecream.dto;

import java.util.UUID;

public class TopFlavorDTO {
    private UUID flavorId;
    private String flavorName;
    private long voteCount;

    public TopFlavorDTO(UUID flavorId, String flavorName, long voteCount) {
        this.flavorId = flavorId;
        this.flavorName = flavorName;
        this.voteCount = voteCount;
    }

    public UUID getFlavorId() {
        return flavorId;
    }

    public String getFlavorName() {
        return flavorName;
    }

    public long getVoteCount() {
        return voteCount;
    }
}
