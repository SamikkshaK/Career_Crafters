package com.careercrafter.jobportals.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String filePath;   

    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadedOn;

   
    public Resume() {}

    public Resume(User user, String filePath, Date uploadedOn) {
        this.user = user;
        this.filePath = filePath;
        this.uploadedOn = uploadedOn;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	@Override
	public String toString() {
		return "Resume [id=" + id + ", user=" + user + ", filePath=" + filePath + ", uploadedOn=" + uploadedOn + "]";
	}

}
