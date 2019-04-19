package com.organization.ylcsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pay")
public class PayerController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String showApplyIndex() {// 显示缴费页面
		return "pay/apply";
	}
	@RequestMapping(value = "/deduction", method = RequestMethod.GET)
	private String showDeduction() {// 显示缴费减免
		return "pay/deduction";
	}
}
