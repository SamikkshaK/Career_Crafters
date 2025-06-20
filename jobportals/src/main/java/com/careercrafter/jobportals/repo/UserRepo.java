package com.careercrafter.jobportals.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careercrafter.jobportals.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findByEmail(String email);
}

