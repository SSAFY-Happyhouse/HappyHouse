package com.mybatis.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.mapper.UserInfoMapper;
import com.mybatis.vo.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	
	@Autowired
	UserInfoMapper mapper;
	
	@Override
	public void create(UserInfo u) throws SQLException {
		mapper.create(u);
	}

	@Override
	public UserInfo search(String userid) throws SQLException {
		return mapper.search(userid);
	}

	@Override
	public void delete(String userid) throws SQLException {
		mapper.delete(userid);
	}

	@Override
	public UserInfo login(String userid, String userpwd) throws Exception {
		return mapper.login(userid, userpwd);
	}

	@Override
	public void update(String userid, String userpwd, String email, String address, String tel) throws SQLException {
		mapper.update(userid, userpwd, email, address, tel);
	}

}
