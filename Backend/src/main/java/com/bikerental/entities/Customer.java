package com.bikerental.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Customer {

	@Id
	private String userid;
	private String uname;
	private String pwd;
	private String phone;
	private String gender;
	private String address;
	private String license;
	private LocalDateTime createdon;
	
	public Customer() {
		this.createdon=LocalDateTime.now();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public LocalDateTime getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", uname=" + uname + ", pwd=" + pwd + ", phone=" + phone + ", gender="
				+ gender + ", address=" + address + ", license=" + license + ", createdon=" + createdon + "]";
	}
	
	
}
