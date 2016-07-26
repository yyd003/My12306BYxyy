package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.UserType;

public class UserTypeDaoImpl implements UserTypeDao {
    private Connection conn;

	
	public UserTypeDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<UserType> getUserTypeList() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserType> userTypeList = new ArrayList<UserType>();
		
		try{
			pstmt = conn.prepareStatement("select * from tab_usertype");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				UserType ct = new UserType();
				ct.setId(rs.getInt("id"));
				ct.setContent(rs.getString("content"));
				userTypeList.add(ct);			
			}
			
		}finally{
//			rs.close();
//			pstmt.close();
			
//		    DBUtils.closeConnection(conn);
			DBUtils.closeStatement(rs, pstmt);
			
		}
		return userTypeList;	
	}
	

}
