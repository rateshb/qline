package com.qline.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {
	
	@RequestMapping(value={"/home","home","/",""}, method=RequestMethod.GET)
	public String showHomepage() {
		return "homepage";
	}
	
}
