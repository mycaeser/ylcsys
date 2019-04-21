package com.organization.ylcsys.web.loginadmin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.organization.ylcsys.entity.LocalAccount;
import com.organization.ylcsys.service.LocalAccountService;
import com.organization.ylcsys.util.CodeUtil;
import com.organization.ylcsys.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/login")
public class LoginCheckController {
	@Autowired
	private LocalAccountService localAccountService;
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> loginCheck(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}
		
		// 获取输入的帐号
		String userName = HttpServletRequestUtil.getString(request, "loginName");
		// 获取输入的密码
		String password = HttpServletRequestUtil.getString(request, "password");
		// 非空校验
		if (userName != null && password != null) {
			LocalAccount taregtItem1=null;
			try {
				taregtItem1 = localAccountService.getLocalAccountByAccountAndPassword(userName, password);
			} catch (Exception e) {
				// TODO: handle exception
				modelMap.put("success", false);
				modelMap.put("errMsg", "用户名或密码错误");
			}
			// 传入帐号和密码去获取平台帐号信息
			
			if (taregtItem1 != null) {
				// 若能取到帐号信息则登录成功
				modelMap.put("success", true);
				// 同时在session里设置用户信息
				if(userName.equals("administrator")) {
					request.getSession().setAttribute("admin", taregtItem1.getAccountString());
					modelMap.put("usertype", "admin");
				}else {
					request.getSession().setAttribute("user", taregtItem1.getAccountString());
					modelMap.put("usertype", "normal");
				}
				
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "用户名或密码错误");
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名和密码均不能为空");
		}
		return modelMap;
	}

}
