package com.FinalProject.Model.MemberInfo;

import java.util.List;

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
	
	public void insert(MemberInfoDto dto) throws Exception {
		dao.insert(dto);
	}
	
	public int checkId(String id) {
		int result = 0;
		try {
			result = dao.checkId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public MemberInfoDto mypageInfo(String sessionID) {
	MemberInfoDto result = null;
	try {
		 result = dao.loginMember(sessionID);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}
	
	public void update(MemberInfoDto dto) {
		try {
			dao.update(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 기존비밀번호 일치 확인
	public int checkOldPw(String id, String new_pw) {
		int pwCheck = 0;
		String old_pw;
		try {
			old_pw = dao.checkOldPw(id);
			if(old_pw.equals(new_pw)) {
				pwCheck = 1;  // 기존비밀번호가 일치하는 경우, 변경 가능
			} else {
				pwCheck = 0;  // 기존비밀번호가 일치하지 않는 경우, 변경불가 가능
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pwCheck;	
	}
	//로그인 회원 탈퇴
	public void withdraw(String sessionID) {
		try {
			dao.delete(sessionID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<MemberInfoDto> searchMember(String id){
		List<MemberInfoDto> result = null;
		try {
			result = dao.searchMember(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateMember(String id, String grade) {
		MemberInfoDto dto =  new MemberInfoDto(id,grade);
		try {
			dao.updateMember(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMember(String id) {
		try {
			dao.deleteMember(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
