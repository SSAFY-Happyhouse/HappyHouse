package com.mybatis.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.HouseDealDao;
import com.mybatis.dao.HouseDealDaoImpl;
import com.mybatis.happyhouse.HappyHouseException;
import com.mybatis.vo.HouseDeal;
import com.mybatis.vo.HouseDealResult;
import com.mybatis.vo.HousePageBean;
import com.mybatis.vo.Pagination;

@Service
public class HouseDealServiceImpl implements HouseDealService{

	@Autowired
	HouseDealDao dao;
	

	public HouseDealServiceImpl() {
		 dao =new HouseDealDaoImpl();
	}
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	
	public HouseDealResult searchAll(HousePageBean  bean){
		try {
			
			System.out.println(">>>>>>service");
//			boolean[] types = bean.getSearchType();
//			int cnt = 0;
//			for (boolean t : types) {
//				if(t) {
//					cnt++;
//				}
//			}
//			
//			if(cnt == 0) {
//				throw new HappyHouseException("주택타입은 반드시 한개이상 선택해야합니다");
//			}
			
			List<HouseDeal> houseDealList = dao.searchAll(bean);
			System.out.println(houseDealList.size());
			System.out.println(bean.getAptname());
			Pagination pagination = new Pagination(bean.getPageNo(), houseDealList.size(), 30, 10);
			
			HouseDealResult houseDealResult = new HouseDealResult();
			houseDealResult.setHouseDealList(houseDealList.subList(pagination.getCurrentGroupFirstIndex(), pagination.getCurrentGroupLastIndex()));
			houseDealResult.setPagination(pagination);
			
			return houseDealResult;
			
		}catch (SQLException e) {
			throw new HappyHouseException("주택정보 조회중 오류 발생");
		}
			
	}
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public HouseDeal search(int no) {
		try {
			HouseDeal deal = dao.search(no);
			if(deal == null) {
				throw new HappyHouseException("거래번호 %d에 해당하는 주택 거래정보가 존재하지 않습니다.");
			}
			return deal;
		}catch(Exception e) {
			throw new HappyHouseException("주택 거래정보 조회중 오류");
		}
	}




	
	
	
}