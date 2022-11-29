package com.example.countryapp.models;

public class Country {
    private String name;
    private String capital;
    private String continent;

    public Country(String name, String capital, String continent, long population, String imageURL) {
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.population = population;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    private long population;
    private String imageURL;
}
