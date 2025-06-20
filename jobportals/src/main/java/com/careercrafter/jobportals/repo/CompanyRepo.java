package com.careercrafter.jobportals.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careercrafter.jobportals.entity.Company;
import com.careercrafter.jobportals.entity.User;

public interface CompanyRepo extends JpaRepository<Company, Long> {
    Company findByOwner(User owner);
}
