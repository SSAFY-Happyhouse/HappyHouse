package com.mybatis.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.mapper.NoticeMapper;
import com.mybatis.mapper.QnAMapper;
import com.mybatis.vo.Notice;
import com.mybatis.vo.QnA;

@Repository
public class QnADaoImpl implements QnADao {

	@Autowired
	QnAMapper mapper;
	
	@Override
	public List<QnA> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public QnA selectOne(String qna_no) {
		return mapper.selectOne(qna_no);
	}

	@Override
	public List<QnA> search(Map map) {
		return mapper.search(map);
	}

	@Override
	public void insert(QnA b) {
		mapper.insert(b);
	}

	@Override
	public void delete(String qna_no) {
		mapper.delete(qna_no);
	}

//	@Override
//	public void updateCount(String num) {
//		mapper.updateCount(num);
//	}

	@Override
	public void modify(QnA b) {
		mapper.modify(b);
	}
	

	

}
