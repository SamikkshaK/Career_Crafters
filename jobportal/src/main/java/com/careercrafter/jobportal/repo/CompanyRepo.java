package com.careercrafter.jobportal.repo;

import com.careercrafter.jobportal.entity.Company;
import com.careercrafter.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
    Company findByOwner(User owner);
}
