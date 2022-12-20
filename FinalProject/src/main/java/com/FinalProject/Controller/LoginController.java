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

import com.FinalProject.Model.Login.loginDto;
import com.FinalProject.Model.Login.loginService;

@Controller
public class LoginController {

	@Autowired
	loginService s;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response, 
			loginDto dto, boolean ckbox) throws Exception {
		
		int num = s.loginConfirm(new loginDto(dto.getId(), dto.getPw()));
		
		if(num == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", dto.getId());
			if(ckbox == true) {
				Cookie cookie = new Cookie("id", dto.getId());
				response.addCookie(cookie);
				response.getWriter().print(num);
			}else {
				Cookie cookie = new Cookie("id", null);
				response.addCookie(cookie);
				response.getWriter().print(num);
			}
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
	public String findID(loginDto dto){
		
		String id = s.findID(new loginDto(dto.getName(), dto.getJumin(), dto.getEmail()));
		return id;
	}
	
	@RequestMapping(value="/findPW")
	public String findPW() {
		return "login/findPW";
	}
	
	@ResponseBody
	@RequestMapping(value="/findPW", method = RequestMethod.POST)
	public String findPW(loginDto dto){
		
		String pw = s.findPW(new loginDto(dto.getId(), dto.getName(), dto.getJumin(), dto.getEmail()));
		return pw;
	}
	
}
