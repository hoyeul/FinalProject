package com.FinalProject.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Board.BoardDao;
import com.FinalProject.Model.Board.BoardDto;
import com.FinalProject.Model.Board.CommentDto;
import com.FinalProject.Model.Board.PageDto;
import com.FinalProject.Model.Board.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	BoardDao dao;
	

	@RequestMapping(value ="/board", method = RequestMethod.GET)
	public String array(Model model,String p) {
		int page=0;
		if(p == null) {
			page=1;
		}else {
			page=Integer.parseInt(p);
		}
		System.out.println(page);
		ArrayList<BoardDto> list = dao.ArrayTen(page);
		model.addAttribute("a", dao.count());
		model.addAttribute("list", list);
		 model.addAttribute("p", page);
		
		return "Board/Board";
	}
	
	@RequestMapping(value ="/boardreg", method = RequestMethod.GET)
	public String boardreg(Model model) {
		
		return "Board/Boardreg";
	}
	
	@RequestMapping(value ="boardreg", method = RequestMethod.POST)
	public String Board_insert(BoardDto dto) {
		
		dao.boardreg(dto.getContinent(), dto.getSelect(), dto.getTitle(), dto.getText());
		
		return "redirect:/board";
	}
	@RequestMapping(value ="/boardIn", method = RequestMethod.GET)
	public String array2(BoardDto dto,Model m) {
		int s = dto.getNum();
		System.out.println("d1231231="+s);
		int b= dto.getNumber()+1;
		dao.updateNum(b, s);
		BoardDto a =dao.select(s);
		System.out.println("dasdasdasda="+a);
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
		BoardDto a =dao.select(s);
		m.addAttribute("a",a);
		return "Board/BoardUp";
	}
	@RequestMapping(value ="boardUp",produces="text/plain;charset=UTF-8" ,method = RequestMethod.POST)
	public String Up2(BoardDto dto) {	
		dao.update(dto);
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