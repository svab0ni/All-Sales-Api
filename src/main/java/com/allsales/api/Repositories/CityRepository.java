package com.allsales.api.Repositories;

import com.allsales.api.Models.City;
import com.allsales.api.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);

    @Query("SELECT c FROM City AS c where c.id = :id")
    City findCityById(@Param("id") Long id);

}
