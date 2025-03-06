package com.grantapp.repository.cars.lookup;

import com.grantapp.model.cars.lookup.ClientOrgClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientOrgClassRepository extends JpaRepository<ClientOrgClass, Integer> {

    // Custom query methods can be added here

    // Example: Find all ClientOrgClass entries by ClientId
    List<ClientOrgClass> findByClientId(int clientId);

    // Example: Find all ClientOrgClass entries by OrgClassId
    List<ClientOrgClass> findByOrgClassId(int orgClassId);

    // Example: Find all ClientOrgClass entries by TenantId
    List<ClientOrgClass> findByTenantId(int tenantId);

    // Example: Find all ClientOrgClass entries by DeletedFlag status
    List<ClientOrgClass> findByDeletedFlag(boolean deletedFlag);

    // Example: Find all ClientOrgClass entries by TenantId and DeletedFlag status
    List<ClientOrgClass> findByTenantIdAndDeletedFlag(int tenantId, boolean deletedFlag);
}
