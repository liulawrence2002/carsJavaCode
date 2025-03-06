package com.grantapp.repository.cars.user;

import com.grantapp.model.cars.user.UserOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserOrganizationRepository extends JpaRepository<UserOrganization, Integer> {

    // Find all UserOrganizations by UserInfoId
    @Query("SELECT uo FROM UserOrganization uo WHERE uo.userInfo.id = :userInfoId")
    List<UserOrganization> findByUserInfoId(@Param("userInfoId") int userInfoId);

    // Find all UserOrganizations by UserOrgId
    @Query("SELECT uo FROM UserOrganization uo WHERE uo.userOrg.id = :userOrgId")
    List<UserOrganization> findByUserOrgId(@Param("userOrgId") int userOrgId);

    // Find all UserOrganizations by TenantId
    @Query("SELECT uo FROM UserOrganization uo WHERE uo.tenant.id = :tenantId")
    List<UserOrganization> findByTenantId(@Param("tenantId") int tenantId);

    // Find all UserOrganizations that are not deleted
    List<UserOrganization> findByDeletedFlagFalse();
}