package com.organization.ylcsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.organization.ylcsys.entity.LocalAccount;


public interface LocalAccountDao {
	/*
	 * 查询 ylc_local_account 表，select * from ylc_local_account
	 */
	List<LocalAccount> queryLocalAccountAll();
	/*
	 * 根据具体项 查询 ylc_local_account 表
	 * 只允许根据编号 查询
	 */
	List<LocalAccount> queryLocalAccountByTargetItem(@Param("targetItem") LocalAccount targetItem);
	/*
	 * 插入 ylc_local_account 表一条
	 */
	int insertIntoLocalAccountByTargetItem(@Param("targetItem") LocalAccount targetItem);
	/*
	 * 更新 ylc_local_account 表一条
	 * 只允许根据编号更新
	 */
	int updateLocalAccountByTargetItem(@Param("targetItem") LocalAccount targetItem);
	/*
	 * 删除 ylc_local_account 表一条
	 * 只允许根据编号删除
	 */
	int deleteLocalAccountByTargetItem(@Param("targetItem") LocalAccount targetItem);
}
