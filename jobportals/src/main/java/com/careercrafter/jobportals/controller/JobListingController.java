package com.careercrafter.jobportals.controller;

import com.careercrafter.jobportals.entity.JobListing;
import com.careercrafter.jobportals.entity.User;
import com.careercrafter.jobportals.repo.JobListingRepo;
import com.careercrafter.jobportals.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobListingController {

    @Autowired
    private JobListingRepo jobRepo;

    @GetMapping
    public List<JobListing> getAllJobs() {
        return jobRepo.findAll();
    }

    @PostMapping("/post")
    public ResponseEntity<String> postJob(@RequestBody JobListing job) {
        jobRepo.save(job);
        return ResponseEntity.ok("Job posted.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody JobListing updated) {
        return jobRepo.findById(id).map(j -> {
            j.setTitle(updated.getTitle());
            j.setDescription(updated.getDescription());
            j.setLocation(updated.getLocation());
            j.setSalary(updated.getSalary());
            j.setSkills(updated.getSkills());
            jobRepo.save(j);
            return ResponseEntity.ok("Updated");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        if (!jobRepo.existsById(id)) return ResponseEntity.notFound().build();
        jobRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
