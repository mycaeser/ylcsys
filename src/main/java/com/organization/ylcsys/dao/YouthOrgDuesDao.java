package com.organization.ylcsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.organization.ylcsys.entity.YouthOrgDues;

public interface YouthOrgDuesDao {
	/*
	 * 查询 ylc_youth_org_dues 表，select * from user_info
	 * 
	 */
	List<YouthOrgDues> queryYouthOrgDuesAll();
	/*
	 * 根据targetItem的信息查询 ylc_youth_org_dues 表
	 * 
	 * 
	 */
	List<YouthOrgDues> queryYouthOrgDuesByTargetItem(@Param("targetItem")YouthOrgDues targetItem);
	/*
	 * 根据targetItem的信息插入ylc_youth_org_dues表
	 * 
	 */
	int insertIntoYouthOrgDuesByTargetItem(@Param("targetItem")YouthOrgDues targetItem);
	/*
	 * 根据targetItem的信息更新一条ylc_youth_org_dues记录
	 * 
	 */
	int updateYouthOrgDuesByTargetItem(@Param("targetItem")YouthOrgDues targetItem);
	/*
	 * 根据targetItem的信息删除一条ylc_youth_org_dues记录
	 */
	int deleteYouthOrgDuesByTargetItem(@Param("targetItem")YouthOrgDues targetItem);
}
