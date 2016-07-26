package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CertTypeDaoImpl;
import com.neuedu.my12306.usermgr.domain.CertType;

public class CertTypeService {

	// 锟斤拷锟斤拷模式
	private static final CertTypeService instance = new CertTypeService();

	public static CertTypeService getInstance() {
		return instance;
	}

	private CertTypeService() {

	}

	public List<CertType> getCertType() {
		Connection conn = null;
		List<CertType> certTypeList = null;
		try {
			conn = DBUtils.getconnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			certTypeList = ctdi.getCertType(); // 锟街久诧拷Dao锟斤拷锟斤拷锟铰讹拷
			DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollBack(conn);
			System.out.println("锟斤拷询锟斤拷锟斤拷");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return certTypeList;
	}

	public boolean addCertType(CertType ct) {
		// TODO Auto-generated method stub
		Connection conn = null;
		boolean bl = false;

		try {
			conn = DBUtils.getconnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			bl = ctdi.addCertType(ct); // 锟街久诧拷Dao锟斤拷锟斤拷锟铰讹拷
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("addCertType error!");
			// TODO: handle exception
		} finally {
			DBUtils.closeConnection(conn);
		}

		return bl;
	}
	
	public boolean deleteCertType(CertType ct){
        Connection conn = null;
        boolean bl = false;
		try {
			conn = DBUtils.getconnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			bl = ctdi.deleteCertType(ct); // 锟街久诧拷Dao锟斤拷锟斤拷锟铰讹拷
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("deleteCertType error");
			// TODO: handle exception
		} finally {
			DBUtils.closeConnection(conn);
		}
		return bl;
	}
	
	public CertType findJQ(String s, Object o) {
		Connection conn = null;
		CertType ct = null;
		try {
			conn = DBUtils.getconnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.findJQ(s, o); // 锟街久诧拷Dao锟斤拷锟斤拷锟铰讹拷
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("锟斤拷询锟斤拷锟斤拷");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return ct;
	}
	public boolean ModifyCertType(CertType ct){
		Connection conn = null;
        boolean bl = false;
		try {
			conn = DBUtils.getconnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			bl = ctdi.ModifyCertType(ct); // 锟街久诧拷Dao锟斤拷锟斤拷锟铰讹拷
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("ModifyCertType error!");
			// TODO: handle exception
		} finally {
			DBUtils.closeConnection(conn);
		}
		return bl;
	}
	
	public List<CertType> findMH(String s, Object o){
		Connection conn = null;
		List<CertType> certTypeList = null;
		try {
			conn = DBUtils.getconnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			certTypeList = ctdi.findMH(s, o); // 
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("锟斤拷询锟斤拷锟斤拷");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return certTypeList;
	}
}
