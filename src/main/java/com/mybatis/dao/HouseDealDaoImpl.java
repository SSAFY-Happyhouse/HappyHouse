package com.mybatis.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.mapper.HouseDealMapper;
import com.mybatis.vo.HouseDeal;
import com.mybatis.vo.HousePageBean;

@Repository
public class HouseDealDaoImpl implements HouseDealDao{
	
	@Autowired
	HouseDealMapper mapper;

	@Override
	public void loadData() {}
	
	@Override
	public HouseDeal search(int no) {
		return mapper.search(no);
	}

	

	@Override
	public List<HouseDeal> searchAll(HousePageBean bean) throws SQLException {
		return mapper.searchAll(bean);
	}

	
	
}
