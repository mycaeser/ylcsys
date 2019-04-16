package com.organization.ylcsys.service;

import java.util.List;

import com.organization.ylcsys.entity.LocalAccount;


public interface LocalAccountService {
	/*
	 * 查询全部本地账号
	 */
	List<LocalAccount> getLocalAccountListAll();
	/**
	 * 通过用户名密码查询
	 * @param userNameString
	 * @param passwordString
	 * @return
	 */
	LocalAccount getLocalAccountByAccountAndPassword(String accountString,String passwordString);
	/*
	 * 通过主键查询账号
	 */
	LocalAccount getLocalAccountById(long id);
	/*
	 * 更新一个账号
	 */
	boolean updateLocalAccount(LocalAccount targetItem);
	/*
	 * 添加一个账号
	 */
	boolean addLocalAccount(LocalAccount targetItem);
	/*
	 * 删除一条账号
	 */
	boolean deleteLocalAccountById(long id);
}
