package com.example.demo.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty (message = "Xin mời nhập tên thành phố!")
    private String name;

    @ManyToOne
    @NotNull (message = "Xin mời nhập tên quốc gia!")
    private Country country;

    @NotNull (message = "Xin mời nhập diện tích!")
    private Integer totalArea;

    @NotNull (message = "Xin mời nhập dân số!")
    private Integer population;

    @NotNull (message = "Xin mời nhập GDP!")
    private Integer gdp;

    @NotEmpty (message = "Xin mời nhập mô tả!")
    private String description;

    public City() {
    }

    public City(String name, Country country, Integer totalArea, Integer population, Integer gdp, String description) {
        this.name = name;
        this.country = country;
        this.totalArea = totalArea;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Integer totalArea) {
        this.totalArea = totalArea;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
