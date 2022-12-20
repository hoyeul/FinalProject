package com.FinalProject.Model.Mail;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	@Autowired
    private JavaMailSender mailSender;
	
	public int mailCheckGET(String email) throws Exception{
	    	
    	Random random = new Random();
    	int checkNum = random.nextInt(888888) + 111111;
    	String setFrom = "hoyeol9000@gmail.com";	//xml에 입력한 자신의 이메일
        String toMail = email;					//수신받을 이메일
        String title = "회원가입 인증 이메일 입니다.";	//이메일 제목
        String content = 						//이메일 내용
            "홈페이지를 방문해주셔서 감사합니다." +
            "<br><br>" + 
            "인증 번호는 " + checkNum + "입니다." + 
            "<br>" + 
            "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return checkNum;
    }
	
}
