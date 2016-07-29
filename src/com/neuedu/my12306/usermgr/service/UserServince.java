package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.common.ServiceException;
import com.neuedu.my12306.usermgr.dao.UserDao;
import com.neuedu.my12306.usermgr.dao.UserDaoImpl;
import com.neuedu.my12306.usermgr.domain.User;

public class UserServince {
	private static final UserServince instance = new UserServince();

	public static UserServince getInstance() {
		return instance;
	}
	
	public User findUser(User u) {
		User user = null;
		Connection conn = null;
		try{
		conn = DBUtils.getconnection();
		UserDaoImpl udi = new UserDaoImpl(conn);
		DBUtils.beginTransaction(conn);
		user = udi.findUser(u);
		DBUtils.commit(conn);
		}catch(Exception e){
			DBUtils.rollBack(conn);
			System.out.println("findUser in UserServince error!");
		}finally{
			DBUtils.closeConnection(conn);
		}
		return user;
		
	}	
	public boolean save(User u){
		boolean s = false;
		Connection conn = null;
		int i = 0;
		 try{
		 conn = DBUtils.getconnection();
		 UserDaoImpl udi = new UserDaoImpl(conn);
		 DBUtils.beginTransaction(conn);
		  s = udi.save(u);
		 DBUtils.commit(conn);
		 }catch(Exception e){
			 DBUtils.rollBack(conn); 
			 System.out.println("save error!");
		 }finally{
			 DBUtils.closeConnection(conn);		
		}
		 return s;	 
	 }
	public boolean deleteUsers(int[] userIdList) throws Exception {
		boolean s = false;
		Connection conn = null;
		int i = 0;
		 try{
		 conn = DBUtils.getconnection();
		 UserDaoImpl udi = new UserDaoImpl(conn);
		 DBUtils.beginTransaction(conn);
		  s = udi.deleteUsers(userIdList);
		 DBUtils.commit(conn);
		 }catch(Exception e){
			 DBUtils.rollBack(conn); 
			 System.out.println("deleteUsers error!");
		 }finally{
			 DBUtils.closeConnection(conn);		
		}
		 return s;	
	}
	
	public User login(String username, String password){
		User u = null;
		Connection conn = null;
		int i = 0;
		 try{
		 conn = DBUtils.getconnection();
		 UserDaoImpl udi = new UserDaoImpl(conn);
		 DBUtils.beginTransaction(conn);
		 u = udi.login(username, password);
		 DBUtils.commit(conn);
		 }catch(Exception e){
			 DBUtils.rollBack(conn); 
			 System.out.println("save error!");
		 }finally{
			 DBUtils.closeConnection(conn);		
		}	 
		return u;
	}
	
	public int getUserListRowCount(User one) throws Exception {
		Connection conn = null;
		int res = 0;
		try {
			conn = DBUtils.getconnection();
			UserDaoImpl userDaoImpl = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res = userDaoImpl.getUserListRowCount(one);
			DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollBack(conn);
			System.out.println("getUserListRowCount error!");
		} finally {
			DBUtils.closeConnection(conn);
		}

		return res;
	}

	/**
	 * 获取用户列表最大页数
	 * 
	 * @param pageSize
	 *            ，每页显示信息条数
	 * @return 列表最大页数
	 * @throws Exception 
	 * @throws SQLException
	 */
	public int getUserListPageCount(int pageSize, User one) throws Exception {
		Connection conn = null;
		int res = 0;
		try {
			conn = DBUtils.getconnection();
			UserDaoImpl userDao = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res = userDao.getUserListPageCount(pageSize, one);
			DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollBack(conn);
			System.out.println("getUserListPageCount error!");
		} finally {
			DBUtils.closeConnection(conn);
		}

		return res;
	}

	/**
	 * 获取指定页用户信息列表，通过分页SQL语句实现
	 * 
	 * @param pageSize
	 *            ，每页显示信息条数
	 * @param rowNum
	 *            ，需要获取的页数
	 * @param one
	 *            ，需要获取的页数
	 * @return 用户信息列表，List[User]，若无满足条件则列表为空
	 * @throws SQLException
	 */
	public List<User> getUserList(int pageSize, int rowNum, User one) {
		Connection conn = null;
		List<User> res = null;
		try {
			conn = DBUtils.getconnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res = userDao.getUserList(pageSize, rowNum, one);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("getUserList error!");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return res;
	}
	
	public int updateUser(User one) throws Exception {
		Connection conn = null;
		int res = 0;
		try {
			conn = DBUtils.getconnection();
			UserDaoImpl userDaoImpl = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res = userDaoImpl.updateUser(one);
			DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollBack(conn);
			System.out.println("updateUser error!");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return res;
	}
}

