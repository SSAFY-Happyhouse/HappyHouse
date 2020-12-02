package com.rest.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mybatis.service.UserInfoService;
import com.mybatis.vo.UserInfo;

@Controller
public class UserInfoController {
	
	@Autowired
	UserInfoService service;
	
	@GetMapping(value = "join.do")
	public String write() {
		return "user/join";
	}

	@PostMapping(value = "joinProcess.do")
	public String joinProcess(UserInfo userinfo, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String emailid = request.getParameter("emailid");
		String emaildomain = request.getParameter("emaildomain");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String address = request.getParameter("address");
		String address_detail = request.getParameter("address_detail");

		UserInfo u = new UserInfo(username, userid, userpwd, emailid + "@" + emaildomain, tel1 + tel2 + tel3,
				address + " " + address_detail);
		service.create(u);

		request.setAttribute("u", u);
		request.setAttribute("msg", "회원가입이 완료되었습니다.");
		String path = "common/message";
		return path;
		
	}
	
	@GetMapping(value = "login.do")
	public String login() {
		System.out.println(">>>login");
		return "user/login";
	}
		
	@PostMapping(value = "loginProcess.do")
	public String login2(HttpSession session, HttpServletResponse response, HttpServletRequest request) {//로그인 처리.session에 저장
		
		String path = "index";
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		try {
			UserInfo UserInfo = service.login(userid, userpwd);
			if (UserInfo != null) {
				session = request.getSession();
				session.setAttribute("userinfo", UserInfo);

				String idsave = request.getParameter("idsave");
				if ("saveok".equals(idsave)) {
					Cookie cookie = new Cookie("ssafy_id", userid);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);// 40년간 저장.
					response.addCookie(cookie);
				} else {
					Cookie cookies[] = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if ("ssafy_id".equals(cookie.getName())) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
				request.setAttribute("msg", "정상적으로 로그인 되었습니다.");
			} else {
				request.setAttribute("msg", "아이디 또는 패스워드가 틀립니다.");
			}
			path = "common/message";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
			path = "common/message";
		}
		
		return path;
	}
	
	@GetMapping(value = "logout.do")
	public String logout(HttpSession session,  HttpServletRequest request) {//로그인 처리.session에 저장
		session.removeAttribute("userinfo");
		request.setAttribute("msg", "로그아웃이 완료되었습니다.");
		
		return "common/message";
	}
	
	
	@GetMapping(value = "userInfo.do")
	public String userInfo(HttpSession session,  HttpServletRequest request) {
		return "user/userInfo";
	}
	
	@GetMapping(value = "modify.do")
	public String modify(HttpSession session,  HttpServletRequest request) {
		return "user/modify";
	}
	
	@PostMapping(value = "modifyProcess.do")
	public String modifyProcess(HttpSession session,  HttpServletRequest request, HttpServletResponse response) {

		
		String path = "index";
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("emailid");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		try {
			
			service.update(userid, userpwd, email, address, tel);
			session = request.getSession();
			UserInfo userinfo = new UserInfo(username, userid, userpwd, email, tel, address);
			session.setAttribute("userinfo", userinfo);
			request.setAttribute("msg", "정보 수정이 완료되었습니다.");
			path = "common/message";
			
			return path;
//			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "정보 수정 중 문제가 발생했습니다.");
			path = "common/message";
			return path;
//			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
		//		String path = "index";
//		try {
//			service.update(userinfo.getUserid(), userinfo.getUserpwd(), userinfo.getEmail(), userinfo.getAddress(), userinfo.getTel());
//			UserInfo u = new UserInfo(userinfo.getUsername(), userinfo.getUserid(), userinfo.getUserpwd(), userinfo.getEmail(), userinfo.getTel(),userinfo.getAddress());
//			session.setAttribute("userinfo", u);
//			request.setAttribute("msg", "정보 수정이 완료되었습니다.");
//			path = "common/message";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "정보 수정 중 문제가 발생했습니다.");
//			path = "common/message";
//		}
//		
//		return path;
	}
	
	@GetMapping(value = "delete.do")
	public String delete(HttpSession session, HttpServletRequest request) {
		
		String path = "index";
		String userid = request.getParameter("userid");

		try {
			session = request.getSession();
			session.removeAttribute("userinfo");
			service.delete(userid);
			request.setAttribute("msg", "탈퇴가 완료되었습니다.");
			path = "common/message";
			return path;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "탈퇴 중 문제가 발생했습니다.");
			path = "common/message";
			return path;
		}
	}
	
}
