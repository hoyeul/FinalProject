package com.FinalProject.Model.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class loginService {

	@Autowired
	loginDao dao;
	
	public loginService() {}
	
	public loginService(loginDao dao) {
		super();
		this.dao = dao;
	}

	public int loginConfirm(loginDto dto) {
		return dao.loginConfirm(dto);
	}
	
	public String findID(loginDto dto) {
		return dao.findID(dto);
	}
	
	public String findPW(loginDto dto) {
		return dao.findPW(dto);
	}
	
}
