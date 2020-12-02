package com.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mybatis.vo.QnA;

public interface QnAMapper {

	public List<QnA> selectAll();
	public QnA selectOne(String qna_no);
	public List<QnA> search(Map map);
	
	public void insert(QnA b);
	public void delete(String qna_no);	
	public void modify(QnA b);
//	public void updateCount(String num);
}
