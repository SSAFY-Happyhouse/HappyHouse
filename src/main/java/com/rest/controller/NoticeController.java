package com.rest.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.service.NoticeService;
import com.mybatis.vo.Notice;
import com.mybatis.vo.UserInfo;

@Controller
public class NoticeController {

	@Autowired
	NoticeService service;

	@GetMapping(value = "nlist.do")
	public String nlist(HttpServletRequest request) {
		String path = "common/message";
		try {
			List<Notice> notices = service.listNotice();
			request.setAttribute("notices", notices);
			path = "notice/nlist";
		} catch (Exception e) { // 오류
			e.printStackTrace();
			request.setAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
		}
		return path;
	}

	@GetMapping(value = "write.do")
	public String write(Model model, HttpServletRequest request) { // 로그인을 해야 글작성 버튼을 누를 수 있다.
		
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
		String path = "common/message";
		
		if (userInfo != null) { 
			path = "notice/write";
		} else {
			request.setAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
		}
		return path;
	}

	@PostMapping(value = "writeProcess.do")
	public String writeProcess(Model model, HttpServletRequest request) { // 로그인을 해야 글작성-확인 버튼을 누를 수 있다.

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
		String path = "common/message";

		if (userInfo != null) {

			Notice noticeDto = new Notice();
			noticeDto.setUserid(userInfo.getUserid()); // 작성자
			noticeDto.setSubject(request.getParameter("subject")); // 제목
			noticeDto.setContent(request.getParameter("content")); // 내용

			try {
				service.writeNotice(noticeDto);
				path = "redirect:/nlist.do";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 작성중 문제가 발생했습니다.");
			}
		} else {
			request.setAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
		}
		return path;
	}

	@GetMapping(value = "read.do")
	public String read(HttpServletRequest request) { // 누구나 읽을 수 있다.
		String path = "common/message";
		String num = request.getParameter("num");
		try {
			service.countUp(num); // 상세보기를 하면 조회수가 늘어난다.
			Notice noticeDto = service.getNotice(num); // 상세보기를 하면 조회수가 늘어난다.
			request.setAttribute("notice", noticeDto);
			path = "notice/read";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글을 읽어오는 중 문제가 발생했습니다.");
		}
		return path;
	}

	@GetMapping(value = "nmodify.do")
	public String modify(HttpServletRequest request) { // 수정버튼을 누른다. 글쓴이만 수정할 수 있다.

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
		String path = "common/message";

		if (userInfo != null) { // 로그인 했다.
			try {
				String num = request.getParameter("num");  
				Notice noticeDto = service.getNotice(num);
				
				if(noticeDto.getUserid().equals(userInfo.getUserid())) { // 현재 글쓴이 아이디랑 로그인아이디랑 같다면
					System.out.println(">>>nmodify.do");
					request.setAttribute("notice", noticeDto);
					path = "notice/modify";
				}
				else {  // 현재 글쓴이 아이디랑 로그인아이디랑 같지 않다면
					request.setAttribute("msg", "글쓴이만 수정할 수 있습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글을 읽어오는 중 문제가 발생했습니다.");
			}
		} else {				// 로그인을 하지 않았다.
			request.setAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
		}
		return path;
	}

	@PostMapping(value = "nmodifyProcess.do") // 글쓴이만 삭제할 수 있게 처리를 안해줬다.
	public String nmodifyProcess(Model model, HttpServletRequest request) {

		String path = "common/message";
		Notice noticeDto = new Notice();

		noticeDto.setNum(request.getParameter("num"));
		noticeDto.setSubject(request.getParameter("subject"));
		noticeDto.setContent(request.getParameter("content"));

		try {
			service.modifyNotice(noticeDto);
			System.out.println(">>>nmodifyProcess.do");
			path = "redirect:/nlist.do";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글작성중 문제가 발생했습니다.");
		}
		return path;
	}

	@GetMapping(value = "ndelete.do") // 글쓴이만 삭제할 수 있다.
	public String ndelete(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
		String path = "common/message";
		
		if (userInfo != null) { // 로그인 했다.
			try {
				String num = request.getParameter("num");  
				Notice noticeDto = service.getNotice(num);
				if(noticeDto.getUserid().equals(userInfo.getUserid())) { // 현재 글쓴이 아이디랑 로그인아이디랑 같다면
					service.deleteNotice(num);
					path = "redirect:/nlist.do";
				}
				else { // 현재 글쓴이 아이디랑 로그인아이디랑 같지 않다면
					request.setAttribute("msg", "글쓴이만 삭제할 수 있습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 삭제중 문제가 발생했습니다.");
			}
		}else { // 로그인을 하지 않았다.
			request.setAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
		}
		return path;
	}
}
