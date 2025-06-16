package com.careercrafter.jobportal.repo;

import com.careercrafter.jobportal.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobListingRepo extends JpaRepository<JobListing, Long> {

    List<JobListing> findByStatus(String status);  

    List<JobListing> findByPostedByEmail(String email);  
}
