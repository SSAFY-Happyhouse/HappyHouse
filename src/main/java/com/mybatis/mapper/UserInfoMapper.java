package com.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.mybatis.vo.UserInfo;

public interface UserInfoMapper {

	public void create(UserInfo u);
	public UserInfo search(String userid);
	public void update(String userid, String userpwd, String email, String address, String tel);
	public void delete(String userid);
	public UserInfo login(@Param("userid") String userid, @Param("userpwd") String userpwd) throws Exception;

}