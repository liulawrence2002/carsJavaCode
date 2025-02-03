package com.grantapp.service;

import com.grantapp.model.GrantApplication;
import com.grantapp.model.CarsUser;
import com.grantapp.repository.CarsUserRepository;
import com.grantapp.repository.GrantApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrantApplicationService {
    @Autowired
    private GrantApplicationRepository grantApplicationRepository;
    @Autowired
    private CarsUserRepository carsUserRepository;

    public GrantApplication save(GrantApplication grantApplication) {
        //System.out.println(grantApplication.getUserId());
        // Fetch the CarsUser object using the userId
        Long userId = grantApplication.getUserId();
        if (userId != null) {
            CarsUser user = carsUserRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
            grantApplication.setUser(user);
        } else {
            throw new RuntimeException("UserId cannot be null");
        }
        return grantApplicationRepository.save(grantApplication);
    }

    public GrantApplication update(Long id, GrantApplication grantApplication) {
        System.out.println("in save service");

        GrantApplication existingApplication = grantApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        existingApplication.setProjectTitle(grantApplication.getProjectTitle());
        existingApplication.setProjectType(grantApplication.getProjectType());
        existingApplication.setContactInfo(grantApplication.getContactInfo());
        // Update other fields as needed
        return grantApplicationRepository.save(existingApplication);
    }

    public GrantApplication submit(Long id) {
        GrantApplication application = grantApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        application.setStatus("SUBMITTED");
        return grantApplicationRepository.save(application);
    }

    public GrantApplication findById(Long id) {
        return grantApplicationRepository.findById(id).orElse(null);
    }

    public List<GrantApplication> findAllByUser_Id(Long id) {
        return grantApplicationRepository.findAllByUser_Id(id); // Directly return the list
    }
}