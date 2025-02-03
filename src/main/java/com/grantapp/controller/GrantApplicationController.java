package com.grantapp.controller;

import com.grantapp.model.FundingOpportunity;
import com.grantapp.model.GrantApplication;
import com.grantapp.service.GrantApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/grant-applications")
public class GrantApplicationController {
    @Autowired
    private GrantApplicationService grantApplicationService;

    @PostMapping("/createGrantApplication")
    public ResponseEntity<GrantApplication> createGrantApplication(@Valid @RequestBody GrantApplication grantApplication) {
        GrantApplication savedApplication = grantApplicationService.save(grantApplication);
        //System.out.println(savedApplication.getId());
        return ResponseEntity.ok(savedApplication);
    }

    @PutMapping("/updateGrantApplication/{id}")
    public ResponseEntity<GrantApplication> updateGrantApplication(@PathVariable Long id, @RequestBody GrantApplication grantApplication) {
        System.out.println("123456");
        GrantApplication updatedApplication = grantApplicationService.update(id, grantApplication);
        return ResponseEntity.ok(updatedApplication);
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<GrantApplication> submitGrantApplication(@PathVariable Long id) {
        GrantApplication submittedApplication = grantApplicationService.submit(id);
        return ResponseEntity.ok(submittedApplication);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrantApplication> getGrantApplicationById(@PathVariable Long id) {
        GrantApplication grantApplication = grantApplicationService.findById(id);
        if (grantApplication != null) {
            return ResponseEntity.ok(grantApplication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{id}")
    public List<GrantApplication> getGrantApplicationByUser(@PathVariable Long id) {
        //System.out.println(123);
        return grantApplicationService.findAllByUser_Id(id);
    }

}