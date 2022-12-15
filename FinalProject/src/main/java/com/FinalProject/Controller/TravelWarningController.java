package com.FinalProject.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FinalProject.Model.TravelWarning.BlackDto;
import com.FinalProject.Model.TravelWarning.NavyDto;
import com.FinalProject.Model.TravelWarning.RedDto;
import com.FinalProject.Model.TravelWarning.TravelWarningService;
import com.FinalProject.Model.TravelWarning.YellowDto;

@Controller
public class TravelWarningController {

	@Autowired
	TravelWarningService s;
	
	/*
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		TravelWarningService s = new TravelWarningService();
		Map<String, Object> map =  s.travelInfo();
//		Object navy = map.get("navy");
		List<NavyDto> navy = (List<NavyDto>)map.get("navy");
		System.out.println(navy);
	}
	*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/navy")
	public String navy(Model model) throws Exception {
		TravelWarningService s = new TravelWarningService();
		Map<String, Object> map =  s.travelInfo();
		List<NavyDto> navy = (List<NavyDto>)map.get("navy");
		
		/*
		for(int i = 0; i < navy.size(); i++) {
			System.out.println(navy.get(i).getContinent());
			System.out.println(navy.get(i).getCountryName());
			System.out.println(navy.get(i).getAttentionNote());
		}
		*/
		model.addAttribute("navy", navy);
		return "travelWarning/navy";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/yellow")
	public String yellow(Model model) throws Exception {
		TravelWarningService s = new TravelWarningService();
		Map<String, Object> map =  s.travelInfo();
		List<YellowDto> yellow = (List<YellowDto>)map.get("yellow");
		
		/*
		for(int i = 0; i < yellow.size(); i++) {
			System.out.println(yellow.get(i).getContinent());
			System.out.println(yellow.get(i).getCountryName());
			System.out.println(yellow.get(i).getControlNote());
		}
		*/
		model.addAttribute("yellow", yellow);
		return "travelWarning/yellow";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/red")
	public String red(Model model) throws Exception {
		TravelWarningService s = new TravelWarningService();
		Map<String, Object> map =  s.travelInfo();
		List<RedDto> red = (List<RedDto>)map.get("red");
		
		/*
		for(int i = 0; i < red.size(); i++) {
			System.out.println(red.get(i).getContinent());
			System.out.println(red.get(i).getCountryName());
			System.out.println(red.get(i).getLimitaNote());
		}
		*/
		model.addAttribute("red", red);
		return "travelWarning/red";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/black")
	public String black(Model model) throws Exception {
		TravelWarningService s = new TravelWarningService();
		Map<String, Object> map =  s.travelInfo();
		List<BlackDto> black = (List<BlackDto>)map.get("black");
		
		/*
		for(int i = 0; i < black.size(); i++) {
			System.out.println(black.get(i).getContinent());
			System.out.println(black.get(i).getCountryName());
		}
		*/
		model.addAttribute("black", black);
		return "travelWarning/black";
	}
	
}
