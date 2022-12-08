package com.FinalProject.Model.Exchange;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeService {

	public String exchangeApi() {
		
		StringBuffer result = new StringBuffer(); 
		String strResult = "";
		try { 
			// URL 설정 
			StringBuilder urlBuilder = new StringBuilder("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=1SbTZQ1Vrt4KIeKvlx5ULicZAHB7tI1U&data=AP01"); 
			
			URL url = new URL(urlBuilder.toString()); 
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
			
			// Request 형식 설정 
			conn.setRequestMethod("GET"); 
			conn.setRequestProperty("Content-Type", "application/json"); 
			
			// 응답 데이터 받아오기 
			BufferedReader rd; 
			if(conn.getResponseCode() >= 200 & conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); 
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
			}
			
			String line; 
			while((line = rd.readLine()) != null) {
			 result.append(line); 
			 } 
			rd.close(); 
			conn.disconnect(); 
			strResult = result.toString(); 
		} catch ( Exception e ){
			e.printStackTrace(); 
		} 
		return strResult;
	}
	
	
}
