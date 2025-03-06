package com.grantapp.repository.cars.application;

import com.grantapp.model.cars.application.ClientProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientProgramRepository extends JpaRepository<ClientProgram, Integer> {
}