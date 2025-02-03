package com.grantapp.repository;

import com.grantapp.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    // Custom query methods can be added here if needed
}