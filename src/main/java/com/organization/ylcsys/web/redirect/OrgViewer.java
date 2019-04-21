package com.organization.ylcsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/org")
public class OrgViewer {
	
	@RequestMapping(value = "/youth", method = RequestMethod.GET)
	private String showAccountLevelList() {// 显示团组织
		return "org/youth";
	}
}
