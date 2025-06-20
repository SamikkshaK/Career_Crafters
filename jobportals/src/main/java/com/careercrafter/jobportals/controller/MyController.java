package com.careercrafter.jobportals.controller;

import com.careercrafter.jobportals.entity.Application;
import com.careercrafter.jobportals.entity.Company;
import com.careercrafter.jobportals.entity.JobListing;
import com.careercrafter.jobportals.entity.Resume;
import com.careercrafter.jobportals.entity.SavedJob;
import com.careercrafter.jobportals.entity.User;
import com.careercrafter.jobportals.repo.ApplicationRepo;
import com.careercrafter.jobportals.repo.CompanyRepo;
import com.careercrafter.jobportals.repo.JobListingRepo;
import com.careercrafter.jobportals.repo.SavedJobRepo;
import com.careercrafter.jobportals.repo.UserRepo;
import com.careercrafter.jobportals.repo.ResumeRepo;


import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JobListingRepo jobListingRepo;
    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private SavedJobRepo savedJobRepo;
    @Autowired
    private ResumeRepo resumeRepo;
    @Autowired
    private CompanyRepo companyRepo;


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
    @PostMapping("/postJob")
    public String postJob(@ModelAttribute JobListing job, HttpSession session) {
        User employer = (User) session.getAttribute("loggedInUser");
        if (employer != null && "EMPLOYER".equalsIgnoreCase(employer.getRole())) {
            job.setPostedBy(employer);
            job.setStatus("OPEN");
            job.setPostedDate(new Date());
            jobListingRepo.save(job); 
        }
        return "redirect:/employerhome.jsp";
    }
    @GetMapping("/search")
    public String showAvailableJobs(Model model) {
        List<JobListing> openJobs = jobListingRepo.findByStatus("OPEN");
        model.addAttribute("jobList", openJobs);
        return "searchJob.jsp"; 
    }
 
    @GetMapping("/updateProfile")
    public String updateProfilePage() {
        return "updateProfile.jsp";
    }

    
    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute User updatedUser, HttpSession session) {
        User sessionUser = (User) session.getAttribute("loggedInUser");
        if (sessionUser != null) {
            sessionUser.setFullname(updatedUser.getFullname());
            sessionUser.setPhone(updatedUser.getPhone());
            sessionUser.setAddress(updatedUser.getAddress());
            userRepo.save(sessionUser);
            session.setAttribute("loggedInUser", sessionUser); // update session data
        }
        return "userhome.jsp";
    }

    
    @GetMapping("/manageApplications")
    public String showApplications(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        List<Application> apps = applicationRepo.findByApplicantEmail(user.getEmail());
        model.addAttribute("applications", apps);
        return "manageApplication.jsp";
    }

    
    @GetMapping("/updateResume")
    public String showUploadResumePage() {
        return "updateResume.jsp";
    }

    
    @GetMapping("/savedJobs")
    public String showSavedJobs(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        List<SavedJob> savedJobs = savedJobRepo.findByUser(user);
        model.addAttribute("savedJobs", savedJobs);
        return "savedJobs.jsp";
    }

    
    @GetMapping("/removeSavedJob")
    public String removeSavedJob(@RequestParam Long jobId, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        JobListing job = jobListingRepo.findById(jobId).orElse(null);
        if (job != null && savedJobRepo.existsByUserAndJob(user, job)) {
            savedJobRepo.deleteByUserAndJob(user, job);
        }
        return "redirect:/savedJobs";
    }
    @PostMapping("/uploadResume")
    public String handleResumeUpload(@RequestParam("resumeFile") MultipartFile file,
                                      HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || file.isEmpty()) {
            model.addAttribute("error", "No file selected or user not logged in.");
            return "updateResume.jsp";
        }

        try {
            
            String filename = file.getOriginalFilename();
            String uploadPath = new File("src/main/resources/static/resumes").getAbsolutePath();
            File dest = new File(uploadPath, filename);
            file.transferTo(dest);

            
            Resume resume = new Resume(user, "/resumes/" + filename, new Date());
            resumeRepo.save(resume); 

            model.addAttribute("message", "Resume uploaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Upload failed.");
        }

        return "updateResume.jsp";
    }
    @GetMapping("/postJobPage")
    public String showPostJobPage() {
        return "postJob.jsp";
    }

    
    @GetMapping("/manageJobs")
    public String manageJobs(HttpSession session, Model model) {
        User employer = (User) session.getAttribute("loggedInUser");
        List<JobListing> jobs = jobListingRepo.findAll().stream()
                .filter(job -> job.getPostedBy().getEmail().equals(employer.getEmail()))
                .toList();
        model.addAttribute("jobList", jobs);
        return "manageJobs.jsp";
    }

    @GetMapping("/closeJob")
    public String closeJob(@RequestParam Long id) {
        JobListing job = jobListingRepo.findById(id).orElse(null);
        if (job != null) {
            job.setStatus("CLOSED");
            jobListingRepo.save(job);
        }
        return "redirect:/manageJobs";
    }

    
    @GetMapping("/employerApplications")
    public String viewApplications(HttpSession session, Model model) {
        User employer = (User) session.getAttribute("loggedInUser");

        List<Application> apps = applicationRepo.findAll().stream()
                .filter(app -> app.getJob().getPostedBy().getEmail().equals(employer.getEmail()))
                .toList();

        model.addAttribute("applications", apps);
        return "employerApplications.jsp";
    }

    // 🔹 Update Company Profile
    @GetMapping("/updateCompanyProfile")
    public String updateCompanyForm(HttpSession session, Model model) {
        User employer = (User) session.getAttribute("loggedInUser");
        Company company = companyRepo.findByOwner(employer);

        if (company == null) {
            company = new Company();
        }

        model.addAttribute("company", company);
        return "updateCompanyProfile.jsp";
    }

    @PostMapping("/updateCompany")
    public String updateCompanyProfile(@ModelAttribute Company company, HttpSession session) {
        User employer = (User) session.getAttribute("loggedInUser");
        company.setOwner(employer);
        companyRepo.save(company);
        return "redirect:/updateCompanyProfile";
    }

   
    @GetMapping("/resumeDatabase")
    public String resumeDatabase(Model model) {
        List<Resume> resumes = resumeRepo.findAll();
        model.addAttribute("resumes", resumes);
        return "resumeDatabase.jsp";
    }

}


