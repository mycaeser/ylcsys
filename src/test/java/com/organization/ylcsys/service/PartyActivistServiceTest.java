package com.organization.ylcsys.service;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.ylcsys.BaseTest;
import com.organization.ylcsys.entity.PartyActivist;

public class PartyActivistServiceTest extends BaseTest{
	@Autowired
	private PartyActivistService partyActivistService;
	
	@Test
	@Ignore
	public void insertTest() {
		PartyActivist targetItem=new PartyActivist();
		Date aimTDate = (new Date());
		java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setUserId(1);
		targetItem.setIsCheckedOpinion("表现优秀");
		targetItem.setIsChecked(1);
		targetItem.setApplyDate(aimSQLdate);
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setLastEditTime(aimTimestamp);
		boolean result=partyActivistService.addPartyActivist(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectTest() {
		List<PartyActivist> partyActivistList=partyActivistService.getPartyActivistListAll();
		System.out.println(partyActivistList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		PartyActivist targetItem=partyActivistService.getPartyActivistById(1);
		System.out.println(targetItem.getUserNameString());
	}
	@Test
	@Ignore
	public void updateTest() {
		PartyActivist targetItem=new PartyActivist();
		targetItem.setId(1);
		targetItem.setIsCheckedOpinion("表现优秀1");
		boolean result=partyActivistService.updatePartyActivist(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=partyActivistService.deletePartyActivistById(2);
		System.out.println(result);
	}
}
