package com.organization.ylcsys.service;

import java.util.List;

import com.organization.ylcsys.entity.UserInfo;

public interface UserInfoService {
	/*
	 * 查询全部用户信息
	 */
	List<UserInfo> getUserInfoListAll();
	/*
	 * 通过主键查询用户信息
	 */
	UserInfo getUserInfoById(Integer id);
	/*
	 * 更新一个用户信息
	 */
	boolean updateUserInfo(UserInfo targetItem);
	/*
	 * 添加一个用户信息
	 */
	boolean addUserInfo(UserInfo targetItem);
	/*
	 * 删除一条用户信息
	 */
	boolean deleteUserInfoById(Integer id);
}
