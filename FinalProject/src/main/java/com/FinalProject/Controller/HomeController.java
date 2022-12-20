package com.FinalProject.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FinalProject.Model.Board.BoardDao;
import com.FinalProject.Model.Board.BoardDto;

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
	
	
	
}
