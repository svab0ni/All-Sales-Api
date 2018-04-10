package com.allsales.api.Repositories;

import com.allsales.api.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT u FROM User AS u where u.id = :id")
    Offer findOfferById(@Param("id") Long id);
}
