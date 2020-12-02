package com.mybatis.vo;
// KN: userinfo 테이블 안의 레코드 1건의 정보를 저장하기 위한 객체

public class UserInfo {
	private String username;
	private String userid;
	private String userpwd;
	private String email;
	private String tel;
	private String address;

	public UserInfo() {
	}

	public UserInfo(String username, String userid, String userpwd, String email, String tel, String address) {
		this.username = username;
		this.userid = userid;
		this.userpwd = userpwd;
		this.email = email;
		this.tel = tel;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
