package com.grantapp.repository.cars.lookup;

import com.grantapp.model.cars.lookup.Organization;
import com.grantapp.model.cars.lookup.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    // Find all organizations by Tenant ID
    //List<Organization> findByTenantId(int tenantId);
    List<Organization> findByTenant(Tenant tenant);

    // Find all organizations by Client ID
    List<Organization> findByClientId(int clientId);

    // Find all active organizations
    List<Organization> findByActiveTrue();

    // Find all organizations that are not deleted
    List<Organization> findByDeletedFlagFalse();
}