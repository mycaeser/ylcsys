package com.organization.ylcsys.web.orgadmin;

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

import com.organization.ylcsys.entity.YouthOrg;
import com.organization.ylcsys.service.YouthOrgService;
import com.organization.ylcsys.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/orgadmin")
public class OrgController {
	@Autowired
	private YouthOrgService youthOrgService;
	
	@RequestMapping(value = "/getyouthorglistall", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getyouthorgListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<YouthOrg> youthOrgList=youthOrgService.getYouthOrgListAll();
		modelMap.put("youthOrgList", youthOrgList);
		return modelMap;
	}
	
	/**
	 * 添加一条团组织信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addyouth", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addYouth(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id"));
		String youthOrgName=HttpServletRequestUtil.getString(request, "inputYouthName");
		String youthOrgContent=HttpServletRequestUtil.getString(request, "inputYouthContent");
		YouthOrg targetItem=new YouthOrg();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setUserId(id);
		targetItem.setContent(youthOrgContent);
		targetItem.setName(youthOrgName);
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setLastEditTime(aimTimestamp);
		Boolean result = youthOrgService.addYouthOrg(targetItem);
		modelMap.put("result", result);
		return modelMap;
	}
	/**
	 * 删除一条团组织信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deletebyuserid", method = RequestMethod.GET)
	private String applyActivistById(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer userId =Integer.parseInt(HttpServletRequestUtil.getString(request, "userId"));
		Boolean result = youthOrgService.deleteYouthOrgByUserId(userId);
		modelMap.put("result", result);
		return "org/youth";
	}
	/**
	 * 更新一条团组织信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateyouthbyid", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> updateYouthById(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer userId =Integer.parseInt(HttpServletRequestUtil.getString(request, "userId"));
		String youthOrgName=HttpServletRequestUtil.getString(request, "orgName");
		String youthOrgContent=HttpServletRequestUtil.getString(request, "orgContent");
		YouthOrg targetItem=new YouthOrg();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setUserId(userId);
		targetItem.setContent(youthOrgContent);
		targetItem.setName(youthOrgName);
		targetItem.setLastEditTime(aimTimestamp);
		Boolean result = youthOrgService.updateYouthOrg(targetItem);
		modelMap.put("result", result);
		return modelMap;
	}
}
