package com.grantapp.repository;

import com.grantapp.model.CarsUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarsUserRepository extends JpaRepository<CarsUser, Long> {
    Optional<CarsUser> findByUsername(String username);
    Optional<CarsUser> findById(Long id);
}