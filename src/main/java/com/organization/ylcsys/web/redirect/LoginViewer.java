package com.organization.ylcsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginViewer {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String showAccountLevelList() {// 显示登陆
		return "login";
	}
}
