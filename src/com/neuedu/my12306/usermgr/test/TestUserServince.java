package com.neuedu.my12306.usermgr.test;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.common.Md5Utils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.domain.UserType;
import com.neuedu.my12306.usermgr.service.UserServince;

public class TestUserServince {
    UserServince us = UserServince.getInstance();
    
	//@Test
	public void testSave()
	{
		User u = new User();
	//	u.setId(5);
		u.setUsername("ad");
		u.setPassword(Md5Utils.md5("123456"));
		u.setRule("1");
		u.setRealname("许");
		u.setSex("2");
		
		City c = new City();
		c.setId(2);
		u.setCity(c);
		
		CertType ct = new CertType();
		ct.setID(3);
		u.setCert_type(ct);
		
		u.setCert("340881199205132527");
		
//		Calendar c1 = Calendar.getInstance();
//		c1.set(Calendar.YEAR, 1989);
//		c1.set(Calendar.MONTH, 2);
//		c1.set(Calendar.DATE, 12);
//		u.setBirthday(c1.getTime());
		u.setBirthday("1993-5-13");
		
		UserType ut = new UserType();
		ut.setId(1);
		u.setUser_type(ut);
		
		u.setContent("非法");	
		u.setStatus("3");	
		u.setLogin_ip(null);	
		u.setImage_path(null);
		Assert.assertTrue(us.save(u));	
	}
	
	//@Test
	public void testFinduser()
	{
		User u = new User();
//		u.setId(5);
		u.setUsername("xu");
		u.setPassword(Md5Utils.md5("123456"));
		u.setRule("1");
		u.setRealname("许");
		u.setSex("2");
//		
//		City c = new City();
//		c.setId(2);
//		u.setCity(c);
//		
//		CertType ct = new CertType();
//		ct.setID(3);
//		u.setCert_type(ct);
//		
//		u.setCert("340881199205132527");
//		
////		Date d = new Date();
////		u.setBirthday(d);
//		
//		UserType ut = new UserType();
//		ut.setId(1);
//		u.setUser_type(ut);
//		
//		u.setContent("非法");	
//		u.setStatus("2");	
//		u.setLogin_ip(null);	
//		u.setImage_path(null);
//		Assert.assertNotNull(us.findUser(u));	
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		UserServince us = UserServince.getInstance();
//		
//		User u = new User();
//		u.setUsername("abcabc");
//		User s = new User();
//		s = us.findUser(u);
//		System.out.println(s);
//		
//	}
	//@Test
	public void testDeleteUsers() throws Exception{
		int a[] = {12,13,14};
		Assert.assertTrue(us.deleteUsers(a));
	}
	
	//@Test
	public void testLogin(){
		Assert.assertNotNull(us.login("admin", Md5Utils.md5("123456")));
	}
	
	// 测试获取用户列表最大行数
		// @Test
		public void TestGetUserListRowCount() throws Exception {
			User u = new User();// 什么都不填充，意味着所有用户
			System.out.println("表中总共有记录数：" + us.getUserListRowCount(u));
		}

		// 获取用户列表最大页数
	 //  @Test
		public void TestGetUserListPageCount() throws Exception {
			User u = new User();// 什么都不填充，意味着所有用户
			int page = 5;
			String info = "满足条件的记录数共有" + us.getUserListRowCount(u) + "条"
					+ "\n";
			info += "若按每页显示" + page + "条计算，则总共有"
					+ us.getUserListPageCount(page, u) + "页";
			System.out.println(info);
		}
		
		// 测试得到用户列表，若无用户限制，则为findALl
	//	@Test
		public void testGetUserList() {
			// Assert.assertNotNull(service.getUserList(0, 0, new User()));
			// Assert.assertEquals(3, service.getUserList(10, 1, new
			// User()).size());
			for (User u : us.getUserList(10, 1, new User())) {
				System.out.println(u.getRealname());
			}
		}
		
		@Test
		public void testUpdateUser() throws Exception{
			User one = new User();
			one.setId(1);
			one.setUsername("xuyangyang");
			Assert.assertTrue(us.updateUser(one) == 1);
		}
}
