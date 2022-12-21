package com.FinalProject.Model.MemberInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberInfoService {
	
	@Autowired
	MemberInfoDao dao;

	public MemberInfoService() {}
	public MemberInfoService(MemberInfoDao dao) {
		super();
		this.dao = dao;
	}
	
	public void insert(MemberInfoDto dto) {
		dao.insert(dto);
	}
	
	public int checkId(String id) {
		return dao.checkId(id);
	}
	
	public MemberInfoDto select(String sessionID) {
	return dao.select(sessionID);
	}
	
	public void update(MemberInfoDto dto) {
		dao.update(dto);
	}
	
	public int checkOldPw(String id, String pw) {
		return dao.checkOldPw(id, pw);	
	}
	
	public void withdraw(String sessionID) {
		dao.delete(sessionID);
	}
	
}
