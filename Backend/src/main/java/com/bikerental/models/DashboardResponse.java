package com.bikerental.models;

public class DashboardResponse {

	private long customers;
	private long variants;
	private long companies;
	private long bikes;
	private long bookings;
	public long getCustomers() {
		return customers;
	}
	public void setCustomers(long customers) {
		this.customers = customers;
	}
	public long getVariants() {
		return variants;
	}
	public void setVariants(long variants) {
		this.variants = variants;
	}
	public long getCompanies() {
		return companies;
	}
	public void setCompanies(long companies) {
		this.companies = companies;
	}
	public long getBikes() {
		return bikes;
	}
	public void setBikes(long bikes) {
		this.bikes = bikes;
	}
	public long getBookings() {
		return bookings;
	}
	public void setBookings(long bookings) {
		this.bookings = bookings;
	}
	
	
}
