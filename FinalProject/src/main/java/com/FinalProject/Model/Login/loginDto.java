package com.FinalProject.Model.Login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginDto {

	String name;
	String jumin;
	String id;
	String pw;
	String email;
	
	public loginDto() {}
	
	public loginDto(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public loginDto(String name, String jumin, String email) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.email = email;
	}
	
	public loginDto(String id, String name, String jumin, String email) {
		super();
		this.id = id;
		this.name = name;
		this.jumin = jumin;
		this.email = email;
	}

	public loginDto(String name, String jumin, String id, String pw, String email) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.id = id;
		this.pw = pw;
		this.email = email;
	}

}
