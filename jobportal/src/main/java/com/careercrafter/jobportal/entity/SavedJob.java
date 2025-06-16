package com.careercrafter.jobportal.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class SavedJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private JobListing job;

    @Temporal(TemporalType.TIMESTAMP)
    private Date savedOn;

    public SavedJob() {}

    public SavedJob(User user, JobListing job, Date savedOn) {
        this.user = user;
        this.job = job;
        this.savedOn = savedOn;
    }

  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JobListing getJob() {
		return job;
	}

	public void setJob(JobListing job) {
		this.job = job;
	}

	public Date getSavedOn() {
		return savedOn;
	}

	public void setSavedOn(Date savedOn) {
		this.savedOn = savedOn;
	}

	@Override
	public String toString() {
		return "SavedJob [id=" + id + ", user=" + user + ", job=" + job + ", savedOn=" + savedOn + "]";
	}
}
