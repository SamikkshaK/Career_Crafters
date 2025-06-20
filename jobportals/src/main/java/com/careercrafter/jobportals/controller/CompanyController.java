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

import com.careercrafter.jobportals.entity.Company;
import com.careercrafter.jobportals.repo.CompanyRepo;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyRepo.save(company);
        return ResponseEntity.ok("Company added.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updated) {
        return companyRepo.findById(id).map(c -> {
            c.setName(updated.getName());
            c.setIndustry(updated.getIndustry());
            c.setDescription(updated.getDescription());
            c.setWebsite(updated.getWebsite());
            companyRepo.save(c);
            return ResponseEntity.ok("Updated");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        if (!companyRepo.existsById(id)) return ResponseEntity.notFound().build();
        companyRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}