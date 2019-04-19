package com.organization.ylcsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserInfoViewer {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String showAccountLevelList() {// 显示缴费页面
		return "user/list";
	}
}
