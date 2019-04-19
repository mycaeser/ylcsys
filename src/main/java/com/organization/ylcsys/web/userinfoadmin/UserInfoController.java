package com.organization.ylcsys.web.userinfoadmin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.organization.ylcsys.entity.UserInfo;
import com.organization.ylcsys.service.UserInfoService;
import com.organization.ylcsys.util.HttpServletRequestUtil;

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
	/**
	 * 添加一个用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/adduserinfoobj", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addUserInfoStr(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		UserInfo someone = null;
		// 接收前端参数的变量的初始化
		ObjectMapper mapper = new ObjectMapper();
		try {
			//前端传的用户信息对象
			String userInfoStr = HttpServletRequestUtil.getString(request, "userInfoStr");
			// 尝试获取前端传过来的表单string流并将其转换成UserInfo实体类
			someone = mapper.readValue(userInfoStr, UserInfo.class);
			Date aimTDate = (new Date());
			Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
			// 设置创建时间
			someone.setCreateTime(aimTimestamp);
			// 设置编辑时间
			someone.setLastEditTime(aimTimestamp);
			//默认权限1
			someone.setPriority(1);
			if (userInfoService.addUserInfo(someone)) {
				modelMap.put("success", true);
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}
	/**
	 * 修改一个用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateuserinfoobj", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> updateUserInfoStr(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		UserInfo someone = null;
		// 接收前端参数的变量的初始化
		ObjectMapper mapper = new ObjectMapper();
		try {
			//前端传的用户信息对象
			String userInfoStr = HttpServletRequestUtil.getString(request, "userInfoStr");
			// 尝试获取前端传过来的表单string流并将其转换成UserInfo实体类
			someone = mapper.readValue(userInfoStr, UserInfo.class);
			Date aimTDate = (new Date());
			Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
			// 设置编辑时间
			someone.setLastEditTime(aimTimestamp);
			if (userInfoService.updateUserInfo(someone)) {
				modelMap.put("success", true);
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}
	/**
	 * 修改一个用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteuserinfobyid", method = RequestMethod.GET)
	private String deleteUserInfoById(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer userId =Integer.parseInt(HttpServletRequestUtil.getString(request, "userId")) ;
		Boolean result = userInfoService.deleteUserInfoById(userId);
		modelMap.put("result", result);
		return "user/list";
	}
}
