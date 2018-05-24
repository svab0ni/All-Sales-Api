package com.allsales.api.Repositories;

import com.allsales.api.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer AS o where o.id = :id")
    Offer findOfferById(@Param("id") Long id);

    List<Offer> findByTitleIgnoreCaseContainingOrderByIdDesc(@Param("q") String q);
    List<Offer> findAllByOrderByIdDesc();
}
