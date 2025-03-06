package com.grantapp.repository.cars.application;

import com.grantapp.model.cars.application.FundingOpportunityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundingOpportunityStatusRepository extends JpaRepository<FundingOpportunityStatus, Integer> {
}