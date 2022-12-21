package com.FinalProject.Model.MemberInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MemberInfoDto {
	String name;
	String jumin;
	String id;
	String pw;
	String phone;
	String email;
	String postcode;
	String roadAddress;
	String detailAddress;
	String grade;
	
	public MemberInfoDto(){}
	public MemberInfoDto(String name, String id, String pw, String phone, String email, String postcode,
			String roadAddress, String detailAddress) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.postcode = postcode;
		this.roadAddress = roadAddress;
		this.detailAddress = detailAddress;
	}
	public MemberInfoDto(String name, String jumin, String id, String pw, String phone, String email, String postcode,
			String roadAddress, String detailAddress) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.postcode = postcode;
		this.roadAddress = roadAddress;
		this.detailAddress = detailAddress;
	}
	
	
	
}
