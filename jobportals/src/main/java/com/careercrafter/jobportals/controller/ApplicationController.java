package com.careercrafter.jobportals.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.careercrafter.jobportals.entity.Application;
import com.careercrafter.jobportals.entity.JobListing;
import com.careercrafter.jobportals.entity.User;
import com.careercrafter.jobportals.repo.ApplicationRepo;
import com.careercrafter.jobportals.repo.JobListingRepo;
import com.careercrafter.jobportals.repo.UserRepo;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepo applicationRepo;

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationRepo.findAll();
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyToJob(@RequestBody Application app) {
        applicationRepo.save(app);
        return ResponseEntity.ok("Application submitted.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateApplication(@PathVariable Long id, @RequestBody Application updated) {
        return applicationRepo.findById(id).map(app -> {
            app.setStatus(updated.getStatus());
            app.setAppliedDate(updated.getAppliedDate());
            applicationRepo.save(app);
            return ResponseEntity.ok("Updated");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        if (!applicationRepo.existsById(id)) return ResponseEntity.notFound().build();
        applicationRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}