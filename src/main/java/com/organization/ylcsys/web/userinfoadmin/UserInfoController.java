package com.organization.ylcsys.web.userinfoadmin;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getUserInfoListAll(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		modelMap.put("userInfoList", "123");
		return modelMap;
	}

}
