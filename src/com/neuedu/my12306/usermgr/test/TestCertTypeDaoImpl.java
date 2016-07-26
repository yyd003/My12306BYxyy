package com.neuedu.my12306.usermgr.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CertTypeDaoImpl;
import com.neuedu.my12306.usermgr.domain.CertType;


public class TestCertTypeDaoImpl {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		CertTypeDaoImpl a = new CertTypeDaoImpl(DBUtils.getconnection());
		List<CertType> list = new ArrayList<CertType>();
		list = a.getCertType();
//		for (CertType certType : list) {
//			System.out.println(certType);
//		}
		
		CertType ct = new CertType();
	//	ct.setID(5);
		ct.setContent("ѧ��֤");
		a.addCertType(ct);
		
		list = a.getCertType();
//		for (CertType certType : list) {
//			System.out.println(certType);
//		}
		
		a.deleteCertType(ct);
		list = a.getCertType();
//		for (CertType certType : list) {
//			System.out.println(certType);
//		}
		
		list = a.findMH("content", "证");
		for (CertType certType : list) {
			System.out.println(certType);
		}
	}
	
	
	
}
