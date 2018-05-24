package com.allsales.api.Repositories;

import com.allsales.api.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT u FROM User AS u where u.id = :id")
    User findUserById (@Param("id") Long id);

    List<User> findByUsernameIgnoreCaseContaining(@Param("q") String q);
}