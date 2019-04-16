package com.organization.ylcsys.service;

import java.util.List;

import com.organization.ylcsys.entity.YouthOrg;

public interface YouthOrgService {
	/*
	 * 查询全部团组织信息
	 */
	List<YouthOrg> getYouthOrgListAll();
	/*
	 * 通过主键查询团组织信息
	 */
	YouthOrg getYouthOrgById(Integer id);
	/*
	 * 更新一个团组织信息
	 */
	boolean updateYouthOrg(YouthOrg targetItem);
	/*
	 * 添加一个团组织信息
	 */
	boolean addYouthOrg(YouthOrg targetItem);
	/*
	 * 删除一条团组织信息
	 */
	boolean deleteYouthOrgById(Integer id);
}
