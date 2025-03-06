package com.grantapp.repository.cars.lookup;


import com.grantapp.model.cars.lookup.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {

    // Custom query methods can be added here

    // Example: Find a Tenant by TenantName
    Optional<Tenant> findByTenantName(String tenantName);

    // Example: Find all Tenants by TenantTypeId
    List<Tenant> findByTenantTypeId(Integer tenantTypeId);

    // Example: Find a Tenant by TenantGUID
    Optional<Tenant> findByTenantGUID(UUID tenantGUID);
}