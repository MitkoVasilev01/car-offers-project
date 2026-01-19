package com.vehicles.demo.dtos;

import com.vehicles.demo.enums.Extra;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public class SearchOfferDto {

    private UUID modelId;
    private Integer minYear;
    private Integer maxYear;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer mileage;
    private Integer minCubes;
    private Integer maxCubes;
    private Integer minHorsePower;
    private Integer maxHorsePower;
    private Set<Extra> extras;



    public SearchOfferDto() {

    }

    public UUID getModelId() {
        return modelId;
    }

    public void setModelId(UUID modelId) {
        this.modelId = modelId;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Integer maxYear) {
        this.maxYear = maxYear;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getMinCubes() {
        return minCubes;
    }

    public void setMinCubes(Integer minCubes) {
        this.minCubes = minCubes;
    }

    public Integer getMaxCubes() {
        return maxCubes;
    }

    public void setMaxCubes(Integer maxCubes) {
        this.maxCubes = maxCubes;
    }

    public Integer getMinHorsePower() {
        return minHorsePower;
    }

    public void setMinHorsePower(Integer minHorsePower) {
        this.minHorsePower = minHorsePower;
    }

    public Integer getMaxHorsePower() {
        return maxHorsePower;
    }

    public void setMaxHorsePower(Integer maxHorsePower) {
        this.maxHorsePower = maxHorsePower;
    }

    public Set<Extra> getExtras() {
        return extras;
    }

    public void setExtras(Set<Extra> extras) {
        this.extras = extras;
    }
}
