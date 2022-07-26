package com.bikerental.models;

import org.springframework.web.multipart.MultipartFile;

import com.bikerental.entities.Company;

public class VariantDTO {
	private String title;
	private int price;
	private Company company;
	private MultipartFile photo;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "VariantDTO [title=" + title + ", price=" + price + ", company_id=" + company + ", photo=" + photo
				+ "]";
	}
	
	
}
