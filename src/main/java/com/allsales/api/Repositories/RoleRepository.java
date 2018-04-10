package com.allsales.api.Repositories;

import com.allsales.api.Models.Role;
import com.allsales.api.Models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
}
