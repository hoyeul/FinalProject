package com.FinalProject.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Register.RegisterDto;
import com.FinalProject.Model.Register.RegisterService;
import com.FinalProject.Model.Register.RegisterDao;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterDao service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		
		return "register/register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request) {
		//System.out.println("registerPost");
		String name = request.getParameter("name");		
			String jumin1 = request.getParameter("jumin1");
			String jumin2 = request.getParameter("jumin2");
		String jumin = jumin1 + '-' + jumin2;
		String id = request.getParameter("id");			
		String pw = request.getParameter("pw");			
			String phone1 = request.getParameter("phone1");	
			String phone2 = request.getParameter("phone2");			
			String phone3 = request.getParameter("phone3");			
		String phone = phone1 + '-' + phone2 + '-' + phone3;			
			String email1 = request.getParameter("email1");		
			String email2 = request.getParameter("email2");	
		String email = email1 + '@' + email2;
		String address = request.getParameter("address");	
		
		RegisterDto dto = new RegisterDto(name,jumin,id,pw,phone,email,address);
		System.out.println(dto);
		
		service.insert(dto);
		
		return "redirect:/login";
	}
	@ResponseBody
	@RequestMapping( value="/register/IdCheck" , method= RequestMethod.POST)
	public String IdCheckService(String userId, HttpServletRequest request,HttpServletResponse response) throws IOException { 		 
		request.setCharacterEncoding("UTF-8");
		// ajax로 값을 받기 때문에 UTF-8로 인코딩해준다
		response.setCharacterEncoding("EUC-KR");
					
		// join.jsp에서 받아온 key값이 userId이고
		// value값은 유저가 실제로 적은 값, String userId에는 value값이 들어간다.
										
		int idCheck = service.checkId(userId);
		
		// 성공여부 확인 : 개발자용
		if (idCheck == 0) {
			System.out.println("이미 존재하는 아이디입니다.");
		} else if (idCheck == 1) {
			System.out.println("사용 가능한 아이디입니다.");
		}
		
		return String.valueOf(idCheck);
		
	}
}