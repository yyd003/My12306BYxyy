package com.neuedu.my12306.usermgr.test;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.service.CityService;

import org.junit.Assert;
import org.junit.Test;

public class TestCityServince {
	CityService cs = CityService.getInstance();
	@Test
	public void testGet(){
		Assert.assertTrue(cs.getCityListByProID("110000").size() == 1);
	}
//	public static void main(String args[])
//	{
//		CityService cs = CityService.getInstance();
//		List<City> cityList = new ArrayList<City>();
//		cityList = cs.getCityListByProID("130000");
//		for (City city : cityList) {
//			System.out.println(city);
//		}
//		
//	}

}
