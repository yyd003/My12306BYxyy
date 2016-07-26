package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.Province;

public class ProvinceDaoImpl implements ProvinceDao{


	private Connection conn;
	public ProvinceDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Province> getProvinceList() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Province> provinceList = new ArrayList<Province>();
		
		try{
			pstmt = conn.prepareStatement("select * from tab_province");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Province p = new Province();
				p.setId(rs.getInt("id"));
				p.setProvinceid(rs.getString("provinceid"));
				p.setProvince(rs.getString("province"));
				provinceList.add(p);
				
			}
		   }catch(Exception e){
				System.out.println("getProvinceList error!");
			}finally{
			DBUtils.closeStatement(rs, pstmt);
			
		}
		return provinceList;
	}
}
