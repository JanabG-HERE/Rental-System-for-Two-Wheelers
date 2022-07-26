package com.bikerental.models;

public class BookingCompleteDTO {

	private int bid;
	private int amount;
	private int ratings;
	private String cardno;
	private String nameoncard;
	private String feedback;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
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
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "BookingCompleteDTO [bid=" + bid + ", amount=" + amount + ", ratings=" + ratings + ", cardno=" + cardno
				+ ", nameoncard=" + nameoncard + ", feedback=" + feedback + "]";
	}
	
	
}
