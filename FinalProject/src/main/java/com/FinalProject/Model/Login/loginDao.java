package com.FinalProject.Model.Login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class loginDao {

	@Autowired
	private SqlSession session;
	private static String namespace = "com.FinalProject.Model.Login.loginDtoMapper.";

	public String loginConfirm(loginDto dto) {
		return session.selectOne(namespace + "loginConfirm", dto);
	}
	
	public String gradeInfo(String id) throws Exception{
		return session.selectOne(namespace + "gradeInfo", id);
	}
	
	public String findID(loginDto dto) throws Exception{
		return session.selectOne(namespace + "findID", dto);
	}
	
	public String findPW(loginDto dto) throws Exception{
		return session.selectOne(namespace + "findPW", dto);
	}
	
}
