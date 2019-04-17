package com.organization.ylcsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.ylcsys.BaseTest;
import com.organization.ylcsys.entity.YouthOrg;

public class YouthOrgServiceTest extends BaseTest{
	@Autowired
	private YouthOrgService youthOrgService;
	
	@Test
	@Ignore
	public void insertTest() {
		YouthOrg targetItem=new YouthOrg();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setContent("南京市第一中学共青团");
		targetItem.setName("南京市第一中学共青团");
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setLastEditTime(aimTimestamp);
		targetItem.setUserId(2);
		boolean result=youthOrgService.addYouthOrg(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectTest() {
		List<YouthOrg> youthOrgList=youthOrgService.getYouthOrgListAll();
		System.out.println(youthOrgList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		YouthOrg targetItem=youthOrgService.getYouthOrgById(1);
		System.out.println(targetItem.getUserNameString());
	}
	@Test
	@Ignore
	public void updateTest() {
		YouthOrg targetItem=new YouthOrg();
		targetItem.setId(1);
		targetItem.setContent("北海市市第五中学共青团");
		boolean result=youthOrgService.updateYouthOrg(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=youthOrgService.deleteYouthOrgById(2);
		System.out.println(result);
	}
}
