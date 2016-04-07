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
		//��������
		try{
			//��ȡ���ӣ�
			ct = SqlHelper.getConnection();
			//��֯���
			String sql = "SELECT pid,pname FROM province ORDER BY pid";
			//����prea
			ps = ct.prepareStatement(sql);
			//ִ��sql
			rs = ps.executeQuery();
			
			//�������
			while(rs.next()){
				//����ʡ�Ķ�����ӵ�list��
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
