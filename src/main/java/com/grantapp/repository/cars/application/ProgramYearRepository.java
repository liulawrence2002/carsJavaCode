package com.grantapp.repository.cars.application;

import com.grantapp.model.cars.application.ProgramYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramYearRepository extends JpaRepository<ProgramYear, Integer> {
}