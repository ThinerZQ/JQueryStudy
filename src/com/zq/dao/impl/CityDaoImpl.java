package com.zq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zq.bena.City;
import com.zq.bena.Province;
import com.zq.dao.CityDao;
import com.zq.utils.SqlHelper;

public class CityDaoImpl implements CityDao {

	@Override
	public List<City> findCitiesByPid(Integer pid) {
		
		
		List<City> list = new ArrayList<City>();
		Connection ct =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		//��������
		try{
			//��ȡ���ӣ�
			ct = SqlHelper.getConnection();
			//��֯���
			String sql = "SELECT cid,cname FROM city where pid=? ORDER BY cid";
			
			System.out.println("111111111  "+pid);
			//����prea
			ps = ct.prepareStatement(sql);
			
			ps.setInt(1, pid);
			//ִ��sql
			rs = ps.executeQuery();
			
			//�������
			while(rs.next()){
				//����ʡ�Ķ�����ӵ�list��
				City c = new City();
				c.setCid(rs.getInt("cid"));
				c.setCname(rs.getString("cname"));
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


