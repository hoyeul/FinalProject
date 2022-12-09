package com.FinalProject.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FinalProject.Model.Mypage.MypageDao;
import com.FinalProject.Model.Register.RegisterDao;
import com.FinalProject.Model.Register.RegisterDto;

@Controller
public class MypageController {
	
	@Autowired
	MypageDao dao;
	
	@RequestMapping(value="/mypage", method = RequestMethod.GET)
	public String select(HttpSession session, Model model) {
		String sessionID = (String) session.getAttribute("sessionID");
		RegisterDto registerDto = dao.select(sessionID);
		System.out.println(registerDto);
		model.addAttribute("registerDto",registerDto);
		return "mypage/mypage";
	}
	
}
