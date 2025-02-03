package com.grantapp.controller;

import com.grantapp.model.Institution;
import com.grantapp.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    /**
     * Fetch all institutions from the database.
     *
     * @return List of institutions.
     */
    @GetMapping
    public List<Institution> getAllInstitutions() {
        return institutionService.getAllInstitutions();
    }
}