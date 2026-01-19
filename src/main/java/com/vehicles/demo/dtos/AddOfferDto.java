package com.vehicles.demo.dtos;

import com.vehicles.demo.entities.Model;
import com.vehicles.demo.enums.Engine;
import com.vehicles.demo.enums.Extra;
import com.vehicles.demo.enums.Transmission;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public class AddOfferDto {

    @NotBlank
    @Size(min = 10, message = "Описанието трябва да съдържа поне 10 символа!")
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Min(1900)
    private Integer year;

    @NotNull
    @Positive
    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private Engine engine;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    private Set<Extra> extras;

    @NotNull
    private UUID modelId;

    private String imageUrl;

    public AddOfferDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public UUID getModelId() {
        return modelId;
    }

    public void setModelId(UUID modelId) {
        this.modelId = modelId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Extra> getExtras() {
        return extras;
    }

    public void setExtras(Set<Extra> extras) {
        this.extras = extras;
    }
}
