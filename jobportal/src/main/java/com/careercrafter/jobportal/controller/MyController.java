package com.careercrafter.jobportal.controller;

import com.careercrafter.jobportal.entity.User;
import com.careercrafter.jobportal.repo.UserRepo;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String index() { 
    	return "index.jsp"; 
    	}

    @GetMapping("/register")
    public String showRegister() { 
    	return "registerPage.jsp"; 
    	}

    @PostMapping("/register")
    public String doRegister(@ModelAttribute User user) {
        userRepo.save(user);
        return "login.jsp"; 
    }

    @GetMapping("/login")
    public String showLogin() { 
    	return "login.jsp"; 
    	}
    @PostMapping("/login")
    public String doLogin(@RequestParam String email, 
                          @RequestParam String password,HttpSession session, 
                          Model model) {
        User u = userRepo.findByEmail(email);
        if (u != null && u.getPassword().equals(password)) {
        	session.setAttribute("loggedInUser", u);
            return u.getRole().equalsIgnoreCase("EMPLOYER") ? "employerhome.jsp" : "userhome.jsp";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login.jsp";
        }
    }

}
