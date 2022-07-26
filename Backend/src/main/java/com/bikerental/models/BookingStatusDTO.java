package com.bikerental.models;

public class BookingStatusDTO {
	private int bid;
	private String status;
	private String bno;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "BookingStatusDTO [bid=" + bid + ", status=" + status + ", bno=" + bno + "]";
	}
	
	
}
