package com.grantapp.service;

import com.grantapp.model.Institution;
import com.grantapp.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    /**
     * Fetch all institutions from the database.
     *
     * @return List of institutions.
     */
    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }
}