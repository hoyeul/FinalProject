package com.FinalProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExchangeController {
	
	@RequestMapping(value = "/exchange")
	public String exchange() {
		return "exchange";
	}
	
	
}
