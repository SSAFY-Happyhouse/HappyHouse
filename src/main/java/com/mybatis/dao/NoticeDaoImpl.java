package com.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.mapper.NoticeMapper;
import com.mybatis.vo.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	NoticeMapper mapper;
	
	@Override
	public void writeNotice(Notice noticeDto) throws SQLException {
		mapper.writeNotice(noticeDto);
	}

	@Override
	public List<Notice> listNotice() throws SQLException {
		return mapper.listNotice();
	}

	@Override
	public Notice getNotice(String num) throws SQLException {
		return mapper.getNotice(num);
	}

	@Override
	public void modifyNotice(Notice noticeDto) throws SQLException {
		mapper.modifyNotice(noticeDto);
	}

	@Override
	public void deleteNotice(String num) throws SQLException {
		mapper.deleteNotice(num);
	}

	@Override
	public void countUp(String num) throws SQLException {
		mapper.countUp(num);
	}

	

}
