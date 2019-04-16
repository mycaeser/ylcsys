package com.organization.ylcsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.ylcsys.dao.YouthOrgDao;
import com.organization.ylcsys.entity.YouthOrg;
import com.organization.ylcsys.service.YouthOrgService;

@Service
public class YouthOrgServiceImpl implements YouthOrgService{
	@Autowired
	public YouthOrgDao youthOrgDao;
	
	@Override
	public List<YouthOrg> getYouthOrgListAll(){
		List<YouthOrg> youthOrgList=youthOrgDao.queryYouthOrgAll();
		return youthOrgList;
	}
	@Override
	public YouthOrg getYouthOrgById(Integer id) {
		YouthOrg targetItem=new YouthOrg();
		targetItem.setId(id);
		List<YouthOrg> youthOrgList=youthOrgDao.queryYouthOrgByTargetItem(targetItem);
		return youthOrgList.get(0);
	}
	@Override
	public boolean updateYouthOrg(YouthOrg targetItem) {
		int effectedNum=youthOrgDao.updateYouthOrgByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addYouthOrg(YouthOrg targetItem) {
		int effectedNum=youthOrgDao.insertIntoYouthOrgByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteYouthOrgById(Integer id) {
		YouthOrg targetItem=new YouthOrg();
		targetItem.setId(id);
		int effectedNum=youthOrgDao.deleteYouthOrgByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
