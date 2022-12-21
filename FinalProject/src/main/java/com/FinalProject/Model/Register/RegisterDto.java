package com.FinalProject.Model.Register;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterDto {
	String name;
	String jumin;
	String id;
	String pw;
	String phone;
	String email;
	String address;
	String postcode;
	String grade;
	
	public RegisterDto() {}
	
	public RegisterDto(String id, String grade) {
		this.id = id;
		this.grade = grade;
	}

	public RegisterDto(String name, String jumin, String id, String pw, String phone, String email, String address,
			String postcode, String grade) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.postcode = postcode;
		this.grade = grade;
	}
	
	

}
