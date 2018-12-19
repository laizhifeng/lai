package com.zy.entity;

import java.util.Date;

public class HouseInfo {
	private int h_id;
	private String h_region;
	private String h_estate;
	private String h_unitNumber;
	private String h_roomNo;
	private String h_area;
	private String h_orientation;
	private String h_fitment;
	private byte h_isDoubleAir;
	private int h_limit;
	private String h_facility;
	private double h_price;
	private int h_status;
	private String h_img;
	private String h_address;
	private Date h_addtime;
	private Date h_updatetime;
	
	public HouseInfo(String h_region, String h_estate, String h_unitNumber, String h_roomNo, String h_area,
			String h_orientation, String h_fitment, byte h_isDoubleAir, int h_limit, String h_facility, double h_price,
			int h_status, String h_img, String h_address) {
		super();
		this.h_region = h_region;
		this.h_estate = h_estate;
		this.h_unitNumber = h_unitNumber;
		this.h_roomNo = h_roomNo;
		this.h_area = h_area;
		this.h_orientation = h_orientation;
		this.h_fitment = h_fitment;
		this.h_isDoubleAir = h_isDoubleAir;
		this.h_limit = h_limit;
		this.h_facility = h_facility;
		this.h_price = h_price;
		this.h_status = h_status;
		this.h_img = h_img;
		this.h_address = h_address;
		
	}

	public HouseInfo(int h_id, String h_region, String h_estate, String h_unitNumber, String h_roomNo, String h_area,
			String h_orientation, String h_fitment, byte h_isDoubleAir, int h_limit, String h_facility, double h_price,
			int h_status, String h_img, String h_address, Date h_addtime, Date h_updatetime) {
		super();
		this.h_id = h_id;
		this.h_region = h_region;
		this.h_estate = h_estate;
		this.h_unitNumber = h_unitNumber;
		this.h_roomNo = h_roomNo;
		this.h_area = h_area;
		this.h_orientation = h_orientation;
		this.h_fitment = h_fitment;
		this.h_isDoubleAir = h_isDoubleAir;
		this.h_limit = h_limit;
		this.h_facility = h_facility;
		this.h_price = h_price;
		this.h_status = h_status;
		this.h_img = h_img;
		this.h_address = h_address;
		this.h_addtime = h_addtime;
		this.h_updatetime = h_updatetime;
	}

	public HouseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public String getH_region() {
		return h_region;
	}

	public void setH_region(String h_region) {
		this.h_region = h_region;
	}

	public String getH_estate() {
		return h_estate;
	}

	public void setH_estate(String h_estate) {
		this.h_estate = h_estate;
	}

	public String getH_unitNumber() {
		return h_unitNumber;
	}

	public void setH_unitNumber(String h_unitNumber) {
		this.h_unitNumber = h_unitNumber;
	}

	public String getH_roomNo() {
		return h_roomNo;
	}

	public void setH_roomNo(String h_roomNo) {
		this.h_roomNo = h_roomNo;
	}

	public String getH_area() {
		return h_area;
	}

	public void setH_area(String h_area) {
		this.h_area = h_area;
	}

	public String getH_orientation() {
		return h_orientation;
	}

	public void setH_orientation(String h_orientation) {
		this.h_orientation = h_orientation;
	}

	public String getH_fitment() {
		return h_fitment;
	}

	public void setH_fitment(String h_fitment) {
		this.h_fitment = h_fitment;
	}

	public byte getH_isDoubleAir() {
		return h_isDoubleAir;
	}

	public void setH_isDoubleAir(byte h_isDoubleAir) {
		this.h_isDoubleAir = h_isDoubleAir;
	}

	public int getH_limit() {
		return h_limit;
	}

	public void setH_limit(int h_limit) {
		this.h_limit = h_limit;
	}

	public String getH_facility() {
		return h_facility;
	}

	public void setH_facility(String h_facility) {
		this.h_facility = h_facility;
	}

	public double getH_price() {
		return h_price;
	}

	public void setH_price(double h_price) {
		this.h_price = h_price;
	}

	public int getH_status() {
		return h_status;
	}

	public void setH_status(int h_status) {
		this.h_status = h_status;
	}

	public String getH_img() {
		return h_img;
	}

	public void setH_img(String h_img) {
		this.h_img = h_img;
	}

	public String getH_address() {
		return h_address;
	}

	public void setH_address(String h_address) {
		this.h_address = h_address;
	}

	public Date getH_addtime() {
		return h_addtime;
	}

	public void setH_addtime(Date h_addtime) {
		this.h_addtime = h_addtime;
	}

	public Date getH_updatetime() {
		return h_updatetime;
	}

	public void setH_updatetime(Date h_updatetime) {
		this.h_updatetime = h_updatetime;
	}

	@Override
	public String toString() {
		return "HouseInfo [h_id=" + h_id + ", h_region=" + h_region + ", h_estate=" + h_estate + ", h_unitNumber="
				+ h_unitNumber + ", h_roomNo=" + h_roomNo + ", h_area=" + h_area + ", h_orientation=" + h_orientation
				+ ", h_fitment=" + h_fitment + ", h_isDoubleAir=" + h_isDoubleAir + ", h_limit=" + h_limit
				+ ", h_facility=" + h_facility + ", h_price=" + h_price + ", h_status=" + h_status + ", h_img=" + h_img
				+ ", h_address=" + h_address + ", h_addtime=" + h_addtime + ", h_updatetime=" + h_updatetime + "]";
	}
	
	
	
	
}
