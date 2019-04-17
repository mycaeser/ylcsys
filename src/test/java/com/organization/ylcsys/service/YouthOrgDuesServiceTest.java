package com.organization.ylcsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.ylcsys.BaseTest;
import com.organization.ylcsys.entity.YouthOrgDues;

public class YouthOrgDuesServiceTest extends BaseTest{
	@Autowired
	private YouthOrgDuesService youthOrgDuesService;
	
	@Test
	@Ignore
	public void insertTest() {
		YouthOrgDues targetItem=new YouthOrgDues();
		Date aimTDate = (new Date());
		java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setDuesValue(12);
		targetItem.setUserId(1);
		targetItem.setIsDeduction(0);
		targetItem.setDuesDate(aimSQLdate);
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setLastEditTime(aimTimestamp);
		boolean result=youthOrgDuesService.addYouthOrgDues(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectTest() {
		List<YouthOrgDues> youthOrgDuesList=youthOrgDuesService.getYouthOrgDuesListAll();
		System.out.println(youthOrgDuesList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		YouthOrgDues targetItem=youthOrgDuesService.getYouthOrgDuesById(1);
		System.out.println(targetItem.getUserNameString());
	}
	@Test
	@Ignore
	public void updateTest() {
		YouthOrgDues targetItem=new YouthOrgDues();
		targetItem.setId(1);
		targetItem.setDuesValue(13);
		boolean result=youthOrgDuesService.updateYouthOrgDues(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=youthOrgDuesService.deleteYouthOrgDuesById(2);
		System.out.println(result);
	}
}
