package com.neuedu.my12306.usermgr.dao;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.usermgr.domain.City;

public interface CityDao {
	 List<City> getCityListByProID(String s);
}
