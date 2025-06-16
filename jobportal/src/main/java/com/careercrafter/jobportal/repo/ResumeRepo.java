package com.careercrafter.jobportal.repo;

import com.careercrafter.jobportal.entity.Resume;
import com.careercrafter.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepo extends JpaRepository<Resume, Long> {

    Resume findByUser(User user);
}
