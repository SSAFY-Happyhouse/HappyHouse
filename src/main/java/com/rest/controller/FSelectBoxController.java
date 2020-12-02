package com.rest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mybatis.service.FSelectBoxService;
import com.mybatis.service.NoticeService;
import com.mybatis.vo.HouseInfo;
import com.mybatis.vo.Notice;
import com.mybatis.vo.SidoCode;
import com.mybatis.vo.UserInfo;

@Controller
public class FSelectBoxController {

	@Autowired
	FSelectBoxService service;

	@GetMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, String command) throws Exception {
		
		response.setCharacterEncoding("UTF-8");
		if (command.equals("sido")) {
			System.out.println(command);
			PrintWriter out = response.getWriter();
			List<SidoCode> list = null;
			JSONArray arr = new JSONArray();
			try {
				list = service.selectSido();
				for (SidoCode dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("sido_code", dto.getSido_code());
					obj.put("sido_name", dto.getSido_name());
					arr.add(obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.print(arr.toJSONString());
				out.close();
			}
		} // sido
		else if (command.equals("gugun")) {
			System.out.println(command);
			String sido = request.getParameter("sido");
			PrintWriter out = response.getWriter();
			List<SidoCode> list = null;
			JSONArray arr = new JSONArray();
			try {
				list = service.selectGugun(sido);
				for (SidoCode dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("gugun_code", dto.getGugun_code());
					obj.put("gugun_name", dto.getGugun_name());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toJSONString());
				out.close();
			}
		} // gugun
		else if (command.equals("dong")) {
			System.out.println(command);
			String gugun = request.getParameter("gugun");
			PrintWriter out = response.getWriter();
			List<HouseInfo> list = null;
			JSONArray arr = new JSONArray();
			try {
				list = service.selectDong(gugun);
				for (HouseInfo dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("code", dto.getCode());
					obj.put("dong", dto.getDong());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toJSONString());
				out.close();
			}
		} // dong
		else if (command.equals("apt")) {
			System.out.println(command);
			String dong = request.getParameter("dong");
			PrintWriter out = response.getWriter();
			List<HouseInfo> list = null;
			JSONArray arr = new JSONArray();
			try {
				list = service.selectApt(dong);
				System.out.println(list.size());
				for (HouseInfo dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("no", dto.getNo());
					obj.put("dong", dto.getDong());
					obj.put("AptName", dto.getAptName());
					obj.put("code", dto.getCode());
					obj.put("jibun", dto.getJibun());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toJSONString());
				out.close();
			}
		} // dong
		return "index";
	}// 함수 끝

}
