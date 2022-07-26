package com.bikerental.models;

public class BikeDTO {
	private String id;
	private int modelyear;
	private int varid;
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
	public int getVarid() {
		return varid;
	}
	public void setVarid(int varid) {
		this.varid = varid;
	}
	@Override
	public String toString() {
		return "BikeDTO [id=" + id + ", modelyear=" + modelyear + ", varid=" + varid + "]";
	}
	
	
}
