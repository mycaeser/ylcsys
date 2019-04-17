package com.organization.ylcsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/front")
public class IndexViewer {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String showAccountLevelList() {// 显示首页
		return "index";
	}
}
