package com.careercrafter.jobportal.repo;

import com.careercrafter.jobportal.entity.Application;
import com.careercrafter.jobportal.entity.User;
import com.careercrafter.jobportal.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepo extends JpaRepository<Application, Long> {

    List<Application> findByApplicant(User user);

    List<Application> findByJob(JobListing job);
}
