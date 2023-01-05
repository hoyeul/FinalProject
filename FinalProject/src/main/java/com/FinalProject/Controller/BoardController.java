package com.FinalProject.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.FinalProject.Model.Board.BoardDao;
import com.FinalProject.Model.Board.BoardDto;
import com.FinalProject.Model.Board.CommentDto;
import com.FinalProject.Model.Board.Pagination;
import com.FinalProject.Model.Board.RecommendDto;
import com.FinalProject.Model.Board.SearchDto;
import com.google.gson.JsonObject;

@Controller
public class BoardController {
   
   @Autowired
   BoardDao dao;
   
   @RequestMapping(value ="/board", method = RequestMethod.GET)
   public String array(Model model,String continent,SearchDto dto,String recommend) {
      String text=dto.getText();
      String content=dto.getSelectcontent();
      String type=dto.getSelecttype();
      String Pa=dto.getPage();
      String name="";
      if( recommend == null ){
    	  recommend = "b_date";
      }else {
    	  if(recommend.equals("recommend") || recommend.equals("total")) {
        	  recommend = "total";
          }else {
        	  recommend = "b_date";
          }
      }
      int page=0;
      
      if(type==null) {
          type="";
          } 
      if(text==null) {
          text="";
          }
      if(content==null) {
          content="";
          }
      if(continent==null) {
          continent="";
          }
      if(Pa == null) {
             page=1;
          }
      if(Pa != null) {
             page=Integer.parseInt(Pa);
          } 
      if(content.equals("작성자")) {
          name=text;
          text="";
          ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name),recommend);
          model.addAttribute("list", list);
          text=name;
       }else if(content.equals("제목")) {
          ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name),recommend);
          model.addAttribute("list", list);
       }else{
          ArrayList<BoardDto> list = dao.ArraySelect(page,continent,type,text,name,dao.count(continent,type,text,name),recommend);
          model.addAttribute("list", list);
       }
      
      int Allrecord = dao.count(continent, type, text, name);
      Pagination pagination = new Pagination();
      model.addAttribute("page", pagination.page(Pa, Allrecord));
      model.addAttribute("recommend", recommend);
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
   public String Board_insert(HttpServletRequest request, BoardDto dto, String regSessionID, String freeboard_content) {
      dao.boardreg(dto.getContinent(), dto.getSelect(), dto.getTitle(), freeboard_content, regSessionID);
      return "redirect:/board";
   }
   
   @RequestMapping(value ="/boardIn", method = RequestMethod.GET)
   public String array2(BoardDto dto1,Model model,String p,String continent,SearchDto dto) {
      int s = dto1.getNum();
      int b = dto1.getNumber()+1;
      dao.updateNum(b, s);
      BoardDto a = dao.select(s);
      model.addAttribute("b",a);
      return "Board/BoardIn";
   }
   
   @ResponseBody
   @RequestMapping(value ="/RegIn", method = RequestMethod.GET)
   public ArrayList<CommentDto> Reg(CommentDto dto,Model m) {
      int s = dto.getCnum();
      ArrayList<CommentDto> list = dao.ArrayCM(s);
      return list;
   }
   
   @RequestMapping(value ="/boardUp", method = RequestMethod.GET)
   public String Up1(BoardDto dto,Model m) {
      int s = dto.getNum();
      BoardDto a =dao.select(s);
      m.addAttribute("a",a);
      return "Board/BoardUp";
   }
   
   @RequestMapping(value = "boardUp",produces="text/plain;charset=UTF-8" ,method = RequestMethod.POST)
   public String Up2(BoardDto dto, String freeboard_content) {   
      dao.updateBoard(dto, freeboard_content);
      return "redirect:/boardIn?num="+dto.getNum()+"";
   }
   
   @RequestMapping(value ="/boardDE", method = RequestMethod.GET)
   public String delete(BoardDto dto) {
      int s = dto.getNum();
      dao.delete(s);
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
      dao.updateCM(dto);
      return "Board/BoardIn";
   }
   
   @ResponseBody
   @RequestMapping(value = "/CommentReg", method = RequestMethod.POST)
   public String member2(CommentDto dto) {   
      dao.insert(dto);
      return "Board/BoardIn";
   }
   
   @ResponseBody
   @RequestMapping(value = "/RecommendReg", method = RequestMethod.POST)	// 정상적인경우 1:추천, 비정상 0:이미추천 
   public int recUp(RecommendDto dto) {
	   
	   int upConut = 0;
	   boolean flag = dao.recUpConfirm(dto);	// 0 , 1
	   if(flag) {
		   upConut = dao.recUp(dto);		  
	   }  
	   return upConut; // 0 ,   5 =>  "5"
   }
   
   @ResponseBody
   @RequestMapping(value = "/RecommendDown", method = RequestMethod.POST)
   public int recdown(RecommendDto dto) {
	   
	   int downcntCheck = 0;
	   boolean flag = dao.recdownConfirm(dto);
	   if(flag) {
		   downcntCheck = dao.recdown(dto);
	   }
	   return downcntCheck;
   }
	
   @RequestMapping(value ="/Chatting", method = RequestMethod.GET)
   public String Chatting(Model model) {
      return "/chat-ws";
   }
   @RequestMapping(value ="/chatting_main", method = RequestMethod.GET)
   public String Chatting_main(Model model) {
      return "chatting/chatting";
   }
   
   @ResponseBody
   @RequestMapping(value = "fileupload.do")
   public void communityImageUpload(HttpServletRequest req, HttpServletResponse resp, MultipartHttpServletRequest multiFile) throws Exception{
      JsonObject jsonObject = new JsonObject();
      PrintWriter printWriter = null;
      OutputStream out = null;
      MultipartFile file = multiFile.getFile("upload");
      
      if(file != null) {
         if(file.getSize() >0 && StringUtils.isNotBlank(file.getName())) {
            if(file.getContentType().toLowerCase().startsWith("image/")) {
                try{
                    
                     String fileName = file.getOriginalFilename();
                     byte[] bytes = file.getBytes();
                    
                     String uploadPath = req.getSession().getServletContext().getRealPath("/resources/image/noticeimg"); //저장경로
                     System.out.println("uploadPath:"+uploadPath);

                     File uploadFile = new File(uploadPath);
                     if(!uploadFile.exists()) {
                        uploadFile.mkdir();
                     }
                     String fileName2 = UUID.randomUUID().toString();
                     uploadPath = uploadPath + "/" + fileName2 +fileName;
                     
                     out = new FileOutputStream(new File(uploadPath));
                     out.write(bytes);
                     
                     printWriter = resp.getWriter();
                     String fileUrl = req.getContextPath() + "/resources/image/noticeimg/" +fileName2 +fileName; //url경로
                     System.out.println("fileUrl :" + fileUrl);
                     JsonObject json = new JsonObject();
                     json.addProperty("uploaded", 1);
                     json.addProperty("fileName", fileName);
                     json.addProperty("url", fileUrl);
                     printWriter.print(json);
                     System.out.println(json);
          
                 }catch(IOException e){
                     e.printStackTrace();
                 } finally {
                     if (out != null) {
                          out.close();
                      }
                      if (printWriter != null) {
                          printWriter.close();
                      }
                 }
            }
         }
      }
   }
}