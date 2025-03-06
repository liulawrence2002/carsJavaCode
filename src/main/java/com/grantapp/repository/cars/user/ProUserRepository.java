package com.grantapp.repository.cars.user;

import com.grantapp.model.cars.user.ProUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProUserRepository extends JpaRepository<ProUser, Integer> {

    // Custom query methods can be added here

    // Example: Find a ProUser by UserLogin
    ProUser findByUserLogin(String userLogin);

    // Example: Find all ProUsers by TenantId
    List<ProUser> findByTenantId(Integer tenantId);

    // Example: Find all ProUsers by IsActivated status
    List<ProUser> findByIsActivated(Boolean isActivated);

    // Example: Find all ProUsers by DeletedFlag status
    List<ProUser> findByDeletedFlag(Boolean deletedFlag);

    // Example: Find all ProUsers by TenantId and IsActivated status
    List<ProUser> findByTenantIdAndIsActivated(Integer tenantId, Boolean isActivated);

    // Example: Find all ProUsers by TenantId and DeletedFlag status
    List<ProUser> findByTenantIdAndDeletedFlag(Integer tenantId, Boolean deletedFlag);

    // Example: Find all ProUsers by TenantId, IsActivated, and DeletedFlag status
    List<ProUser> findByTenantIdAndIsActivatedAndDeletedFlag(Integer tenantId, Boolean isActivated, Boolean deletedFlag);
}