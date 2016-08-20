package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.Order;
import com.neuedu.my12306.usermgr.domain.OrderDetails;
import com.neuedu.my12306.usermgr.domain.Train;
import com.neuedu.my12306.usermgr.domain.User;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
	private Connection conn;

	public OrderDetailsDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<OrderDetails> getOrderDetailsByOrderId(int id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String find_sql = "select od.*, t.train_number ttrain_number, t.price tprice, u.realname urealname from tab_orderdetail od,tab_train t, tab_user u, tab_order o where od.orderid = o.id AND od.trainid = t.id AND u.id = od.userid AND od.orderid = " + id;
		ResultSet rs = null;
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
		try {
			pstmt = conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDetails one = new OrderDetails();
				one.setId(rs.getInt("id"));
				
				Order o = new Order();
				o.setId(rs.getInt("orderid"));
				one.setOrderid(o);
				
				Train t = new Train();
				t.setId(rs.getInt("trainid"));
				t.setTrain_number(rs.getString("ttrain_number"));
				t.setPrice(rs.getDouble("tprice"));
				one.setTrainid(t);
				
				User u = new User();
				u.setId(rs.getInt("userid"));
				u.setRealname(rs.getString("urealname"));
				one.setUserid(u);
				
				orderDetails.add(one);
			}
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}
		return orderDetails;
	}
	@Override
	public int save(OrderDetails o) throws Exception {
		int i = 0, idx = 1;
		String insert_sql = "insert into tab_orderdetail(orderid,trainid,userid) " + "values(?,?,?)";
		// String insert_sql = "insert into tab_user(username,password) " +
		// "values(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setInt(idx++, o.getOrderid().getId());
			pstmt.setInt(idx++, o.getTrainid().getId());
			pstmt.setInt(idx++, o.getUserid().getId());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt, null);
		}
		return i;
	}
	@Override
	public boolean deleteOrderDetails(int[] orderDetailIdList) throws Exception{
		int i = 0;
		String param = Arrays.toString(orderDetailIdList).replace("[", "(")
				.replace("]", ")");
		String insert_sql = "delete from tab_orderdetail where id in " + param;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(insert_sql);
			i = pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(pstmt, null);
		}
		return i != 0 ? true : false;
	}
}
