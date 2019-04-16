package com.organization.ylcsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.organization.ylcsys.entity.YouthOrg;

public interface YouthOrgDao {
	/*
	 * 查询 ylc_youth_org 表，select * from user_info
	 * 
	 */
	List<YouthOrg> queryYouthOrgAll();
	/*
	 * 根据targetItem的信息查询 ylc_youth_org 表
	 * 
	 * 
	 */
	List<YouthOrg> queryYouthOrgByTargetItem(@Param("targetItem")YouthOrg targetItem);
	/*
	 * 根据targetItem的信息插入ylc_youth_org表
	 * 
	 */
	int insertIntoYouthOrgByTargetItem(@Param("targetItem")YouthOrg targetItem);
	/*
	 * 根据targetItem的信息更新一条ylc_youth_org记录
	 * 
	 */
	int updateYouthOrgByTargetItem(@Param("targetItem")YouthOrg targetItem);
	/*
	 * 根据targetItem的信息删除一条ylc_youth_org记录
	 */
	int deleteYouthOrgByTargetItem(@Param("targetItem")YouthOrg targetItem);
}
