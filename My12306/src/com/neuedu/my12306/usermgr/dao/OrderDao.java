package com.neuedu.my12306.usermgr.dao;

import java.util.List;

import com.neuedu.my12306.usermgr.domain.Order;
import com.neuedu.my12306.usermgr.domain.User;

public interface OrderDao {
	List<Order> getOrderList(User user, Order o)
			throws Exception;

	int save(Order o) throws Exception;

	Order findOrder(Order o) throws Exception;
//
//	boolean deleteOrder(int[] orderIdList) throws Exception;
//
//	boolean updateOrder(Order o) throws Exception;
	//
	// int getUserListRowCount(Order one) throws Exception;
	//
	// int getUserListPageCount(int pageSize, Order one) throws Exception;
	//
	//
	// List<Order> findDim(String key, Object obj) throws Exception;
}
