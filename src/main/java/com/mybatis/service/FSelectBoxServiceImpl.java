package com.mybatis.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.FSelectBoxDao;
import com.mybatis.vo.HouseInfo;
import com.mybatis.vo.SidoCode;

@Service
public class FSelectBoxServiceImpl implements FSelectBoxService{
	@Autowired
	private FSelectBoxDao dao;
	
	@Override
	public List<SidoCode> selectSido() throws Exception {
		List<SidoCode> list = dao.selectSido();
		return list;
	}

	@Override
	public List<SidoCode> selectGugun(String sido) throws Exception {
		List<SidoCode> list = dao.selectGugun(sido);
		return list;
	}

	@Override
	public List<HouseInfo> selectDong(String gugun) throws Exception {
		List<HouseInfo> list = dao.selectDong(gugun);
		return list;
	}

	@Override
	public List<HouseInfo> selectApt(String dong) throws Exception {
		List<HouseInfo> list = dao.selectApt(dong);
		return list;
	}

}
