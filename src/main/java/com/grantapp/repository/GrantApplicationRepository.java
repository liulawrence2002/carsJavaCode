package com.grantapp.repository;

import com.grantapp.model.GrantApplication;
import com.grantapp.model.CarsUser;
import com.grantapp.model.FundingOpportunity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GrantApplicationRepository extends JpaRepository<GrantApplication, Long> {
    List<GrantApplication> findAllByUser_Id(Long userId);
    Optional<GrantApplication> findByProposalId(String proposalId);
    
    List<GrantApplication> findAllByOpportunityInAndUser(List<FundingOpportunity> opportunities, CarsUser user);

}