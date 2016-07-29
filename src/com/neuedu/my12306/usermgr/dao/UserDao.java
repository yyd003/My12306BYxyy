package com.neuedu.my12306.usermgr.dao;

import java.util.List;

import com.neuedu.my12306.usermgr.domain.User;

public interface UserDao {
	boolean save(User u); //增
	boolean deleteUsers(int[] userIdList) throws Exception; //删
	boolean deleteUsersProcedure(int[] userIdList) throws Exception;//删
    User findUser(User u);  //查
    User login(String username, String password) throws Exception; //持用户名和密码登录
    int getUserListRowCount(User u) throws Exception; //获取用户列表最大行数
    int getUserListPageCount(int pageSize, User one) throws Exception; //获取用户列表最大页数
    List<User> getUserList(int pageSize, int rowNum, User one)
			throws Exception;  //获取指定页用户信息列表，通过分页SQL语句实现
    List<User> getUserListRS(int pageSize, int pageNum, User one)
			throws Exception;   //获取指定页用户信息列表，通过分析结果集ResultSet对象实现
    int updateUser(User one) throws Exception;  //更新用户信息
	//List<IpAddress> getIpList() throws Exception;
}
