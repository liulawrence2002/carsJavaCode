package com.grantapp.repository.cars.user;

import com.grantapp.model.cars.user.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserClientRepository extends JpaRepository<UserClient, Integer> {

    // Custom query methods can be added here

    // Example: Find all UserClient entries by UserID
    List<UserClient> findByUserId(int userId);

    // Example: Find all UserClient entries by ClientID
    List<UserClient> findByClientId(int clientId);

    // Example: Find all UserClient entries by TenantId
    List<UserClient> findByTenantId(int tenantId);

    // Example: Find all UserClient entries by UserID and TenantId
    List<UserClient> findByUserIdAndTenantId(int userId, int tenantId);

    // Example: Find all UserClient entries by ClientID and TenantId
    List<UserClient> findByClientIdAndTenantId(int clientId, int tenantId);

    // Example: Find all UserClient entries by DeletedFlag status
    List<UserClient> findByDeletedFlag(boolean deletedFlag);

    // Example: Find all UserClient entries by TenantId and DeletedFlag status
    List<UserClient> findByTenantIdAndDeletedFlag(int tenantId, boolean deletedFlag);
}