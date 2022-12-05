package com.FinalProject.Model.Register;

public class CustomerDto {
	String user_nm;
	String user_id;
	String user_pw;
	String user_phone;
	String user_email;
	String user_address;
	String user_regnum;
	
	public CustomerDto() {}
	public CustomerDto(String user_nm, String user_id, String user_pw, String user_phone, String user_email,
			String user_address, String user_regnum) {
		super();
		this.user_nm = user_nm;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_address = user_address;
		this.user_regnum = user_regnum;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_regnum() {
		return user_regnum;
	}
	public void setUser_regnum(String user_regnum) {
		this.user_regnum = user_regnum;
	}
	
	
}
