package com.bikerental.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@DynamicInsert
public class Bike {

	@Id
	private String id;
	private int modelyear;
	private String status;
	@ManyToOne
	@JoinColumn(name="variant_id")
	private Variant variant;
	private boolean isdeleted;
	private LocalDateTime createdon;
	public Bike() {
		// TODO Auto-generated constructor stub
		this.createdon=LocalDateTime.now();
		this.isdeleted=false;
		this.status="Available";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getModelyear() {
		return modelyear;
	}
	public void setModelyear(int modelyear) {
		this.modelyear = modelyear;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Variant getVariant() {
		return variant;
	}
	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	public boolean isIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", modelyear=" + modelyear + ", status=" + status + ", variant=" + variant
				+ ", isdeleted=" + isdeleted + ", createdon=" + createdon + "]";
	}
	
	
}
