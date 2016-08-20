package com.neuedu.my12306.usermgr.dao;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.usermgr.domain.Order;
import com.neuedu.my12306.usermgr.domain.OrderDetails;

public interface OrderDetailsDao {
	List<OrderDetails> getOrderDetailsByOrderId(int id)throws SQLException ;

	int save(OrderDetails o) throws Exception;
	
	boolean deleteOrderDetails(int[] orderDetailIdList) throws Exception;
}
