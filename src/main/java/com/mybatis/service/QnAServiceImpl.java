package com.mybatis.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.NoticeDao;
import com.mybatis.dao.NoticeDaoImpl;
import com.mybatis.dao.QnADao;
import com.mybatis.vo.Notice;
import com.mybatis.vo.QnA;

@Service
public class QnAServiceImpl implements QnAService {

	@Autowired
	QnADao dao;
	
	@Override
	public List<QnA> selectAll() {
		return dao.selectAll();
	}

	@Override
	public QnA selectOne(String qna_no) {
		return dao.selectOne(qna_no);
	}

	@Override
	public void insert(QnA b) {
		dao.insert(b);
	}

	@Override
	public void delete(String qna_no) {
		dao.delete(qna_no);
	}

	@Override
	public void modify(QnA b) {
		dao.modify(b);
	}

	@Override
	public List<QnA> search(Map map) {
		return dao.search(map);
	}
	

}
