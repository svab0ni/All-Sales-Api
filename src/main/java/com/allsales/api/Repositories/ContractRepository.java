package com.allsales.api.Repositories;

import com.allsales.api.Models.Contract;
import com.allsales.api.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByEmail(String email);
    Contract findByName(String name);

    @Query("SELECT c FROM Contract AS c where c.id = :id")
    Contract findContractById(@Param("id") Long id);
}
