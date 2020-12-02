package com.mybatis.service;

import java.sql.SQLException;
import java.util.List;

import com.mybatis.vo.Notice;

public interface NoticeService {

	public void writeNotice(Notice noticeDto) throws SQLException;
	public List<Notice> listNotice() throws SQLException;
	public Notice getNotice(String num) throws SQLException;
	public void modifyNotice(Notice noticeDto) throws SQLException;
	public void deleteNotice(String num) throws SQLException;
	public void countUp(String num) throws SQLException;

}
