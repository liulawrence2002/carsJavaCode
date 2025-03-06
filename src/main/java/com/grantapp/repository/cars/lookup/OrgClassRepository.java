package com.grantapp.repository.cars.lookup;

import com.grantapp.model.cars.lookup.OrgClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgClassRepository extends JpaRepository<OrgClass, Integer> {

    // Custom query methods can be added here

    // Example: Find an OrgClass by OrgClassName
    Optional<OrgClass> findByOrgClassName(String orgClassName);
}