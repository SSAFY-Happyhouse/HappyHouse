package com.mybatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.mapper.FSelectBoxMapper;
import com.mybatis.vo.HouseInfo;
import com.mybatis.vo.SidoCode;

@Repository
public class FSelectBoxDaoImpl implements FSelectBoxDao{
	
	@Autowired
	FSelectBoxMapper mapper;
	
	@Override
	public List<SidoCode> selectSido() throws Exception {
		return mapper.selectSido();
	}
	@Override
	public List<SidoCode> selectGugun(String sido) throws Exception {
		return mapper.selectGugun(sido);
	}
	@Override
	public List<HouseInfo> selectDong(String gugun) throws Exception {
		return mapper.selectDong(gugun);
	}
	@Override
	public List<HouseInfo> selectApt(String dong) throws Exception {
		return mapper.selectApt(dong);
	}

}
