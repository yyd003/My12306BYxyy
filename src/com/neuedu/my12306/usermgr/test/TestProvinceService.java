package com.neuedu.my12306.usermgr.test;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.usermgr.service.ProvinceService;

public class TestProvinceService {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//	}
	ProvinceService ps = ProvinceService.getInstance();
		@Test
		public void testGet()
		{
			Assert.assertNotNull(ps.getProvinceList());
		}

}
