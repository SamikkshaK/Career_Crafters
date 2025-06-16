package com.careercrafter.jobportal.entity;

import jakarta.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String industry;
    private String description;
    private String website;

    @OneToOne
    private User owner;  

    public Company() {}

    public Company(String name, String industry, String description, String website, User owner) {
        this.name = name;
        this.industry = industry;
        this.description = description;
        this.website = website;
        this.owner = owner;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", industry=" + industry + ", description=" + description
				+ ", website=" + website + ", owner=" + owner + "]";
	}
    
}
