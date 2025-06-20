package com.careercrafter.jobportals.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.careercrafter.jobportals.entity.Application;

public interface ApplicationRepo extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a WHERE a.applicant.email = :email")
    List<Application> findByApplicantEmail(String email);

    @Query("SELECT a FROM Application a WHERE a.job.id = :jobId")
    List<Application> findByJobId(Long jobId);
}
