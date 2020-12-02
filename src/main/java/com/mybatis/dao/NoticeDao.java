package com.mybatis.dao;

import java.sql.SQLException;
import java.util.List;
import com.mybatis.vo.Notice;

public interface NoticeDao {

	public void writeNotice(Notice notice) throws SQLException;
	public List<Notice> listNotice() throws SQLException;
	public Notice getNotice(String num) throws SQLException;
	public void modifyNotice(Notice notice) throws SQLException;
	public void deleteNotice(String num) throws SQLException;
	public void countUp(String num) throws SQLException;
}
