package org.maruhan.domain;

import java.sql.Date;

public class MemberVO {

	private String userId;
	private String upw;
	private String uname;
	private String email;
	private String phone;
	private Date birth;
	private String gender;
	private Date regdate;
	private Date updatedate;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	@Override
	public String toString() {
		return "userId=" + userId + ", upw=" + upw + ", uname=" + uname + ", email=" + email + ", phone="
				+ phone + ", birth=" + birth + ", gender=" + gender + ", regdate=" + regdate + ", updatedate="
				+ updatedate + "\n";
	}
	
}
