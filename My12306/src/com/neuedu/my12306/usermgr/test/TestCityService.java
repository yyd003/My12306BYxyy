package com.neuedu.my12306.usermgr.test;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.usermgr.service.CityService;

public class TestCityService {
	

	CityService cs = CityService.getInstance();
	
	@Test
	public void testgetCertTypeList() throws Exception
	{
		Assert.assertNotNull(cs.getCityList("130000"));
	}
}
