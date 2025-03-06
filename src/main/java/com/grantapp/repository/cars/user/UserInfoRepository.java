package com.grantapp.repository.cars.user;

import com.grantapp.model.cars.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    // Find UserInfo by UserID
    List<UserInfo> findByUserId(int userId);

    // Find UserInfo by TenantId
    List<UserInfo> findByTenantId(int tenantId);

    // Find all UserInfo that are not deleted
    List<UserInfo> findByDeletedFlagFalse();
}