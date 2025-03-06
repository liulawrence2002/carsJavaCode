package com.grantapp.repository.cars.application;

import com.grantapp.model.cars.application.ProgramMechanism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramMechanismRepository extends JpaRepository<ProgramMechanism, Integer> {
}