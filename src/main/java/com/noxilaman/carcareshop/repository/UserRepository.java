package com.noxilaman.carcareshop.repository;

import com.noxilaman.carcareshop.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    boolean existsByemail(String email);

    Optional<User> findByEmail(String email);
}
