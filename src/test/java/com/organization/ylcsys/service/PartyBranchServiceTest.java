package com.organization.ylcsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.ylcsys.BaseTest;
import com.organization.ylcsys.entity.PartyBranch;

public class PartyBranchServiceTest extends BaseTest{
	@Autowired
	private PartyBranchService partyBranchService;
	
	@Test
	@Ignore
	public void insertTest() {
		PartyBranch targetItem=new PartyBranch();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setName("理学院党支部一部");
		targetItem.setContent("理学院总党支部");
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setLastEditTime(aimTimestamp);
		boolean result=partyBranchService.addPartyBranch(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectTest() {
		List<PartyBranch> partyBranchList=partyBranchService.getPartyBranchListAll();
		System.out.println(partyBranchList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		PartyBranch targetItem=partyBranchService.getPartyBranchById(1);
		System.out.println(targetItem.getName());
	}
	@Test
	@Ignore
	public void updateTest() {
		PartyBranch targetItem=new PartyBranch();
		targetItem.setId(1);
		targetItem.setName("体育学院党支部一部1");
		boolean result=partyBranchService.updatePartyBranch(targetItem);
		System.out.println(result);
	}
	@Test
	public void deleteTest() {
		boolean result=partyBranchService.deletePartyBranchById(3);
		System.out.println(result);
	}
}
