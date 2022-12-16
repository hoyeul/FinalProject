package com.FinalProject.Model.Mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FinalProject.Model.Register.RegisterDao;
import com.FinalProject.Model.Register.RegisterDto;

@Component
public class MypageService {
		
		@Autowired
		MypageDao dao;

		public MypageService() {}
		public MypageService(MypageDao dao) {
			super();
			this.dao = dao;
		}
		public RegisterDto select(String sessionID) {
			return dao.Select(sessionID);
		}
		public void update(MypageDto dto) {
			
		}
		public int checkOldPw(String id, String pw) {
			return dao.checkOldPw(id, pw);
			
		}
		public void withdraw(String sessionID) {
			dao.delete(sessionID);
			
		}
		
		
}
