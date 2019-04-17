package com.organization.ylcsys.web.userinfoadmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.organization.ylcsys.entity.UserInfo;
import com.organization.ylcsys.service.UserInfoService;

@Controller
@RequestMapping("/userinfoadmin")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value = "/getuserinfolist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getUserInfoListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<UserInfo> userInfoList=userInfoService.getUserInfoListAll();
		modelMap.put("userInfoList", userInfoList);
		return modelMap;
	}
}
