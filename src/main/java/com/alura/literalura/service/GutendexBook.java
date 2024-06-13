package com.alura.literalura.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
public class GutendexBook {

    private String title;
    private List<GutendexAuthor> authors;
    private List<String> languages;

    @JsonProperty("download_count")
    private int download_count;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<GutendexAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<GutendexAuthor> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownloadCount() {
        return download_count;
    }

    public void setDownloadCount(int download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return "GutendexBook{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", languages=" + languages +
                ", download_count=" + download_count +
                '}';
    }

}
