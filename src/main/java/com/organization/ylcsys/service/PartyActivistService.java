package com.organization.ylcsys.service;

import java.util.List;

import com.organization.ylcsys.entity.PartyActivist;

public interface PartyActivistService {
	/*
	 * 查询全部积极分子信息
	 */
	List<PartyActivist> getPartyActivistListAll();
	/*
	 * 通过主键查询积极分子信息
	 */
	PartyActivist getPartyActivistById(Integer id);
	/*
	 * 更新一个积极分子信息
	 */
	boolean updatePartyActivist(PartyActivist targetItem);
	/*
	 * 添加一个积极分子信息
	 */
	boolean addPartyActivist(PartyActivist targetItem);
	/*
	 * 删除一条积极分子信息
	 */
	boolean deletePartyActivistById(Integer id);
}
