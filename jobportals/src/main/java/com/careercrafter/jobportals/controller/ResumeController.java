package com.careercrafter.jobportals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careercrafter.jobportals.entity.Resume;
import com.careercrafter.jobportals.repo.ResumeRepo;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeRepo resumeRepo;

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeRepo.findAll();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(@RequestBody Resume resume) {
        resumeRepo.save(resume);
        return ResponseEntity.ok("Resume uploaded.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateResume(@PathVariable Long id, @RequestBody Resume updated) {
        return resumeRepo.findById(id).map(r -> {
            r.setFilePath(updated.getFilePath());
            r.setUploadedOn(updated.getUploadedOn());
            resumeRepo.save(r);
            return ResponseEntity.ok("Updated");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResume(@PathVariable Long id) {
        if (!resumeRepo.existsById(id)) return ResponseEntity.notFound().build();
        resumeRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}