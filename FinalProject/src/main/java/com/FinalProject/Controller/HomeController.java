package com.FinalProject.Controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Embassy.EmbassyService;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home")
	public String home() {
		return "home/home";
	}
	
	@ResponseBody
	@RequestMapping(value="/embassy", method = RequestMethod.POST)
	public JSONArray embassy() throws Exception {
		EmbassyService s = new EmbassyService();
		JSONArray array = s.embassy();
		return array;
	}
	
}
