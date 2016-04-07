package com.zq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zq.bena.Province;
import com.zq.dao.ProvinceDao;
import com.zq.utils.SqlHelper;

public class ProvinceDaoImpl implements ProvinceDao{

	@Override
	public List<Province> findAllProvince(){
		
		List<Province> list = new ArrayList<Province>();
		Connection ct =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		//加载驱动
		try{
			//获取连接，
			ct = SqlHelper.getConnection();
			//组织语句
			String sql = "SELECT pid,pname FROM province ORDER BY pid";
			//创建prea
			ps = ct.prepareStatement(sql);
			//执行sql
			rs = ps.executeQuery();
			
			//遍历结果
			while(rs.next()){
				//创建省的对象，添加到list中
				Province p = new Province();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			SqlHelper.closeResource(ct, ps, rs);
		}
		return list;
			
	}

}
