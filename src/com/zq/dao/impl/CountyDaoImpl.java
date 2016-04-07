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
		//��������
		try{
			//��ȡ���ӣ�
			ct = SqlHelper.getConnection();
			//��֯���
			String sql = "SELECT tid,tname FROM county where cid=? ORDER BY tid";
			
			System.out.println("2222222  "+cid);
			//����prea
			ps = ct.prepareStatement(sql);
			
			ps.setInt(1, cid);
			//ִ��sql
			rs = ps.executeQuery();
			
			//�������
			while(rs.next()){
				//����ʡ�Ķ�����ӵ�list��
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


