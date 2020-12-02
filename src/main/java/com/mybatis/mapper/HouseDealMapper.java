package com.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mybatis.vo.HouseDeal;
import com.mybatis.vo.HousePageBean;

public interface HouseDealMapper {
	public List<HouseDeal> searchAll(HousePageBean  bean) throws SQLException;
	public HouseDeal search(int no);
}
