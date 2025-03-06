package com.grantapp.repository.cars.application;

import com.grantapp.model.cars.application.ClientAwardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAwardTypeRepository extends JpaRepository<ClientAwardType, Integer> {
}