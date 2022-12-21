package com.FinalProject.Controller;


import java.util.ArrayList;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Board.BoardDao;
import com.FinalProject.Model.Board.BoardDto;
import com.FinalProject.Model.Embassy.EmbassyService;

@Controller
public class HomeController {
	
	@Autowired
	BoardDao dao;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		ArrayList<BoardDto> list = dao.arrayRecent();
		 model.addAttribute("list", list);
		return "home/home";
	}
	

	@ResponseBody
	@RequestMapping(value="/embassy", method = RequestMethod.POST)
	public JSONArray embassy() throws Exception {
		EmbassyService s = new EmbassyService();
		JSONArray array = s.embassy();
		return array;
	}

	
}
