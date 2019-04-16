package com.organization.ylcsys.service;

import java.util.List;

import com.organization.ylcsys.entity.PartyBranch;

public interface PartyBranchService {
	/*
	 * 查询全部党支部信息
	 */
	List<PartyBranch> getPartyBranchListAll();
	/*
	 * 通过主键查询党支部信息
	 */
	PartyBranch getPartyBranchById(Integer id);
	/*
	 * 更新一个党支部信息
	 */
	boolean updatePartyBranch(PartyBranch targetItem);
	/*
	 * 添加一个党支部信息
	 */
	boolean addPartyBranch(PartyBranch targetItem);
	/*
	 * 删除一条党支部信息
	 */
	boolean deletePartyBranchById(Integer id);
}
