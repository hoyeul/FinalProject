package com.FinalProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FinalProject.Model.Register.RegisterDto;
import com.FinalProject.Model.Register.RegisterDao;

@Controller
public class RegisterController {
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		
		return "register/register";
	}
	@RequestMapping(value = "/register/reg", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request) {
		String user_nm  = request.getParameter("user_nm");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");			
		String user_phone = request.getParameter("user_phone");			
		String user_email = request.getParameter("user_email");			
		String user_address = request.getParameter("user_address");			
		String user_regnum = request.getParameter("user_regnum");	
		
//		System.out.println(user_nm) ;
//		System.out.println(user_id) ;
//		System.out.println(user_pw) ; 	
//		System.out.println(user_phone) ; 	
//		System.out.println(user_email) ; 	
//		System.out.println(user_address) ; 	
//		System.out.println(user_regnum) ; 	
		
		//Customer ��ü ���� �� �Է�
		RegisterDto customer = new RegisterDto(user_nm,user_id,user_pw,user_phone,user_email,user_address,user_regnum);
		
		//Customer ��ü�� Dao�� ���� DB�� �Է�
		RegisterDao dao = new RegisterDao();
		dao.insert(customer);
		
		return "home";
	}
	@RequestMapping( value="/register/IdCheckService" , method= RequestMethod.POST)
	public void test(HttpServletRequest request,HttpServletResponse response) throws IOException { 		 
		request.setCharacterEncoding("UTF-8");
		// ajax�� ���� �ޱ� ������ UTF-8�� ���ڵ����ش�
		response.setCharacterEncoding("EUC-KR");
					
		String userId = request.getParameter("userId");
		// join.jsp���� �޾ƿ� key���� userId�̰�
		// value���� ������ ������ ���� ��, String userId���� value���� ����.
		PrintWriter out = response.getWriter();
				
		RegisterDao dao = new RegisterDao();
				
		int idChcek = dao.checkId(userId);

		// �������� Ȯ�� : �����ڿ�
		if (idChcek == 0) {
			System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
		} else if (idChcek == 1) {
			System.out.println("��� ������ ���̵��Դϴ�.");
		}
				
		out.write(idChcek + ""); // --> ajax ������� result�� ��
				// --> String���� ���� ������ �� �ֵ��� + "" �� ���ش�
		
	}
}