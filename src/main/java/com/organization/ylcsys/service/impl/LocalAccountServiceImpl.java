package com.organization.ylcsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.ylcsys.dao.LocalAccountDao;
import com.organization.ylcsys.entity.LocalAccount;
import com.organization.ylcsys.service.LocalAccountService;

@Service
public class LocalAccountServiceImpl implements LocalAccountService{
	@Autowired
	private LocalAccountDao localAccountDao;
	
	@Override
	public List<LocalAccount> getLocalAccountListAll(){
		List<LocalAccount> localAccountList=localAccountDao.queryLocalAccountAll();
		return localAccountList;
	}
	@Override
	public LocalAccount getLocalAccountByAccountAndPassword(String accountString,String passwordString) {
		LocalAccount targetItem=new LocalAccount();
		targetItem.setAccountString(accountString);
		targetItem.setPasswordString(passwordString);
		List<LocalAccount> localAccountList=localAccountDao.queryLocalAccountByTargetItem(targetItem);
		return localAccountList.get(0);
	}
	@Override
	public LocalAccount getLocalAccountById(long id) {
		LocalAccount targetItem=new LocalAccount();
		targetItem.setId(id);
		List<LocalAccount> localAccountList=localAccountDao.queryLocalAccountByTargetItem(targetItem);
		return localAccountList.get(0);
	}
	@Override
	public boolean updateLocalAccount(LocalAccount targetItem) {
		int effectedNum=localAccountDao.updateLocalAccountByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addLocalAccount(LocalAccount targetItem) {
		int effectedNum=localAccountDao.insertIntoLocalAccountByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteLocalAccountById(long id) {
		LocalAccount targetItem=new LocalAccount();
		targetItem.setId(id);
		int effectedNum=localAccountDao.deleteLocalAccountByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
