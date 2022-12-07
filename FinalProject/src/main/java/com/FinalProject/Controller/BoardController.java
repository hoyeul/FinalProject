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
public class BoardController {
	
	@Autowired
	BoardDao dao;
	
	@RequestMapping(value ="/board", method = RequestMethod.GET)
	public String array(Model model) {

		ArrayList<BoardDto> list = dao.Array();
		System.out.println(list);
		model.addAttribute("list", list);

		return "Board/Board";
	}
	
	@RequestMapping(value ="/boardreg", method = RequestMethod.GET)
	public String boardreg(Model model) {
		
		return "Board/Boardreg";
	}
	
	@RequestMapping(value ="/boardreg", method = RequestMethod.POST)
	public String Board_insert(BoardDto dto) {
		
		dao.boardreg(dto.getContinent(), dto.getSelect(), dto.getTitle(), dto.getText());
		
		return "redirect:/board";
	}
	
}