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
		int num = 0;
		String pw = dao.loginConfirm(dto);
		if(pw != null) {
			if(pw.equals(dto.getPw()))	num = 1;
			else						num = 0;
		}else	num = -1;
		return num;
	}
	
	public String gradeInfo(String id) throws Exception{
		return dao.gradeInfo(id);
	}
	
	public String findID(loginDto dto) throws Exception{
		return dao.findID(dto);
	}
	
	public String findPW(loginDto dto) throws Exception{
		return dao.findPW(dto);
	}
	
}
