package com.vehicles.demo.dtos;

import com.vehicles.demo.entities.OfferImage;
import com.vehicles.demo.enums.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class OfferDisplayDto {

    private UUID id;
    private String description;
    private BigDecimal price;
    private Integer year;
    private Integer mileage;
    private Engine engine;
    private Transmission transmission;
    private List<String> allImageUrls;
    private String brandName;
    private String modelName;
    private String sellerUsername;
    private Set<Extra> extras;
    private String imageUrl;
    private List<OfferImage> images;
    private String phoneNumber;
    private Color color;
    private EuroStandard euroStandard;
    private DoorCount doorCount;
    private Region region;
    private String horsePower;
    private String cubes;
    private LocalDateTime createdOn;


    public OfferDisplayDto() {

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


    public List<String> getAllImageUrls() {
        return allImageUrls;
    }

    public void setAllImageUrls(List<String> allImageUrls) {
        this.allImageUrls = allImageUrls;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }



    public List<OfferImage> getImages() {
        return images;
    }

    public void setImages(List<OfferImage> images) {
        this.images = images;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public EuroStandard getEuroStandard() {
        return euroStandard;
    }

    public void setEuroStandard(EuroStandard euroStandard) {
        this.euroStandard = euroStandard;
    }

    public DoorCount getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(DoorCount doorCount) {
        this.doorCount = doorCount;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public String getCubes() {
        return cubes;
    }

    public void setCubes(String cubes) {
        this.cubes = cubes;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}


