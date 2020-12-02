package com.mybatis.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mybatis.vo.Notice;
import com.mybatis.vo.QnA;

public interface QnAService {
	
	public List<QnA> selectAll();
	public QnA selectOne(String qna_no);
	public void insert(QnA b);
	public void delete(String qna_no);
	
	public void modify(QnA b);
	public List<QnA> search(Map map);//검색

}
