package com.organization.ylcsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.ylcsys.dao.PartyActivistDao;
import com.organization.ylcsys.entity.PartyActivist;
import com.organization.ylcsys.service.PartyActivistService;

@Service
public class PartyActivistServiceImpl implements PartyActivistService{
	@Autowired
	private PartyActivistDao partyActivistDao;
	
	@Override
	public List<PartyActivist> getPartyActivistListAll(){
		List<PartyActivist> partyActivistList=partyActivistDao.queryPartyActivistAll();
		return partyActivistList;
	}
	@Override
	public PartyActivist getPartyActivistById(Integer id) {
		PartyActivist targetItem=new PartyActivist();
		targetItem.setId(id);
		List<PartyActivist> partyActivistList=partyActivistDao.queryPartyActivistByTargetItem(targetItem);
		return partyActivistList.get(0);
	}
	@Override
	public boolean updatePartyActivist(PartyActivist targetItem) {
		int effectedNum=partyActivistDao.updatePartyActivistByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addPartyActivist(PartyActivist targetItem) {
		int effectedNum=partyActivistDao.insertIntoPartyActivistByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deletePartyActivistById(Integer id) {
		PartyActivist targetItem=new PartyActivist();
		targetItem.setId(id);
		int effectedNum=partyActivistDao.deletePartyActivistByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
