package com.organization.ylcsys.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class YouthOrgDues {
	//团费表主键
	private Integer id;
	//用户编号
	private Integer userId;
	//用户名
	private String userNameString;
	//团费价格
	private Integer duesValue;
	//团费缴费时间
	private Date duesDate;
	//是否减免
	private Integer isDeduction;
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
	public Integer getDuesValue() {
		return duesValue;
	}
	public void setDuesValue(Integer duesValue) {
		this.duesValue = duesValue;
	}
	public Date getDuesDate() {
		return duesDate;
	}
	public void setDuesDate(Date duesDate) {
		this.duesDate = duesDate;
	}
	public Integer getIsDeduction() {
		return isDeduction;
	}
	public void setIsDeduction(Integer isDeduction) {
		this.isDeduction = isDeduction;
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
