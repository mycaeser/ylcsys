package com.organization.ylcsys.web.youthorgduesadmin;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.organization.ylcsys.entity.YouthOrgDues;
import com.organization.ylcsys.service.YouthOrgDuesService;
import com.organization.ylcsys.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/youthorgduesadmin")
public class YouthOrgDuesController {
	@Autowired
	private YouthOrgDuesService youthOrgDuesService;
	
	/**
	 * 添加一条缴费信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> Add( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer duesValue = HttpServletRequestUtil.getInt(request, "duesValue");
		String duesDate = HttpServletRequestUtil.getString(request, "duesDate");
		Integer userId=HttpServletRequestUtil.getInt(request, "userId");
		YouthOrgDues targetItem=new YouthOrgDues();
		Date aimTDate = (new Date());
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date duesDateA=format1.parse(duesDate);
			Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
			java.sql.Date sqlDate = new java.sql.Date(duesDateA.getTime());
			targetItem.setDuesDate(sqlDate);
			targetItem.setUserId(userId);
			targetItem.setDuesValue(duesValue);
			targetItem.setLastEditTime(aimTimestamp);
			targetItem.setCreateTime(aimTimestamp);
			targetItem.setIsDeduction(0);
			boolean result=youthOrgDuesService.addYouthOrgDues(targetItem);
			modelMap.put("success", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modelMap;
	}
	/**
	 * 获取全部缴费信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getlistall", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<YouthOrgDues> youthOrgDuesList=youthOrgDuesService.getYouthOrgDuesListAll();
		modelMap.put("youthOrgDuesList", youthOrgDuesList);
		return modelMap;
	}
	/**
	 * 删除一条缴费信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deletebyid", method = RequestMethod.GET)
	private String deleteById( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id")) ;
		Boolean result=youthOrgDuesService.deleteYouthOrgDuesById(id);
		modelMap.put("success", result);
		return "pay/deduction";
	}
	/**
	 * 更新一条缴费信息为减免状态
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateduestoabyid", method = RequestMethod.GET)
	private String updateDuesToAById( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id")) ;
		YouthOrgDues targetItem=new YouthOrgDues();
		targetItem.setId(id);
		targetItem.setIsDeduction(1);
		Boolean result=youthOrgDuesService.updateYouthOrgDues(targetItem);
		modelMap.put("success", result);
		return "pay/deduction";
	}
}
