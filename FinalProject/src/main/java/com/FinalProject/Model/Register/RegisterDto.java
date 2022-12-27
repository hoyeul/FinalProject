package com.FinalProject.Model.Register;

public class RegisterDto {
	String name;
	String jumin;
	String id;
	String pw;
	String phone;
	String email;
	String address;
	String postcode;

	public RegisterDto() {}
	public RegisterDto(String name, String id, String pw, String phone, String email,String address) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public RegisterDto(String name, String jumin, String id, String pw, String phone, String email, String address, String postcode) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.postcode = postcode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@Override
	public String toString() {
		return "RegisterDto [name=" + name + ", jumin=" + jumin + ", id=" + id + ", pw=" + pw + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", postcode=" + postcode + "]";
	}
	
	
}
