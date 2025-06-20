package com.careercrafter.jobportals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careercrafter.jobportals.entity.SavedJob;
import com.careercrafter.jobportals.repo.SavedJobRepo;

@RestController
@RequestMapping("/api/savedjobs")
public class SavedJobController {

    @Autowired
    private SavedJobRepo savedJobRepo;

    @GetMapping
    public List<SavedJob> getAllSavedJobs() {
        return savedJobRepo.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveJob(@RequestBody SavedJob savedJob) {
        savedJobRepo.save(savedJob);
        return ResponseEntity.ok("Job saved.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSavedJob(@PathVariable Long id) {
        if (!savedJobRepo.existsById(id)) return ResponseEntity.notFound().build();
        savedJobRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
