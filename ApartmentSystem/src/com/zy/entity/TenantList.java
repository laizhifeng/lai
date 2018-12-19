package com.zy.entity;

public class TenantList {
	private int t_id;
	private String t_name;
	private String h_address;
	public TenantList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TenantList(int t_id, String t_name, String h_address) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.h_address = h_address;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getH_address() {
		return h_address;
	}
	public void setH_address(String h_address) {
		this.h_address = h_address;
	}
	@Override
	public String toString() {
		return "TenantList [t_id=" + t_id + ", t_name=" + t_name + ", h_address=" + h_address + "]";
	}
	
}
