package com.vehicles.demo.repositories;

import com.vehicles.demo.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {

    @Query("SELECT o FROM Offer o " +
            "WHERE (:modelId IS NULL OR o.model.id = :modelId) " +
            "AND (:minYear IS NULL OR o.year >= :minYear) " +
            "AND (:maxPrice IS NULL OR o.price <= :maxPrice)")
    List<Offer> searchOffers(
            @Param("modelId") UUID modelId,
            @Param("minYear") Integer minYear,
            @Param("maxPrice") BigDecimal maxPrice
    );
}