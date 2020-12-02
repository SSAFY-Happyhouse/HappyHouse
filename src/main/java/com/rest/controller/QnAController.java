package com.rest.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.service.NoticeService;
import com.mybatis.service.QnAService;
import com.mybatis.vo.Notice;
import com.mybatis.vo.QnA;
import com.mybatis.vo.UserInfo;

@CrossOrigin(origins= {"*"}, maxAge=6000)
@RestController
public class QnAController {
	@Autowired
	QnAService service;
	
	
	
	//게시판 목록화면
	@RequestMapping(value="/qna", method = RequestMethod.GET)
	public List<QnA> list(Model model) {
		return service.selectAll();
	}
	
	//글 읽기
	@RequestMapping(value = "/qna/{qna_no}", method = RequestMethod.GET)
	public QnA read(@PathVariable String qna_no) {		
		
		return service.selectOne(qna_no);			
		
	}	
	
	//글 수정
	@PutMapping(value = "/qna")	
	public Map modify(@RequestBody QnA b) {		
		System.out.println("b>>"+b);
		service.modify(b);
		Map<String, String> map = new HashMap<>();
		map.put("result", "modify success");
		return map;
	}	
	
	//글 등록
	@PostMapping(value = "/qna")
	public Map insert(@RequestBody QnA b) {		
		service.insert(b);	
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "insert success");
		return map;
	}
	
	//글 검색: 이름 or 제목(like 검색)	
	//http://localhost:port/rest/board/name/t
	@GetMapping(value = "/qna/{condition}/{word}")
	public List<QnA> search(@PathVariable String condition, @PathVariable String word) {		
		Map<String, String> map = new HashMap<>();
		map.put(condition, word);
		return service.search(map);
		
	}
	
	//글 삭제
	@DeleteMapping(value = "/qna/{qna_no}")	
	public Map delete(@PathVariable String qna_no) {	
		System.out.println("qna_no>>>>"+qna_no);
		service.delete(qna_no);		
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "delete success");
		return map;
	}
}
