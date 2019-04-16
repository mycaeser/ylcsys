package com.organization.ylcsys.service;

import java.util.List;

import com.organization.ylcsys.entity.YouthOrgDues;

public interface YouthOrgDuesService {
	/*
	 * 查询全部团费信息
	 */
	List<YouthOrgDues> getYouthOrgDuesListAll();
	/*
	 * 通过主键查询团费信息
	 */
	YouthOrgDues getYouthOrgDuesById(Integer id);
	/*
	 * 更新一个团费信息
	 */
	boolean updateYouthOrgDues(YouthOrgDues targetItem);
	/*
	 * 添加一个团费信息
	 */
	boolean addYouthOrgDues(YouthOrgDues targetItem);
	/*
	 * 删除一条团费信息
	 */
	boolean deleteYouthOrgDuesById(Integer id);
}
