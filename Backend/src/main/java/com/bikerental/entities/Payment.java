package com.bikerental.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate pmtdate;
	private String cardno;
	private String remarks;
	private String nameoncard;
	private int amount;
	private boolean iscompleted;
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	public Payment() {
		this.pmtdate=LocalDate.now();
		this.iscompleted=false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getPmtdate() {
		return pmtdate;
	}
	public void setPmtdate(LocalDate pmtdate) {
		this.pmtdate = pmtdate;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getNameoncard() {
		return nameoncard;
	}
	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isIscompleted() {
		return iscompleted;
	}
	public void setIscompleted(boolean iscompleted) {
		this.iscompleted = iscompleted;
	}
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", pmtdate=" + pmtdate + ", cardno=" + cardno + ", remarks=" + remarks
				+ ", nameoncard=" + nameoncard + ", amount=" + amount + ", iscompleted=" + iscompleted + "]";
	}
	
	
}
