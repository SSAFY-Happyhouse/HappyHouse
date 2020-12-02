package com.mybatis.dao;

import java.sql.SQLException;

import com.mybatis.vo.UserInfo;

public interface UserInfoDao {
	public void create(UserInfo u) throws SQLException;
	public UserInfo search(String userid) throws SQLException;
	public void update(String userid, String userpwd, String email, String address, String tel) throws SQLException;
	public void delete(String userid) throws SQLException;
	public UserInfo login(String userid, String userpwd) throws Exception;
}
