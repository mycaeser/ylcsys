package com.organization.ylcsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.ylcsys.BaseTest;
import com.organization.ylcsys.entity.UserInfo;

public class UserInfoServiceTest extends BaseTest{
	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	@Ignore
	public void insertTest() {
		UserInfo targetItem=new UserInfo();
		Date aimTDate = (new Date());
		java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setName("王起薪");
		targetItem.setIdCard("2414741999307172183");
		targetItem.setGender(1);
		targetItem.setClassName("设计2班");
		targetItem.setPartyBranchId(1);
		targetItem.setPhone("137260428374");
		targetItem.setPriority(1);
		targetItem.setUnionName("艺术学院");
		targetItem.setAdmitPartyTime(aimSQLdate);
		targetItem.setApplyPartyTime(aimSQLdate);
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setLastEditTime(aimTimestamp);
		targetItem.setYouthOrgTime(aimSQLdate);
		boolean result=userInfoService.addUserInfo(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectTest() {
		List<UserInfo> userInfoList=userInfoService.getUserInfoListAll();
		System.out.println(userInfoList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		UserInfo targetItem=userInfoService.getUserInfoById(1);
		System.out.println(targetItem.getName());
	}
	@Test
	@Ignore
	public void updateTest() {
		UserInfo targetItem=new UserInfo();
		targetItem.setId(1);
		targetItem.setName("习封1");
		boolean result=userInfoService.updateUserInfo(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=userInfoService.deleteUserInfoById(3);
		System.out.println(result);
	}
}
