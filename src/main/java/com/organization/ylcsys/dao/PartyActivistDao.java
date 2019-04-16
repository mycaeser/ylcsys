package com.organization.ylcsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.organization.ylcsys.entity.PartyActivist;

public interface PartyActivistDao {
	/*
	 * 查询 ylc_party_activist 表，select * from user_info
	 * 
	 */
	List<PartyActivist> queryPartyActivistAll();
	/*
	 * 根据targetItem的信息查询 ylc_party_activist 表
	 * 
	 * 
	 */
	List<PartyActivist> queryPartyActivistByTargetItem(@Param("targetItem")PartyActivist targetItem);
	/*
	 * 根据targetItem的信息插入ylc_party_activist表
	 * 
	 */
	int insertIntoPartyActivistByTargetItem(@Param("targetItem")PartyActivist targetItem);
	/*
	 * 根据targetItem的信息更新一条ylc_party_activist记录
	 * 
	 */
	int updatePartyActivistByTargetItem(@Param("targetItem")PartyActivist targetItem);
	/*
	 * 根据targetItem的信息删除一条ylc_party_activist记录
	 */
	int deletePartyActivistByTargetItem(@Param("targetItem")PartyActivist targetItem);
}
