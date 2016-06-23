package com.qline.web.controller.page;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {
	
	@RequestMapping(value={"/home","home","/",""}, method=RequestMethod.GET)
	public String showHomepage(HttpServletRequest request) {
		String stn = request.getParameter("stn");
		if(StringUtils.isEmpty(stn)) {
		    return "homepage";
		} else {
			return "homepageNormal";
		}
	}
	
}
