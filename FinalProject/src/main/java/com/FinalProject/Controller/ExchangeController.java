package com.FinalProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FinalProject.Model.Exchange.ExchangeService;

@Controller
public class ExchangeController {
	
	@RequestMapping(value = "/exchange")
	public String exchange() {
		return "exchange/exchange";
	}
	
	@ResponseBody
	@RequestMapping(value = "/exchange", method = RequestMethod.POST)
	public String exchange2() {
		
		ExchangeService s = new ExchangeService();
		String strResult = s.exchangeApi();
		
		return strResult;
	}
	
}
