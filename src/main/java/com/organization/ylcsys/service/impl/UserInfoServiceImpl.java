package com.organization.ylcsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.ylcsys.dao.UserInfoDao;
import com.organization.ylcsys.entity.UserInfo;
import com.organization.ylcsys.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public List<UserInfo> getUserInfoListAll(){
		List<UserInfo> userInfoList=userInfoDao.queryUserInfoAll();
		return userInfoList;
	}
	@Override
	public UserInfo getUserInfoById(Integer id) {
		UserInfo targetItem=new UserInfo();
		targetItem.setId(id);
		List<UserInfo> userInfoList=userInfoDao.queryUserInfoByTargetItem(targetItem);
		return userInfoList.get(0);
	}
	@Override
	public boolean updateUserInfo(UserInfo targetItem) {
		int effectedNum=userInfoDao.updateUserInfoByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addUserInfo(UserInfo targetItem) {
		int effectedNum=userInfoDao.insertIntoUserInfoByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteUserInfoById(Integer id) {
		UserInfo targetItem=new UserInfo();
		targetItem.setId(id);
		int effectedNum=userInfoDao.deleteUserInfoByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
