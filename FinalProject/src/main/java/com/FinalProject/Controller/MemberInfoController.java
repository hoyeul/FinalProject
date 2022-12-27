package com.FinalProject.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.MemberInfo.MemberInfoDto;
import com.FinalProject.Model.MemberInfo.MemberInfoService;

@Controller
public class MemberInfoController {
	
	@Autowired
	MemberInfoService service;
	
	//register 화면으로 이동
	@RequestMapping(value = "/register.alreadyLogin", method = RequestMethod.GET)
	public String registerGet() {
		return "register/register";
	}
	//회원가입정보 DB 입력
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(MemberInfoDto dto) {
		service.insert(dto);
		return "redirect:/login";
	}
	//Id 중복확인
	@ResponseBody
	@RequestMapping( value="/register/IdCheck" , method= RequestMethod.POST)
	public String IdCheckService(String userId, HttpServletRequest request,HttpServletResponse response) throws IOException { 		 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("EUC-KR");						
		int idCheck = service.checkId(userId);
		return String.valueOf(idCheck);
	}
	//mypage로 화면이동
	@RequestMapping(value="/mypage.do", method = RequestMethod.GET)
	public String mypageGet(HttpSession session, Model model) {
		String sessionID = (String) session.getAttribute("sessionID");
		MemberInfoDto registerDto = service.select(sessionID);
		model.addAttribute("registerDto",registerDto);
		return "mypage/mypage";
	}
	//수정된 회원정보 DB 입력
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	public String mypagePost(MemberInfoDto dto) {	
		service.update(dto);
		return "redirect:/login";
	}	
	//기존비밀번호 일치여부 확인
	@ResponseBody
	@RequestMapping( value="/mypage/pwCheck" , method= RequestMethod.POST)
	public String pwCheckService(String id, String old_pw, HttpServletRequest request,HttpServletResponse response) throws IOException { 		 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int pwCheck = service.checkOldPw(id,old_pw);
		return String.valueOf(pwCheck);
	}
	//회원탈퇴
	@RequestMapping(value="/mypage/withdraw", method = RequestMethod.POST)
	public String withdraw(HttpSession session) {
		String sessionID = (String) session.getAttribute("sessionID");
		service.withdraw(sessionID);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/manager.onlyAdmin", method = RequestMethod.GET)
	public String managerPage(Model model) {
		List<MemberInfoDto> list = service.searchMember("");
		model.addAttribute("list", list);
		return "manager/manager";
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectManager", method = RequestMethod.POST)
	public List<MemberInfoDto> selectManager(String id) {
		List<MemberInfoDto> list = service.searchMember(id);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateManager", method = RequestMethod.POST)
	public void updateManager(String id, String grade) {
		service.updateMember(id, grade);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteManager", method = RequestMethod.POST)
	public void deleteMember(String id) {
		service.deleteMember(id);
	}
	
}