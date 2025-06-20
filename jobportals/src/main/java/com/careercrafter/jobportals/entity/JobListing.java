package com.careercrafter.jobportals.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class JobListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String skills;
    private String salary;

    @Temporal(TemporalType.DATE)
    private Date postedDate;

    private String jobType;   
    private String status;    

    @ManyToOne
    @JoinColumn(name = "posted_by_email")
    private User postedBy;    
    // Constructors
    public JobListing() {}

    public JobListing(String title, String description, String location, String skills,
                      String salary, Date postedDate, String jobType, String status, User postedBy) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.skills = skills;
        this.salary = salary;
        this.postedDate = postedDate;
        this.jobType = jobType;
        this.status = status;
        this.postedBy = postedBy;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	@Override
	public String toString() {
		return "JobListing [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", skills=" + skills + ", salary=" + salary + ", postedDate=" + postedDate + ", jobType=" + jobType
				+ ", status=" + status + ", postedBy=" + postedBy + "]";
	}

}
