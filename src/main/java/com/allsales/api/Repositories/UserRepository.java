package com.allsales.api.Repositories;

import com.allsales.api.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

}