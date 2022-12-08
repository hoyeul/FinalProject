package com.FinalProject.Model.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterService {
	
	@Autowired
	RegisterDao dao;

	public RegisterService() {}
	public RegisterService(RegisterDao dao) {
		super();
		this.dao = dao;
	}
	
	public void insert(RegisterDto dto) {
		
	}
	public int checkId(String id) {
		return dao.checkId(id);
		
	}
	
	
}
