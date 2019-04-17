package com.organization.ylcsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.ylcsys.dao.YouthOrgDuesDao;
import com.organization.ylcsys.entity.YouthOrgDues;
import com.organization.ylcsys.service.YouthOrgDuesService;

@Service
public class YouthOrgDuesServiceImpl implements YouthOrgDuesService{
	@Autowired
	private YouthOrgDuesDao youthOrgDuesDao;
	
	@Override
	public List<YouthOrgDues> getYouthOrgDuesListAll(){
		List<YouthOrgDues> youthOrgDuesList=youthOrgDuesDao.queryYouthOrgDuesAll();
		return youthOrgDuesList;
	}
	@Override
	public YouthOrgDues getYouthOrgDuesById(Integer id) {
		YouthOrgDues targetItem=new YouthOrgDues();
		targetItem.setId(id);
		List<YouthOrgDues> youthOrgDuesList=youthOrgDuesDao.queryYouthOrgDuesByTargetItem(targetItem);
		return youthOrgDuesList.get(0);
	}
	@Override
	public boolean updateYouthOrgDues(YouthOrgDues targetItem) {
		int effectedNum=youthOrgDuesDao.updateYouthOrgDuesByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addYouthOrgDues(YouthOrgDues targetItem) {
		int effectedNum=youthOrgDuesDao.insertIntoYouthOrgDuesByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteYouthOrgDuesById(Integer id) {
		YouthOrgDues targetItem=new YouthOrgDues();
		targetItem.setId(id);
		int effectedNum=youthOrgDuesDao.deleteYouthOrgDuesByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
