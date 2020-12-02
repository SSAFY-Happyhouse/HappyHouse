package com.mybatis.mapper;

import java.util.List;
import com.mybatis.vo.HouseInfo;
import com.mybatis.vo.SidoCode;

public interface FSelectBoxMapper {
	List<SidoCode> selectSido() throws Exception;
	List<SidoCode> selectGugun(String sido) throws Exception;
	List<HouseInfo> selectDong(String gugun) throws Exception;
	List<HouseInfo> selectApt(String dong) throws Exception;
}
