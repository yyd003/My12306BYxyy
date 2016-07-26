package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.UserTypeDaoImpl;
import com.neuedu.my12306.usermgr.domain.UserType;

public class UserTypeServince {
	private static final UserTypeServince instance = new UserTypeServince();

	public static UserTypeServince getInstance() {
		return instance;
	}

	private UserTypeServince() {

	}
	
	public List<UserType> getUserType() {
		Connection conn = null;
		List<UserType> userTypeList = null;
		try {
			conn = DBUtils.getconnection();
			UserTypeDaoImpl ctdi = new UserTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			userTypeList = ctdi.getUserTypeList(); // 锟街久诧拷Dao锟斤拷锟斤拷锟铰讹拷
			DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollBack(conn);
			System.out.println("getUserType error!");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return userTypeList;
	}

}
