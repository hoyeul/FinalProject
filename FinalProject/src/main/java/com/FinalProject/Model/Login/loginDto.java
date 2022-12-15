package com.FinalProject.Model.Login;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
