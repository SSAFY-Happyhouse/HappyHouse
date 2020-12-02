package com.mybatis.vo;

public class Notice {

	private String num;
	private String userid;
	private String subject;
	private String content;
	private String regtime;
	private int count;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "NoticeDto [num=" + num + ", userid=" + userid + ", subject=" + subject + ", content=" + content
				+ ", regtime=" + regtime + ", count=" + count + "]";
	}

}
