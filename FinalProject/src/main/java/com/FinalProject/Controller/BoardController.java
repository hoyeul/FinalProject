package com.FinalProject.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Board.BoardDao;
import com.FinalProject.Model.Board.BoardDto;
import com.FinalProject.Model.Register.CommentDto;

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
		System.out.println("post boardreg");
		return "redirect:/board";
	}
	
	@RequestMapping(value ="/boardIn", method = RequestMethod.GET)
	public String array2(BoardDto dto,Model m) {
		int s = dto.getNum();
		int b= dto.getNumber()+1;
		dao.updateNum(b, s);
		BoardDto a =dao.select(s);
		m.addAttribute("a",a);
		return "Board/BoardIn";
	}
	
	@ResponseBody
	@RequestMapping(value ="/RegIn", method = RequestMethod.GET)
	public ArrayList<CommentDto> Reg(CommentDto dto,Model m) {
		int s = dto.getCnum();
		System.out.println(s);
		ArrayList<CommentDto> list = dao.ArrayCM(s);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value ="/boardUp", method = RequestMethod.GET)
	public String Up1(BoardDto dto,Model m) {
		int s = dto.getNum();
		BoardDto a = dao.select(s);
		m.addAttribute("a",a);
		return "Board/BoardUp";
	}

	@RequestMapping(value ="boardUp",produces="text/plain;charset=UTF-8" ,method = RequestMethod.POST)
	public String Up2(BoardDto dto) {	
		dao.update(dto);
		System.out.println();
		return "redirect:/boardIn?num="+dto.getNum()+"";
	}

	@RequestMapping(value ="/boardDE", method = RequestMethod.GET)
	public String delete(BoardDto dto) {
		System.out.println(dto.getNum());
		int s = dto.getNum();
		System.out.println(s);
		dao.delet(s);
		return "redirect:/board";
	}
	@ResponseBody
	@RequestMapping(value ="/CommentDE", method = RequestMethod.GET)
	public String deleteCM( CommentDto dto) {
		int s = dto.getNum();
		dao.deletCM(s);
		return "Board/BoardIn";
	}
	
	@ResponseBody
	@RequestMapping(value ="/CommentUP", method = RequestMethod.POST)
	public String UpdateCM(  CommentDto dto) {
		dao.update(dto);
		return "Board/BoardIn";
	}
	@ResponseBody
	@RequestMapping(value = "/CommentReg", method = RequestMethod.POST)
	public String member2(CommentDto dto) {	
		dao.insert(dto);
		return "Board/BoardIn";
	}
}