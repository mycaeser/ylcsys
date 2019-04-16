package com.organization.ylcsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.organization.ylcsys.entity.UserInfo;


public interface UserInfoDao {
	/*
	 * 查询 hr_user_info 表，select * from user_info
	 * 
	 */
	List<UserInfo> queryUserInfoAll();
	/*
	 * 根据targetItem的信息查询 hr_user_info 表
	 * 例如：targetItem.setUserId(1);queryUserInfoByUserId(targetItem);表示查询ID为1的信息 
	 * 只允许通过主键、姓名、性别、身份证，
	 */
	List<UserInfo> queryUserInfoByTargetItem(@Param("targetItem")UserInfo targetItem);
	/*
	 * 根据targetItem的信息插入hr_user_info表
	 * 
	 */
	int insertIntoUserInfoByTargetItem(@Param("targetItem")UserInfo targetItem);
	/*
	 * 根据targetItem的信息更新一条hr_user_info记录
	 * 不能修改名字和身份证
	 */
	int updateUserInfoByTargetItem(@Param("targetItem")UserInfo targetItem);
	/*
	 * 根据targetItem的信息删除一条hr_user_info记录
	 */
	int deleteUserInfoByTargetItem(@Param("targetItem")UserInfo targetItem);
}
