package com.karpuk.clashtrack.api.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClansSearchResponse {

    private List<Clan> items;

    public ClansSearchResponse() {
    }

    public List<Clan> getItems() {
        return items;
    }

    public void setItems(List<Clan> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ClansSearchResponse{" +
                "items=" + items +
                '}';
    }

}
