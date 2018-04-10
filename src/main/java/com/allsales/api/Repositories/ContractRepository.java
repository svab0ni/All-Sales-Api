package com.allsales.api.Repositories;

import com.allsales.api.Models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByEmail(String email);
}
