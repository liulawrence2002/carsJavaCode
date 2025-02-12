package com.grantapp.service;

import com.grantapp.model.CarsUser;
import com.grantapp.model.FundingOpportunity;
import com.grantapp.repository.CarsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsUserService {

    @Autowired
    private CarsUserRepository carsUserRepository;

    public List<CarsUser> getAllCarsUser() {
        return carsUserRepository.findAll();
    }
    public CarsUser findById(Long id) {
        return carsUserRepository.findById(id).orElse(null);
    }

}