package com.vehicles.demo.repositories;

import com.vehicles.demo.entities.Offer;
import com.vehicles.demo.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {

    @Query("SELECT o FROM Offer o " +
            "WHERE (:modelId IS NULL OR o.model.id = :modelId) " +
            "AND (:minYear IS NULL OR o.year >= :minYear) " +
            "AND (:maxYear IS NULL OR o.year <= :maxYear) " +
            "AND (:minPrice IS NULL OR o.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR o.price <= :maxPrice) " +
            "AND (:engine IS NULL OR o.engine = :engine) " +
            "AND (:transmission IS NULL OR o.transmission = :transmission) " +
            "AND (:color IS NULL OR o.color = :color) " +
            "AND (:region IS NULL OR o.region = :region) " +
            "AND (:doorCount IS NULL OR o.doorCount = :doorCount) " +
            "AND (:mileage IS NULL OR o.mileage <= :mileage) " +
            "AND (:minCubes IS NULL OR o.cubes >= :minCubes) " +
            "AND (:maxCubes IS NULL OR o.cubes <= :maxCubes) " +
            "AND (:minHorsePower IS NULL OR o.horsePower >= :minHorsePower) " +
            "AND (:maxHorsePower IS NULL OR o.horsePower <= :maxHorsePower) " +
            "AND (:euroStandard IS NULL OR o.euroStandard = :euroStandard)")

    List<Offer> searchOffers(
            @Param("modelId") UUID modelId,
            @Param("minYear") Integer minYear,
            @Param("maxYear") Integer maxYear,
            @Param("minPrice") BigDecimal minPrice,
            @Param("engine") Engine engine,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("mileage") Integer mileage,
            @Param("minCubes") Integer minCubes,
            @Param("maxCubes") Integer maxCubes,
            @Param("minHorsePower") Integer minHorsePower,
            @Param("maxHorsePower") Integer maxHorsePower,
            @Param("color") Color color,
            @Param("transmission") Transmission transmission,
            @Param("doorCount") DoorCount doorcount,
            @Param("euroStandard") EuroStandard euroStandard,
            @Param("region") Region region,
            @Param("sort") Sort sort

    );
}