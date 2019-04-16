package com.organization.ylcsys.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class PartyActivist {
	//积极分子主键
	private Integer id;
	//用户编号
	private Integer userId;
	//用户名
	private String userNameString;
	//申请时间
	private Date applyDate;
	//审核状态
	private Integer isChecked;
	//审核意见
	private String isCheckedOpinion;
	//创建时间
	private Timestamp createTime;
	//最后修改时间
	private Timestamp lastEditTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserNameString() {
		return userNameString;
	}
	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Integer getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(Integer isChecked) {
		this.isChecked = isChecked;
	}
	public String getIsCheckedOpinion() {
		return isCheckedOpinion;
	}
	public void setIsCheckedOpinion(String isCheckedOpinion) {
		this.isCheckedOpinion = isCheckedOpinion;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Timestamp lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
