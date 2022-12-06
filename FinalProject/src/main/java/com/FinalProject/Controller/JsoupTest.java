package com.FinalProject.Controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupTest {	
	public static void main(String[] args) {		 
		String URL = "https://weather.naver.com/rgn/cityWetrMain.nhn";
		Document doc;
		try {
			doc = Jsoup.connect(URL).get();
			Elements elem = doc.select(".title");	 // 클래스가 .leve14_1 가지고 있는 태그들 뽑아옴	
			System.out.println( elem.text());			
			String[] strs = elem.text().split(" ");		 //space기준으로 분리함
			for(String str: strs ) {
				System.out.println(str);
			}			
		} catch (IOException e) {			 
			e.printStackTrace();
		}
	} 
}


