package com.organization.ylcsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.ylcsys.BaseTest;
import com.organization.ylcsys.entity.LocalAccount;

public class LocalAccountServiceTest extends BaseTest{
	@Autowired
	private LocalAccountService localAccountService;
	
	@Test
	@Ignore
	public void insertTest() {
		LocalAccount targetItem=new LocalAccount();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setAccountString("xifeng");
		targetItem.setPasswordString("123456");
		targetItem.setUserId(1);
		targetItem.setLastEditTime(aimTimestamp);
		targetItem.setCreateTime(aimTimestamp);
		boolean result=localAccountService.addLocalAccount(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectTest() {
		List<LocalAccount> localAccountList=localAccountService.getLocalAccountListAll();
		System.out.println(localAccountList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		LocalAccount targetItem=localAccountService.getLocalAccountById(1);
		System.out.println(targetItem.getUserNameString());
	}
	@Test
	@Ignore
	public void updateTest() {
		LocalAccount targetItem=new LocalAccount();
		targetItem.setId(1);
		targetItem.setPasswordString("1234567");
		boolean result=localAccountService.updateLocalAccount(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=localAccountService.deleteLocalAccountById(2);
		System.out.println(result);
	}
}
