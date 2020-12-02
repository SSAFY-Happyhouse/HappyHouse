package com.mybatis.vo;

public class Pagination {
	private int currentPage;
	private int totalPageCount;
	private int totalItemCount;
	private int pageSize;
	private int pageGroupSize;
	private int currentGroupFirstPage;
	private int currentGroupLastPage;
	private int currentGroupFirstIndex;
	private int currentGroupLastIndex;
	private boolean isFirstPageGroup;
	private boolean isLastPageGroup;

	public Pagination(int currentPage, int totalItemCount, int pageSize, int pageGroupSize) {
		this.currentPage = currentPage;
		this.totalItemCount = totalItemCount;
		this.pageSize = pageSize;
		this.pageGroupSize = pageGroupSize;

		if (this.totalItemCount == 0) {
			this.totalPageCount = 1;
		} else {
			this.totalPageCount = ((this.totalItemCount - 1) / this.pageSize) + 1;
		}

		int currentPageGroup = (this.currentPage - 1) / this.pageGroupSize;
		this.currentGroupFirstPage = currentPageGroup * pageGroupSize + 1;
		this.currentGroupLastPage = (currentPageGroup + 1) * pageGroupSize;

		if (this.currentGroupLastPage > totalPageCount) {
			this.currentGroupLastPage = totalPageCount;
		}

		this.currentGroupFirstIndex = (this.currentPage - 1) * this.pageSize;
		this.currentGroupLastIndex = this.currentPage * this.pageSize;

		if (this.currentGroupLastIndex > this.totalItemCount) {
			this.currentGroupLastIndex = this.totalItemCount;
		}
		
		this.isFirstPageGroup = currentPageGroup == 0;
		this.isLastPageGroup = currentPageGroup == ((this.totalPageCount - 1) / this.pageGroupSize);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getTotalItemCount() {
		return totalItemCount;
	}

	public void setTotalItemCount(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageGroupSize() {
		return pageGroupSize;
	}

	public void setPageGroupSize(int pageGroupSize) {
		this.pageGroupSize = pageGroupSize;
	}

	public int getCurrentGroupFirstPage() {
		return currentGroupFirstPage;
	}

	public void setCurrentGroupFirstPage(int currentGroupFirstPage) {
		this.currentGroupFirstPage = currentGroupFirstPage;
	}

	public int getCurrentGroupLastPage() {
		return currentGroupLastPage;
	}

	public void setCurrentGroupLastPage(int currentGroupLastPage) {
		this.currentGroupLastPage = currentGroupLastPage;
	}

	public int getCurrentGroupFirstIndex() {
		return currentGroupFirstIndex;
	}

	public void setCurrentGroupFirstIndex(int currentGroupFirstIndex) {
		this.currentGroupFirstIndex = currentGroupFirstIndex;
	}

	public int getCurrentGroupLastIndex() {
		return currentGroupLastIndex;
	}

	public void setCurrentGroupLastIndex(int currentGroupLastIndex) {
		this.currentGroupLastIndex = currentGroupLastIndex;
	}

	public boolean getIsFirstPageGroup() {
		return isFirstPageGroup;
	}

	public void setFirstPageGroup(boolean isFirstPageGroup) {
		this.isFirstPageGroup = isFirstPageGroup;
	}

	public boolean getIsLastPageGroup() {
		return isLastPageGroup;
	}

	public void setLastPageGroup(boolean isLastPageGroup) {
		this.isLastPageGroup = isLastPageGroup;
	}
}
