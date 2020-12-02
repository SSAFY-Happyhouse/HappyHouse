package com.mybatis.service;

import com.mybatis.vo.UserInfo;

public interface UserInfoService {
	public void create(UserInfo u);
	public UserInfo search(String userid);
	public void update(String userid, String userpwd, String email, String address, String tel);
	public void delete(String userid);
	public UserInfo login(String userid, String userpwd) throws Exception;
}
