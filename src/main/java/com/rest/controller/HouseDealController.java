package com.rest.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.service.HouseDealService;
import com.mybatis.service.NoticeService;
import com.mybatis.service.UserInfoService;
import com.mybatis.vo.HouseDeal;
import com.mybatis.vo.HouseDealResult;
import com.mybatis.vo.HousePageBean;
import com.mybatis.vo.Notice;
import com.mysql.cj.Session;


@Controller
public class HouseDealController {
	
	@Autowired
	HouseDealService service;
	

	@GetMapping(value = "/index.do")
	public String index(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		//System.out.println("찍어보기.");
		
		request.setAttribute("housePageBean", new HousePageBean());
		String path = "apt/googleMap";
		
		return path;
	}
	
	@GetMapping(value = "/QnA.do")
	public String QnA() {
		return "redirect:/start.html";
	}
	
	@GetMapping(value = "/list.do")
	public String list(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		//System.out.println("list.do");
		
		String name = request.getParameter("name");
		String select = request.getParameter("select");
		
		name = name == null ? "" : name;
		select = select == null ? "" : select;
		HousePageBean housePageBean = new HousePageBean();
		String[] values = request.getParameterValues("type");
		//System.out.println(">>>>"+Arrays.toString(values));
		
		if(values != null) {
			boolean[] searchType = { false, false, false, false };
			for (int i = 0; i < values.length; i++) {
				if (values[i].equals("0")) {
					searchType[0] = true;
				} else if (values[i].equals("1")) {
					searchType[1] = true;
				} else if (values[i].equals("2")) {
					searchType[2] = true;
				} else if (values[i].equals("3")) {
					searchType[3] = true;
				}
			}
			housePageBean.setSearchType(searchType);
		}
		if (select.equals("동")) { // 동이면 동이름 세팅
			housePageBean.setDong(name);
		} else { // 아파트면 아파트 이름세팅
			housePageBean.setAptname(name);
		}
		request.setAttribute("housePageBean", housePageBean);
		request.setAttribute("select", select);
		request.setAttribute("name", name);
		int pageNo = 1;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		housePageBean.setPageNo(pageNo);
		System.out.println("housePagebean:>>"+housePageBean);
		
		HouseDealResult houseDealResult = service.searchAll(housePageBean);
		request.setAttribute("list", houseDealResult.getHouseDealList());
		request.setAttribute("pagination", houseDealResult.getPagination());
		
		return "apt/search";
	}
	
	@GetMapping(value = "/search.do")
	public String search(HttpSession session){
		session.setAttribute("housePageBean", new HousePageBean());
		return "apt/search";
	}
	
	@GetMapping(value = "detail.do")
	public String detail(HttpServletRequest request){
		
		String path = "common/message";
		String no = request.getParameter("no");
		try {
			HouseDeal b = service.search(Integer.parseInt(no));
			request.setAttribute("b", b);
			path = "apt/detail";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글을 읽어오는 중 문제가 발생했습니다.");
		}
		return path;
	}
	
}
