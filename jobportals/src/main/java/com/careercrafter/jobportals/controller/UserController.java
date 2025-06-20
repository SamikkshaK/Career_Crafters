package com.careercrafter.jobportals.controller;

import com.careercrafter.jobportals.entity.User;
import com.careercrafter.jobportals.repo.UserRepo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userRepo.existsById(user.getEmail())) {
            return ResponseEntity.badRequest().body("User already exists.");
        }
        userRepo.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<String> updateUser(@PathVariable String email, @RequestBody User updatedUser) {
        Optional<User> userOpt = userRepo.findById(email);
        if (userOpt.isEmpty()) return ResponseEntity.notFound().build();

        User existing = userOpt.get();
        existing.setFullname(updatedUser.getFullname());
        existing.setPhone(updatedUser.getPhone());
        existing.setAddress(updatedUser.getAddress());
        existing.setGender(updatedUser.getGender());
        userRepo.save(existing);

        return ResponseEntity.ok("User updated successfully.");
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        if (!userRepo.existsById(email)) {
            return ResponseEntity.notFound().build();
        }
        userRepo.deleteById(email);
        return ResponseEntity.ok("User deleted successfully.");
    }
}


