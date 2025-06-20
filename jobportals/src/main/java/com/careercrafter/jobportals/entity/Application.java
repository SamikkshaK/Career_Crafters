package com.careercrafter.jobportals.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User applicant;

    @ManyToOne
    private JobListing job;

    @Temporal(TemporalType.DATE)
    private Date appliedDate;

    private String status;  

    
    public Application() {}

    public Application(User applicant, JobListing job, Date appliedDate, String status) {
        this.applicant = applicant;
        this.job = job;
        this.appliedDate = appliedDate;
        this.status = status;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public JobListing getJob() {
		return job;
	}

	public void setJob(JobListing job) {
		this.job = job;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", applicant=" + applicant + ", job=" + job + ", appliedDate=" + appliedDate
				+ ", status=" + status + "]";
	}

    
    
}
