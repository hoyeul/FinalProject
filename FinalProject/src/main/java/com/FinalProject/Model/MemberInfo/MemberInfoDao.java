package com.FinalProject.Model.MemberInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository 
public class MemberInfoDao { 
	@Autowired
	private SqlSession session; 
	private static String namespace = "com.FinalProject.Model.MemberInfo.MemberInfoMapper."; 
	
	//회원가입 정보 입력
	public void insert(MemberInfoDto dto) throws Exception { 
		session.insert(namespace+"insert", dto); 
	}
	
	// 아이디 중복확인
	public int checkId(String id) throws Exception { 
		int r;
		r = session.selectOne(namespace+"checkId", id); 
		return r;
	}
	
	//로그인 회원 정보 조회
	public MemberInfoDto loginMember(String sessionID) throws Exception { 
		return session.selectOne(namespace+"selectOne", sessionID); 
	}
	
	//수정된 회원정보 DB 입력
	public int update(MemberInfoDto dto) throws Exception { 
		return session.update(namespace+"update", dto); 
	}
	
	//회원정보 삭제 및 탈퇴
	public void delete(String sessionId) throws Exception { 
		session.delete(namespace+"delete", sessionId); 
	}
	
	// 기존비밀번호 일치 확인
	public String checkOldPw(String sessionId) throws Exception { 
		return session.selectOne(namespace+"checkOldPw", sessionId); 
	}
	
	//관리자 회원 삭제
	public int deleteMember(String id) throws Exception { 
		return session.delete(namespace+"deleteMember", id); 
	}
	
	//관리자 회원 정보 리스트 조회
	public List<MemberInfoDto> searchMember(String id) throws Exception { 
		return session.selectList(namespace+"searchMember", id); 
	}
	
	//관리자 회원 괸리권한 변경
	public void updateMember(MemberInfoDto dto) throws Exception { 
		session.update(namespace+"updateMember", dto); 
	}

}

