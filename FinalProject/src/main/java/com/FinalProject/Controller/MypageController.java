package com.FinalProject.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Mypage.MypageDao;
import com.FinalProject.Model.Mypage.MypageDto;
import com.FinalProject.Model.Mypage.MypageService;
import com.FinalProject.Model.Register.RegisterDao;
import com.FinalProject.Model.Register.RegisterDto;

@Controller
public class MypageController {
	
	@Autowired
	MypageService service;
	
	@RequestMapping(value="/mypage", method = RequestMethod.GET)
	public String select(HttpSession session, Model model) {
		String sessionID = (String) session.getAttribute("sessionID");
		RegisterDto registerDto = service.select(sessionID);
		//System.out.println(registerDto);
		model.addAttribute("registerDto",registerDto);
		return "mypage/mypage";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request) {
		//System.out.println("mypagePost");
		String id = request.getParameter("id");			
		String name = request.getParameter("name");			
		String old_pw = request.getParameter("old_pw");			
		String pw = request.getParameter("pw");			
			String phone1 = request.getParameter("phone1");	
			String phone2 = request.getParameter("phone2");			
			String phone3 = request.getParameter("phone3");			
		String phone = phone1 + '-' + phone2 + '-' + phone3;			
			String email1 = request.getParameter("email1");		
			String email2 = request.getParameter("email2");	
		String email = email1 + '@' + email2;
		String address = request.getParameter("address");	
		
		MypageDto dto = new MypageDto(name, id, old_pw, pw, phone, email, address);
		//System.out.println(dto);
		
		service.update(dto);
		
		return "redirect:/login";
	}	
	@ResponseBody
	@RequestMapping( value="/mypage/pwCheck" , method= RequestMethod.POST)
	public String pwCheckService(String id, String old_pw, HttpServletRequest request,HttpServletResponse response) throws IOException { 		 
		request.setCharacterEncoding("UTF-8");
		// ajax로 값을 받기 때문에 UTF-8로 인코딩해준다
		response.setCharacterEncoding("EUC-KR");
		
		System.out.println(id);
		System.out.println(old_pw);
		int pwCheck = service.checkOldPw(id,old_pw);
		
		// 성공여부 확인 : 개발자용
		if (pwCheck == 1) {
			System.out.println("기존비밀번호가 일치합니다");
		} else if (pwCheck == 0) {
			System.out.println("기존비밀번호가 일치하지 않습니다");
		}
		
		return String.valueOf(pwCheck);
		
	}
}
