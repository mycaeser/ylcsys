package com.organization.ylcsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.organization.ylcsys.entity.PartyBranch;

public interface PartyBranchDao {
	/*
	 * 查询 ylc_party_branch 表，select * from user_info
	 * 
	 */
	List<PartyBranch> queryPartyBranchAll();
	/*
	 * 根据targetItem的信息查询 ylc_party_branch 表
	 * 
	 * 
	 */
	List<PartyBranch> queryPartyBranchByTargetItem(@Param("targetItem")PartyBranch targetItem);
	/*
	 * 根据targetItem的信息插入ylc_party_branch表
	 * 
	 */
	int insertIntoPartyBranchByTargetItem(@Param("targetItem")PartyBranch targetItem);
	/*
	 * 根据targetItem的信息更新一条ylc_party_branch记录
	 * 不能修改名字和身份证
	 */
	int updatePartyBranchByTargetItem(@Param("targetItem")PartyBranch targetItem);
	/*
	 * 根据targetItem的信息删除一条ylc_party_branch记录
	 */
	int deletePartyBranchByTargetItem(@Param("targetItem")PartyBranch targetItem);
}
