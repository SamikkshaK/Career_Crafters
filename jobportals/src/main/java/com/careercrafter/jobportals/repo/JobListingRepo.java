package com.careercrafter.jobportals.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.careercrafter.jobportals.entity.JobListing;

public interface JobListingRepo extends JpaRepository<JobListing, Long> {
    List<JobListing> findByStatus(String status);
}
