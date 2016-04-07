package com.zq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zq.bena.County;
import com.zq.dao.CountyDao;
import com.zq.utils.SqlHelper;

public class CountyDaoImpl implements CountyDao {

	@Override
	public List<County> getCountyByCid(Integer cid) {
		List<County> list = new ArrayList<County>();
		Connection ct =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		//加载驱动
		try{
			//获取连接，
			ct = SqlHelper.getConnection();
			//组织语句
			String sql = "SELECT tid,tname FROM county where cid=? ORDER BY tid";
			
			System.out.println("2222222  "+cid);
			//创建prea
			ps = ct.prepareStatement(sql);
			
			ps.setInt(1, cid);
			//执行sql
			rs = ps.executeQuery();
			
			//遍历结果
			while(rs.next()){
				//创建省的对象，添加到list中
				County c = new County();
				c.setTid(rs.getInt("tid"));
				c.setTname(rs.getString("tname"));
				list.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			SqlHelper.closeResource(ct, ps, rs);
		}
		return list;
			
	}
	}


