package com.careercrafter.jobportal.repo;

import com.careercrafter.jobportal.entity.SavedJob;
import com.careercrafter.jobportal.entity.User;
import com.careercrafter.jobportal.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedJobRepo extends JpaRepository<SavedJob, Long> {
    List<SavedJob> findByUser(User user);
    boolean existsByUserAndJob(User user, JobListing job);
    void deleteByUserAndJob(User user, JobListing job);
}
