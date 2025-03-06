package com.grantapp.repository.cars.lookup;

import com.grantapp.model.cars.lookup.OrgType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgTypeRepository extends JpaRepository<OrgType, Integer> {

    // Custom query methods can be added here

    // Example: Find an OrgType by OrgTypeName
    Optional<OrgType> findByOrgTypeName(String orgTypeName);
}