package com.allsales.api.Repositories;

import com.allsales.api.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
