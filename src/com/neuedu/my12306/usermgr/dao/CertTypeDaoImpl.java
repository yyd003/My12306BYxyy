package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.CertType;

public class CertTypeDaoImpl implements CertTypeDao {
	private Connection conn;

	
	public CertTypeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public List<CertType> getCertType() throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CertType> certTypeList = new ArrayList<CertType>();
		
		try{
			pstmt = conn.prepareStatement("select * from tab_certtype");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				CertType ct = new CertType();
				ct.setID(rs.getInt("ID"));
				ct.setContent(rs.getString("content"));
				certTypeList.add(ct);
				
			}
			
		}finally{
//			rs.close();
//			pstmt.close();
			
//		    DBUtils.closeConnection(conn);
			DBUtils.closeStatement(rs, pstmt);
			
		}
		return certTypeList;	
	}
    
	//����
	@Override
	public boolean addCertType(CertType ct) {
		// TODO Auto-generated method stub
		int i = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into tab_certtype(content) value(?)";
		try {
			pstmt = conn.prepareStatement(sql);
		//	pstmt.setInt(1, ct.getID());
			pstmt.setString(1,ct.getContent());
			i = pstmt.executeUpdate();
			if(i != 0) return true;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("addCertType error!");
		} 
		return false;
		 
	}

	
	//ɾ��
	@Override
	public boolean deleteCertType(CertType ct) {
		int i = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from tab_certtype where content=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ct.getContent());
			i = pstmt.executeUpdate();
			if(i != 0) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("delete error!");
		} 
		return false;		 
	}
	
    //���ң���ȷ���� + ģ�����
	@Override
	public CertType findJQ(String s, Object o) {
		CertType ct = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "select * from tab_certtype where "+s+"=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,o);
			rs = pstmt.executeQuery();
			if(rs.next()){
			   ct = new CertType();
			   ct.setID(rs.getInt("ID"));
			   ct.setContent(rs.getString("content"));
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("findJQ error!");
		}finally{
			DBUtils.closeStatement(rs, pstmt);
		//	DBUtils.closeConnection(conn);
		} 
		return ct;
	}

	@Override
	public List<CertType> findMH(String s, Object o) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CertType> certTypeList = new ArrayList<CertType>();
		String sql = "select * from tab_certtype where "+ s +" like '%"+o+"%'";
		try{
			conn = DBUtils.getconnection();
			pstmt = conn.prepareStatement(sql);
		//	pstmt.setObject(1, "'%" + o + "%'");
			rs = pstmt.executeQuery();
			while(rs.next()){
			   CertType ct = new CertType();
			   ct.setID(rs.getInt("ID"));
			   ct.setContent(rs.getString("content"));	
			   certTypeList.add(ct);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("findMH error!");
		}finally{		
//		    DBUtils.closeConnection(conn);
			DBUtils.closeStatement(rs, pstmt);
			
		}
		return certTypeList;	
	}

	@Override
	public boolean ModifyCertType(CertType ct) {
		// TODO Auto-generated method stub
		int i = 0;
		PreparedStatement pstmt = null;
		String sql = "update tab_certtype set content=? where ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ct.getContent());
			pstmt.setInt(2, ct.getID());
			i = pstmt.executeUpdate();
			if(i != 0) return true;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modify error!");
		} 
		return false;
	}
	
	
	
	
	
	
	
}
