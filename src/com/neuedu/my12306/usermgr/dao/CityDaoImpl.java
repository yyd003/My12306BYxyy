package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.Province;

public class CityDaoImpl implements CityDao {
	private Connection conn;
    
	public CityDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<City> getCityListByProID(String s) {
		// TODO Auto-generated method stub
		
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    List cityList = new ArrayList<City>();
	    String sql = "select * from tab_city where father = " + s;
	    conn = DBUtils.getconnection();
	    try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				City c = new City();
				c.setId(rs.getInt("id"));
				c.setCityid(rs.getString("cityid"));
				c.setCity(rs.getString("city"));
				
				Province p = new Province();
				p.setProvinceid(rs.getString("father"));
				c.setFather(p);
				cityList.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("getCityListByProID error!");
		}finally{
			DBUtils.closeStatement(rs, pst);
	//		DBUtils.closeConnection(conn);
		}
		return cityList;
	}
	 
	
}
