package com.FinalProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrencyRateController {
	
	@RequestMapping(value = "/currencyrate")
	public String currencyRate() {
		return "currencyRate/currencyRate";
	}
	
}
