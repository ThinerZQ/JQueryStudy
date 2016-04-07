package com.zq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.zq.bena.Province;
import com.zq.dao.ProvinceDao;
import com.zq.dao.impl.ProvinceDaoImpl;
import com.zq.utils.SqlHelper;

public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		
		ProvinceDao provinceDao = new ProvinceDaoImpl();
		List<Province> list = provinceDao.findAllProvince();
		//转化为json格式
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		//输出到页面
		out.println(jsonArray.toString());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

	
}
