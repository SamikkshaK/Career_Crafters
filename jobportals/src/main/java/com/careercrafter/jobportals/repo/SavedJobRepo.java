package com.careercrafter.jobportals.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careercrafter.jobportals.entity.JobListing;
import com.careercrafter.jobportals.entity.Resume;
import com.careercrafter.jobportals.entity.SavedJob;
import com.careercrafter.jobportals.entity.User;

import java.util.List;

public interface SavedJobRepo extends JpaRepository<SavedJob, Long> {
    List<SavedJob> findByUser(User user);
    boolean existsByUserAndJob(User user, JobListing job);
    void deleteByUserAndJob(User user, JobListing job);
	void save(Resume resume);
}
