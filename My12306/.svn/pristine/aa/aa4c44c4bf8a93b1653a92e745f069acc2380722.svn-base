package com.neuedu.my12306.usermgr.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.usermgr.domain.Order;
import com.neuedu.my12306.usermgr.domain.OrderDetails;
import com.neuedu.my12306.usermgr.domain.Train;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.service.OrderDetailsService;

public class OrderDetailsServicetest {
	OrderDetailsService ods = OrderDetailsService.getInstance();

	// @Test
	// public void testGetOrderDetails() throws SQLException{
	// // Assert.assertTrue(ods.getOrderDetailsByOrderId(1).size() == 3);
	// Assert.assertNotNull(ods.getOrderDetailsByOrderId(1));
	// System.out.println(ods.getOrderDetailsByOrderId(1).size());
	// }

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		OrderDetailsService ods = OrderDetailsService.getInstance();
		List<OrderDetails> od = ods.getOrderDetailsByOrderId(11);
		for (OrderDetails orderDetails : od) {
			System.out.println(orderDetails.getUserid().getId());
		}
	}

	// @Test
	public void testSave() throws Exception {
		OrderDetails od = new OrderDetails();
		User u = new User();
		u.setId(1);
		Train t = new Train();
		t.setId(1);
		Order o = new Order();
		o.setId(1);
		od.setOrderid(o);
		od.setTrainid(t);
		od.setUserid(u);
		Assert.assertTrue(ods.save(od));
	}
	 @Test
		public void testdelete() throws Exception {
			int[] list = {25, 26};
			Assert.assertNotNull(ods.deleteOrderDetails(list));
		}
}
