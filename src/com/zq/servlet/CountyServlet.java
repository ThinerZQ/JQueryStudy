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

import com.zq.bena.City;
import com.zq.bena.County;
import com.zq.bena.Province;
import com.zq.dao.CityDao;
import com.zq.dao.CountyDao;
import com.zq.dao.ProvinceDao;
import com.zq.dao.impl.CityDaoImpl;
import com.zq.dao.impl.CountyDaoImpl;
import com.zq.dao.impl.ProvinceDaoImpl;
import com.zq.utils.SqlHelper;

public class CountyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		
		
		String scid=req.getParameter("cid");
		System.out.println("cid      "+scid);
		
		Integer cid =0;
		if(scid!=null && !"".equals(scid.trim())){
			cid = Integer.parseInt(scid);
		}
		
		CountyDao countyDao = new CountyDaoImpl();
		List<County> list = countyDao.getCountyByCid(cid);
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		//Êä³öµ½Ò³Ãæ
		out.println(jsonArray.toString());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

	
}
