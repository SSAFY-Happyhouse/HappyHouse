package com.mybatis.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mybatis.vo.Notice;
import com.mybatis.vo.QnA;

public interface QnADao {

	public List<QnA> selectAll();
	public QnA selectOne(String num);
	public List<QnA> search(Map map);//검색

	public void insert(QnA b);
	public void delete(String qna_no);	
//	public void updateCount(String num);//***조회수 증가
	public void modify(QnA b);
}
