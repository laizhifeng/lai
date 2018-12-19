package com.zy.entity;

import java.util.Date;

public class Tenant {
	private int t_id;
	private String t_name;
	private String t_phone;
	private String t_sex;
	private String t_native;
	private String t_IDnumber;
	private int h_id;
	private Date t_addtime;
	private Date t_updatetime;
	
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tenant(String t_name, String t_phone, String t_sex, String t_native, String t_IDnumber, int h_id
			) {
		super();
		this.t_name = t_name;
		this.t_phone = t_phone;
		this.t_sex = t_sex;
		this.t_native = t_native;
		this.t_IDnumber = t_IDnumber;
		this.h_id = h_id;
	}
	
	public Tenant(int t_id, String t_name, String t_phone, String t_sex, String t_native, String t_IDnumber, int h_id,
			Date t_addtime, Date t_updatetime) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_phone = t_phone;
		this.t_sex = t_sex;
		this.t_native = t_native;
		this.t_IDnumber = t_IDnumber;
		this.h_id = h_id;
		this.t_addtime = t_addtime;
		this.t_updatetime = t_updatetime;
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

	public String getT_phone() {
		return t_phone;
	}

	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}

	public String getT_sex() {
		return t_sex;
	}

	public void setT_sex(String t_sex) {
		this.t_sex = t_sex;
	}

	public String getT_native() {
		return t_native;
	}

	public void setT_native(String t_native) {
		this.t_native = t_native;
	}

	public String getT_IDnumber() {
		return t_IDnumber;
	}

	public void setT_IDnumber(String t_IDnumber) {
		this.t_IDnumber = t_IDnumber;
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public Date getT_addtime() {
		return t_addtime;
	}

	public void setT_addtime(Date t_addtime) {
		this.t_addtime = t_addtime;
	}

	public Date getT_updatetime() {
		return t_updatetime;
	}

	public void setT_updatetime(Date t_updatetime) {
		this.t_updatetime = t_updatetime;
	}

	@Override
	public String toString() {
		return "Tenant [t_id=" + t_id + ", t_name=" + t_name + ", t_phone=" + t_phone + ", t_sex=" + t_sex
				+ ", t_native=" + t_native + ", t_IDnumber=" + t_IDnumber + ", h_id=" + h_id + ", t_addtime="
				+ t_addtime + ", t_updatetime=" + t_updatetime + "]";
	}

}
