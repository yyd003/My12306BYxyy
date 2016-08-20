package com.neuedu.my12306.usermgr.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.usermgr.domain.Order;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.service.OrderService;

public class TestOrderService {

	OrderService os = OrderService.getInstance();

//	 @Test
	public void testgetOrderList() throws Exception {
		Order o = new Order();
		o.setStatus(1);
		User u = new User();
		u.setId(7);
		List<Order> list = os.getOrderList(u, o);
		Assert.assertNotNull(list);
//		System.out.println(list);
		System.out.println(list.size());
	}
	 
//	 @Test
	public void testsave() throws Exception {
		Order o = new Order();
		User u = new User();
		u.setId(7);
		o.setUserid(u);
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		o.setOrder_date(d.toString());
		o.setTickets(1);
		o.setTotalmoney(50);
		o.setStatus(2);
		Assert.assertTrue(os.save(o));
	}
	
	 @Test
		public void testFindOrder() throws Exception {
			Order o = new Order();
			User u = new User();
			u.setId(7);
			o.setUserid(u);
			o.setOrder_date("2016-8-1 12:45:47");
			o.setTotalmoney(150);
			o.setTickets(1);
			o.setStatus(1);
			Assert.assertNotNull(os.findOrder(o));
		}
}
