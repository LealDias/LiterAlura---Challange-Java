package com.alura.literalura.service;

import com.fasterxml.jackson.annotation.JsonProperty;
public class GutendexAuthor {

    @JsonProperty("name")
    private String name;
    @JsonProperty("birth_year")
    private Integer birth_year;
    @JsonProperty("death_year")
    private Integer death_year;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birth_year;
    }

    public void setBirthYear(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeathYear() {
        return death_year;
    }

    public void setDeathYear(Integer death_year) {
        this.death_year = death_year;
    }

    @Override
    public String toString() {
        return "GutendexAuthor{" +
                "name='" + name + '\'' +
                ", birth_year=" + birth_year +
                ", death_year=" + death_year +
                '}';
    }

}
