package com.neuedu.my12306.usermgr.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.service.CertTypeService;

public class TestCertTypeServince {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		CertTypeService cts = CertTypeService.getInstance();
//		List<CertType> certTypeList = new ArrayList<CertType>();
//		certTypeList = cts.getCertType();
//		for (CertType certType : certTypeList) {
//			System.out.println(certType);
//		}
//		
//	}
	
	CertTypeService cts = CertTypeService.getInstance();
//	@Test
	public void testGet()
	{
		Assert.assertNotNull(cts.getCertType());
	}
//	@Test
	public void testAdd(){
		CertType ct = new CertType();
		ct.setID(5);
		ct.setContent("学生证");
		Assert.assertTrue(cts.addCertType(ct));
	}
	
//	@Test
	public void testDelete(){
		CertType ct = new CertType();
	//	ct.setID(5);
		ct.setContent("学生证");
		Assert.assertTrue(cts.deleteCertType(ct));
	}
	
//	@Test
	public void testFindJQ(){
		 
		Assert.assertNotNull(cts.findJQ("Content", "护照"));
	}
	
//	@Test
	public void testFindMH(){
		Assert.assertNotNull(cts.findMH("content", "证"));
	}
	
//	@Test
	public void testModify()
	{
		CertType ct = new CertType();
 		ct.setID(4);
	    ct.setContent("护照");
		Assert.assertTrue(cts.ModifyCertType(ct));
	}
}
