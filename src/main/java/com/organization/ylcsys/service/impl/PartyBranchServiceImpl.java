package com.organization.ylcsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.ylcsys.dao.PartyBranchDao;
import com.organization.ylcsys.entity.PartyBranch;
import com.organization.ylcsys.service.PartyBranchService;

@Service
public class PartyBranchServiceImpl implements PartyBranchService{
	@Autowired
	private PartyBranchDao partyBranchDao;
	
	@Override
	public List<PartyBranch> getPartyBranchListAll(){
		List<PartyBranch> partyBranchList=partyBranchDao.queryPartyBranchAll();
		return partyBranchList;
	}
	@Override
	public PartyBranch getPartyBranchById(Integer id) {
		PartyBranch targetItem=new PartyBranch();
		targetItem.setId(id);
		List<PartyBranch> partyBranchList=partyBranchDao.queryPartyBranchByTargetItem(targetItem);
		return partyBranchList.get(0);
	}
	@Override
	public boolean updatePartyBranch(PartyBranch targetItem) {
		int effectedNum=partyBranchDao.updatePartyBranchByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addPartyBranch(PartyBranch targetItem) {
		int effectedNum=partyBranchDao.insertIntoPartyBranchByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deletePartyBranchById(Integer id) {
		PartyBranch targetItem=new PartyBranch();
		targetItem.setId(id);
		int effectedNum=partyBranchDao.deletePartyBranchByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
