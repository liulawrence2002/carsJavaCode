package com.grantapp.service;

import com.grantapp.model.FundingOpportunity;
import com.grantapp.repository.FundingOpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundingOpportunityService {
    @Autowired
    private FundingOpportunityRepository fundingOpportunityRepository;

    public List<FundingOpportunity> getAllFundingOpportunities() {
        return fundingOpportunityRepository.findAll();
    }

    public FundingOpportunity findById(Long id) {
        return fundingOpportunityRepository.findById(id).orElse(null);
    }
    
    public List<FundingOpportunity> findAllByProgram(String program) {
        return fundingOpportunityRepository.findAllByProgram(program);
    }
}