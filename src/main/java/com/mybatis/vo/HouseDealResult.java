package com.mybatis.vo;

import java.util.List;

public class HouseDealResult {
	private List<HouseDeal> houseDealList;
	private Pagination pagination;

	public List<HouseDeal> getHouseDealList() {
		return houseDealList;
	}

	public void setHouseDealList(List<HouseDeal> houseDealList) {
		this.houseDealList = houseDealList;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
