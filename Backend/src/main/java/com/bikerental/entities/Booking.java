package com.bikerental.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int advance;
	private LocalDate fromdate;
	private LocalDate todate;
	private String message;
	private LocalDateTime bookingdate;
	private String status;
	private int billamount;
	@ManyToOne
	@JoinColumn(name="variant_id")
	private Variant variant;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="bike_id")
	private Bike bike;
	public Booking() {
		this.status="Pending";
		this.bookingdate=LocalDateTime.now();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdvance() {
		return advance;
	}
	public void setAdvance(int advance) {
		this.advance = advance;
	}
	public LocalDate getFromdate() {
		return fromdate;
	}
	public void setFromdate(LocalDate fromdate) {
		this.fromdate = fromdate;
	}
	public LocalDate getTodate() {
		return todate;
	}
	public void setTodate(LocalDate todate) {
		this.todate = todate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(LocalDateTime bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBillamount() {
		return billamount;
	}
	public void setBillamount(int billamount) {
		this.billamount = billamount;
	}
	public Variant getVariant() {
		return variant;
	}
	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", advance=" + advance + ", fromdate=" + fromdate + ", todate=" + todate
				+ ", message=" + message + ", bookingdate=" + bookingdate + ", status=" + status + ", billamount="
				+ billamount + ", variant=" + variant + ", customer=" + customer + ", bike=" + bike + "]";
	}
	
	
}
