package com.FinalProject.Model.TravelWarning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

@Component
public class TravelWarningService {
    
	public Map<String, Object> travelInfo() throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/TravelWarningService/getTravelWarningList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=Nwxl4kKv7ybp5MV%2BRxteAhgHCTABREf6CpLmwMO3tf942PIQmVEuemOSDtKJDbfK5RxPB9Ubmm0yaAD3WJ1e7A%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("300", "UTF-8")); /*한 페이지 결과 수*/
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        //System.out.println(sb.toString());
        JSONObject jsonObj = XML.toJSONObject(sb.toString());
        JSONObject jsonObj2 = jsonObj.getJSONObject("response");
        JSONObject jsonObj3 = jsonObj2.getJSONObject("body");
        JSONObject jsonObj4 = jsonObj3.getJSONObject("items");
        JSONArray jsonObj5 = jsonObj4.getJSONArray("item");
        
        List<NavyDto> navyDtoList = new ArrayList<NavyDto>();
        List<YellowDto> yellowDtoList = new ArrayList<YellowDto>();
        List<RedDto> redDtoList = new ArrayList<RedDto>();
        List<BlackDto> blackDtoList = new ArrayList<BlackDto>();
        JSONObject obj;
        for(int i = 0; i < jsonObj5.length(); i++) {
        	obj = (JSONObject)jsonObj5.opt(i);
        	//System.out.println(obj.optString("continent"));
        	if(obj.optString("attentionNote") != "") {
        		String continent = obj.optString("continent");
        		String countryName = obj.optString("countryName");
        		String attentionNote = obj.optString("attentionNote");
        		NavyDto navyDto = new NavyDto(continent, countryName, attentionNote);
        		navyDtoList.add(navyDto);
        	}
        	if(obj.optString("controlNote") != "") {
        		String continent = obj.optString("continent");
        		String countryName = obj.optString("countryName");
        		String controlNote = obj.optString("controlNote");
        		YellowDto yellowDto = new YellowDto(continent, countryName, controlNote);
        		yellowDtoList.add(yellowDto);
        	}
        	if(obj.optString("limitaNote") != "") {
        		String continent = obj.optString("continent");
        		String countryName = obj.optString("countryName");
        		String limitaNote = obj.optString("limitaNote");
        		RedDto redDto = new RedDto(continent, countryName, limitaNote);
        		redDtoList.add(redDto);
        	}
        	if(obj.optString("attentionNote") == "" && obj.optString("controlNote") == "" && obj.optString("limitaNote") == "") {
        		String continent = obj.optString("continent");
        		String countryName = obj.optString("countryName");
        		BlackDto blackDto = new BlackDto(continent, countryName);
        		blackDtoList.add(blackDto);
        	}
        }
        
        /*
        System.out.println(navyDtoList);
        System.out.println("===============");
        System.out.println(yellowDtoList);
        System.out.println("===============");
        System.out.println(redDtoList);
        System.out.println("===============");
        System.out.println(blackDtoList);
        System.out.println("===============");
        
        
        for(int i = 0; i < jsonObj5.length(); i++) {
        	System.out.println(jsonObj5.get(i));
        }
        */
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("navy", navyDtoList);
        map.put("yellow", yellowDtoList);
        map.put("red", redDtoList);
        map.put("black", blackDtoList);
        
        return map;
    }
    
   
    
}
