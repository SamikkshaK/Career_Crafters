package com.careercrafter.jobportals.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careercrafter.jobportals.entity.Resume;
import com.careercrafter.jobportals.entity.User;

public interface ResumeRepo extends JpaRepository<Resume, Long> {

    Resume findByUser(User user);
}
