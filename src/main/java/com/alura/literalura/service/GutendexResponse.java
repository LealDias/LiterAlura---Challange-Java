package com.alura.literalura.service;

import java.util.List;
public class GutendexResponse {

    private List<GutendexBook> results;

    // Getters and Setters
    public List<GutendexBook> getResults() {
        return results;
    }

    public void setResults(List<GutendexBook> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GutendexResponse{" +
                "results=" + results +
                '}';
    }
}
