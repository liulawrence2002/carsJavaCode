package com.grantapp.controller;

import com.grantapp.model.FundingOpportunity;
import com.grantapp.service.FundingOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funding-opportunities")
public class FundingOpportunityController {
    @Autowired
    private FundingOpportunityService fundingOpportunityService;

    @GetMapping
    public List<FundingOpportunity> getAllFundingOpportunities() {
        return fundingOpportunityService.getAllFundingOpportunities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundingOpportunity> getFundingOpportunityById(@PathVariable Long id) {
        //System.out.println(id);
        FundingOpportunity fundingOpportunity = fundingOpportunityService.findById(id);
        if (fundingOpportunity != null) {
            return ResponseEntity.ok(fundingOpportunity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}