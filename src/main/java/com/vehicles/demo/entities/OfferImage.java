package com.vehicles.demo.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "offer_images")
public class OfferImage extends BaseEntity {

    @Column(nullable = false)
    private String url;

    @Column(name = "is_main_image")
    private boolean isMainImage;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public OfferImage () {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public boolean isMainImage() {
        return isMainImage;
    }

    public void setMainImage(boolean mainImage) {
        isMainImage = mainImage;
    }
}
