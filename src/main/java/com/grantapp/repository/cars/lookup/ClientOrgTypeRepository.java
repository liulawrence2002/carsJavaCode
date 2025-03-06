package com.grantapp.repository.cars.lookup;

import com.grantapp.model.cars.lookup.ClientOrgType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientOrgTypeRepository extends JpaRepository<ClientOrgType, Integer> {

    // Custom query methods can be added here

    // Example: Find all ClientOrgType entries by ClientId
    List<ClientOrgType> findByClientId(int clientId);

    // Example: Find all ClientOrgType entries by OrgTypeId
    List<ClientOrgType> findByOrgTypeId(int orgTypeId);

    // Example: Find all ClientOrgType entries by TenantId
    List<ClientOrgType> findByTenantId(int tenantId);

    // Example: Find all ClientOrgType entries by DeletedFlag status
    List<ClientOrgType> findByDeletedFlag(boolean deletedFlag);

    // Example: Find all ClientOrgType entries by TenantId and DeletedFlag status
    List<ClientOrgType> findByTenantIdAndDeletedFlag(int tenantId, boolean deletedFlag);
}
