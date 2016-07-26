package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.ProvinceDaoImpl;
import com.neuedu.my12306.usermgr.domain.Province;

public class ProvinceService {
	private static final ProvinceService instance = new ProvinceService();

	public static ProvinceService getInstance() {
		return instance;
	}

	private ProvinceService() {

	}
	
	public List<Province> getProvinceList(){
		List<Province> provinceList = new ArrayList<Province>();
		Connection conn = null;
		 try{
		 conn = DBUtils.getconnection();
		 ProvinceDaoImpl pdi = new ProvinceDaoImpl(conn);
		 DBUtils.beginTransaction(conn);
		 provinceList = pdi.getProvinceList();
		 DBUtils.commit(conn);
		 }catch(Exception e){
			 DBUtils.rollBack(conn); 
			 System.out.println("getProvinceList error!");
		 }finally{
			 DBUtils.closeConnection(conn);		
		}	 
		 return provinceList;
		 
	 }


}
