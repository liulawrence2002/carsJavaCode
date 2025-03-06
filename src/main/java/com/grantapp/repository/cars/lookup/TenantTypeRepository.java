package com.grantapp.repository.cars.lookup;


import com.grantapp.model.cars.lookup.TenantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantTypeRepository extends JpaRepository<TenantType, Integer> {

    // Custom query methods can be added here

    // Example: Find a TenantType by TenantTypeName
    Optional<TenantType> findByTenantTypeName(String tenantTypeName);
}