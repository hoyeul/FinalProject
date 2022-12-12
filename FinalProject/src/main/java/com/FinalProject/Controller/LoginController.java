package com.FinalProject.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Login.loginDao;
import com.FinalProject.Model.Login.loginDto;
import com.FinalProject.Model.Login.loginService;

@Controller
public class LoginController {

	@Autowired
	loginDao dao;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response, 
			String id, String pw) throws Exception {
		
		loginService s = new loginService(dao);
		int num = s.loginConfirm(new loginDto(id, pw));
		
		if(num == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", id);
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
			response.getWriter().print(num);
		}
		else	{
			response.getWriter().print(num);
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "home/home";
	}
	
	@RequestMapping(value="/findID")
	public String findID() {
		return "login/findID";
	}
	
	@ResponseBody
	@RequestMapping(value="/findID", method = RequestMethod.POST)
	public String findID(String nm, String jumin1, String jumin2, String email1, String email2){
		
		String jumin = jumin1 + "-" + jumin2;
		String email = email1 + "@" + email2;
		
		loginService s = new loginService(dao);
		String id = s.findID(new loginDto(nm, jumin, email));
		return id;
	}
	
	@RequestMapping(value="/findPW")
	public String findPW() {
		return "login/findPW";
	}
	
	@ResponseBody
	@RequestMapping(value="/findPW", method = RequestMethod.POST)
	public String findPW(String nm, String jumin1, String jumin2, String id, String email1, String email2){
		
		String jumin = jumin1 + "-" + jumin2;
		String email = email1 + "@" + email2;
		
		loginService s = new loginService(dao);
		String pw = s.findPW(new loginDto(nm, jumin, id, email));
		return pw;
	}
	
}
