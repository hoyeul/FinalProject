package com.FinalProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class currencyRateController {
	
	@RequestMapping(value = "/currencyrate")
	public String home() {
		return "currencyRate/currencyRate";
	}
	
}