package com.careercrafter.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private String address;
    private String gender;
    private String role; 

    public User() {}
    public User(String email, String password, String fullname, String phone, String address, String gender, String role) {
        this.email = email; 
        this.password = password; 
        this.fullname = fullname;
        this.phone = phone; 
        this.address = address; 
        this.gender = gender; 
        this.role = role;
    }
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", fullname=" + fullname + ", phone=" + phone
				+ ", address=" + address + ", gender=" + gender + ", role=" + role + "]";
	}
}

