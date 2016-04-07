package com.zq.dao;

import java.util.List;

import com.zq.bena.County;

public interface CountyDao {

	public List<County> getCountyByCid(Integer cid);
}
