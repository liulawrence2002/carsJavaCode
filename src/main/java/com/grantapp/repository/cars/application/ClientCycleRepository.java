package com.grantapp.repository.cars.application;

import com.grantapp.model.cars.application.ClientCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCycleRepository extends JpaRepository<ClientCycle, Integer> {
}