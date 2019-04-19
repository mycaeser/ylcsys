package com.organization.ylcsys.web.activistadmin;

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

import com.organization.ylcsys.entity.PartyActivist;
import com.organization.ylcsys.service.PartyActivistService;
import com.organization.ylcsys.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/activistadmin")
public class ActivistController {
	@Autowired
	private PartyActivistService partyActivistService;
	
	@RequestMapping(value = "/getactivistlist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getUserInfoListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<PartyActivist> partyActivistList=partyActivistService.getPartyActivistListAll();
		modelMap.put("partyActivistList", partyActivistList);
		return modelMap;
	}
	/**
	 * 添加一条申请积极分子
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/applyactivistbyid", method = RequestMethod.GET)
	private String applyActivistById(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer userId =Integer.parseInt(HttpServletRequestUtil.getString(request, "userId"));
		PartyActivist targetItem=new PartyActivist();
		Date aimTDate = (new Date());
		java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setIsChecked(0);
		targetItem.setUserId(userId);
		targetItem.setApplyDate(aimSQLdate);
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setLastEditTime(aimTimestamp);
		Boolean result = partyActivistService.addPartyActivist(targetItem);
		modelMap.put("result", result);
		return "user/activist";
	}
	/**
	 * 更新一条申请积极分子
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateactivistbyid", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> updateActivistById(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id"));
		String isCheckedOpinion=HttpServletRequestUtil.getString(request, "isCheckedOpinion");
		PartyActivist targetItem=new PartyActivist();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setIsChecked(1);
		targetItem.setId(id);
		targetItem.setIsCheckedOpinion(isCheckedOpinion);
		targetItem.setLastEditTime(aimTimestamp);
		Boolean result = partyActivistService.updatePartyActivist(targetItem);
		modelMap.put("result", result);
		return modelMap;
	}
}
