package com.organization.ylcsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/activist")
public class ActivistViewer {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String showAccountLevelList() {// 显示积极分子页面
		return "user/activist";
	}
}
