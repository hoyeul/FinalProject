package com.FinalProject.Model.Mypage;

public class MypageDto {
	String name;
	String id;
	String old_pw;
	String pw;
	String phone;
	String email;
	String address;
	
	public MypageDto(String name, String id, String old_pw, String pw, String phone, String email, String address) {
		super();
		this.name = name;
		this.id = id;
		this.old_pw = old_pw;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOld_pw() {
		return old_pw;
	}

	public void setOld_pw(String old_pw) {
		this.old_pw = old_pw;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
