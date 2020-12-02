package com.mybatis.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.NoticeDao;
import com.mybatis.dao.NoticeDaoImpl;
import com.mybatis.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	public NoticeServiceImpl() {
		noticeDao = new NoticeDaoImpl();
	}

	@Override
	public void writeNotice(Notice noticeDto) throws SQLException {
		noticeDao.writeNotice(noticeDto);
	}

	@Override
	public List<Notice> listNotice() throws SQLException {
		return noticeDao.listNotice();
	}

	@Override
	public Notice getNotice(String num) throws SQLException {
		return noticeDao.getNotice(num);
	}

	@Override
	public void modifyNotice(Notice noticeDto) throws SQLException {
		noticeDao.modifyNotice(noticeDto);
	}

	@Override
	public void deleteNotice(String num) throws SQLException {
		noticeDao.deleteNotice(num);
	}

	@Override
	public void countUp(String num) throws SQLException {
		noticeDao.countUp(num);
	}

}
