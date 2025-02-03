package com.grantapp.repository;

import com.grantapp.model.FundingOpportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundingOpportunityRepository extends JpaRepository<FundingOpportunity, Long> {
}