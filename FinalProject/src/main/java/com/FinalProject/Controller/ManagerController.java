package com.FinalProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Register.RegisterDto;
import com.FinalProject.Model.Register.RegisterService;

@Controller
public class ManagerController {
	
	@Autowired
	RegisterService s;
	
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String managerPage(Model model) {
		List<RegisterDto> list = s.searchMember("");
		model.addAttribute("list", list);
		return "manager/manager";
	}
	
	@ResponseBody
	@RequestMapping(value = "/manager", method = RequestMethod.POST)
	public List<RegisterDto> manager(String id) {
		List<RegisterDto> list = s.searchMember(id);
		return list;
	}
	
	
}
