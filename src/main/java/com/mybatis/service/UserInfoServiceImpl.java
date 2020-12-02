package com.mybatis.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.UserInfoDao;
import com.mybatis.dao.UserInfoDaoImpl;
import com.mybatis.vo.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoDao userinfoDao;

	public UserInfoServiceImpl() {
		userinfoDao = new UserInfoDaoImpl();
	}

	@Override
	public void create(UserInfo u) {
		try {
			userinfoDao.create(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public UserInfo search(String userid) {
		try {
			return userinfoDao.search(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(String userid, String userpwd, String email, String address, String tel) {
		try {
			userinfoDao.update(userid, userpwd, email, address, tel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String userid) {
		try {
			userinfoDao.delete(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserInfo login(String userid, String userpwd) throws Exception {
		if(userid == null || userpwd == null)
			return null;
		return userinfoDao.login(userid, userpwd);
	}

}
