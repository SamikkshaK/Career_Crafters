package com.careercrafter.jobportal;



import com.careercrafter.jobportal.entity.User;
import com.careercrafter.jobportal.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CareerCrafterJobPortalApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    void setup() {

        userRepo.deleteAll();


        User user = new User(
                "employer@example.com", "password123", "Test Employer",
                "9876543210", "Office City", "Female", "EMPLOYER"
        );
        userRepo.save(user);
    }

    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(post("/login")
                .param("email", "employer@example.com")
                .param("password", "password123"))
                .andExpect(status().isOk())
                .andExpect(view().name("employerhome.jsp"));
    }

    @Test
    void testLoginFailure() throws Exception {
        mockMvc.perform(post("/login")
                .param("email", "wrong@example.com")
                .param("password", "wrongpass"))
                .andExpect(status().isOk())
                .andExpect(view().name("login.jsp"));
    }

    @Test
    void testUserRepositoryFind() {
        User found = userRepo.findByEmail("employer@example.com");
        assertNotNull(found);
        assertEquals("Test Employer", found.getFullname());
        assertEquals("EMPLOYER", found.getRole());
    }
}
