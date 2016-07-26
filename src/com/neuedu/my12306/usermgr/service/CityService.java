package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CityDaoImpl;
import com.neuedu.my12306.usermgr.domain.City;

public class CityService {
	private static final CityService instance = new CityService();

	public static CityService getInstance() {
		return instance;
	}

	private CityService() {

	}
	public List<City> getCityListByProID(String s){
		 List cityList = new ArrayList<City>();
		 Connection conn = null;
		 try{
		 conn = DBUtils.getconnection();
		 CityDaoImpl cdi = new CityDaoImpl(conn);
		 DBUtils.beginTransaction(conn);
		 cityList = cdi.getCityListByProID(s);
		 DBUtils.commit(conn);
		 }catch(Exception e){
			 DBUtils.rollBack(conn); 
			 System.out.println("getCityListByProID error!");
		 }finally{
			 DBUtils.closeConnection(conn);		
		}	 
		 return cityList;
		 
		 }

}
