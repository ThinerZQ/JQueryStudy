package com.zq.dao;

import java.util.List;

import com.zq.bena.City;

public interface CityDao {

	public List<City> findCitiesByPid(Integer pid);
}
