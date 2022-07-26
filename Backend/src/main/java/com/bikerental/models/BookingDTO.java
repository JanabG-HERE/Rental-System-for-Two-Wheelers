package com.bikerental.models;

import java.time.LocalDate;

import com.bikerental.entities.Customer;
import com.bikerental.entities.Variant;

public class BookingDTO {
	private int advance;
	private LocalDate fromdate;
	private LocalDate todate;
	private String message;
	private int billamount;
	private String cardno;
	private String nameoncard;
	private String userid;
	private int varid;
	
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
	public int getBillamount() {
		return billamount;
	}
	public void setBillamount(int billamount) {
		this.billamount = billamount;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getNameoncard() {
		return nameoncard;
	}
	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getVarid() {
		return varid;
	}
	public void setVarid(int varid) {
		this.varid = varid;
	}
	@Override
	public String toString() {
		return "BookingDTO [advance=" + advance + ", fromdate=" + fromdate + ", todate=" + todate + ", message="
				+ message + ", billamount=" + billamount + ", cardno=" + cardno + ", nameoncard=" + nameoncard
				+ ", userid=" + userid + ", varid=" + varid + "]";
	}

	
	
}
