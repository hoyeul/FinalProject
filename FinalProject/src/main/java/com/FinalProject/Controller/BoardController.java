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
import com.FinalProject.Model.Board.CommentDto;

import com.FinalProject.Model.Board.SearchDto;

@Controller
public class BoardController {
   
   @Autowired
   BoardDao dao;
   
   @RequestMapping(value ="/board", method = RequestMethod.GET)
   public String array(Model model,String p,String continent,SearchDto dto) {
      String text=dto.getText();
      String content=dto.getSelectcontent();
      String type=dto.getSelecttype();
      String Pa=dto.getPage();
      String name="";
      System.out.println("continent="+continent);
      System.out.println("type="+type);
      System.out.println("content="+content);
      System.out.println("text="+text);
      System.out.println("page="+Pa);
      int page=0;
      if(Pa == null && continent==null && content==null && type==null && text==null) {
         page=1;
         type="";
         text="";
         content="";
         continent="";
         dao.count(continent,type,text,name);
         ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name));
         model.addAttribute("list", list);
      }else if(Pa == null && continent!=null && content==null && type==null && text==null) {
         page=1;
         type="";
         text="";
         content="";
         dao.count(continent,type,text,name);
         ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name));
         model.addAttribute("list", list);
      }else if(Pa == null) {
         page=1;
         if(content.equals("작성자")) {
            name=text;
            text="";
            System.out.println("name="+name);
            System.out.println("text="+text);
            ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name));
            model.addAttribute("list", list);
            text=name;
         }else if(content.equals("제목")) {
            ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name));
            model.addAttribute("list", list);
            System.out.println("name="+name);
            System.out.println("text="+text);
         }else{
            ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name));
            model.addAttribute("list", list);
         }
      }else {
         if(content.equals("작성자")) {
            name=text;
            text="";
            dao.count(continent,type,text,name);
            System.out.println("name="+name);
            System.out.println("text="+text);
            page=Integer.parseInt(Pa);
            ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name));
            model.addAttribute("list", list);
            text=name;
         }else if(content.equals("제목")) {
            page=Integer.parseInt(Pa);
            ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name));
            model.addAttribute("list", list);
            System.out.println("name="+name);
            System.out.println("text="+text);
         }else{
            page=Integer.parseInt(Pa);
            ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name));
            model.addAttribute("list", list);
         }
      }
      System.out.println("page2="+page);
      System.out.println("name="+name);
      model.addAttribute("a", dao.count(continent,type,text,name));
      model.addAttribute("p", page);
      model.addAttribute("text", text);
      model.addAttribute("type", type);
      model.addAttribute("content", content);
      model.addAttribute("continent", continent);   
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
   public String array2(BoardDto dto1,Model model,String p,String continent,SearchDto dto) {
      int s = dto1.getNum();
      System.out.println("d1231231="+s);
      int b= dto1.getNumber()+1;
      dao.updateNum(b, s);
      BoardDto a =dao.select(s);
      System.out.println("dasdasdasda="+a);
      model.addAttribute("b",a);
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
   @RequestMapping(value ="/ReplyCm", method = RequestMethod.POST)
   public String ReplyCM( CommentDto dto) {
      int s = dto.getRecm();
      dao.ReplyCM(dto,s);
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
   @RequestMapping(value ="/Chatting", method = RequestMethod.GET)
   public String Chatting(Model model) {
      return "/chat-ws";
   }
   @RequestMapping(value ="/chatting_main", method = RequestMethod.GET)
   public String Chatting_main(Model model) {
      return "chatting/chatting";
   }
}