package com.zy.entity;

public class HouseSelect {
	private int h_id;
	private String h_address;
	public HouseSelect(int h_id, String h_address) {
		super();
		this.h_id = h_id;
		this.h_address = h_address;
	}
	public HouseSelect() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HouseSelect [h_id=" + h_id + ", h_address=" + h_address + "]";
	}
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	public String getH_address() {
		return h_address;
	}
	public void setH_address(String h_address) {
		this.h_address = h_address;
	}
	
}
