package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.Province;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.domain.UserType;

public class UserDaoImpl implements UserDao{	
	private Connection conn;
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean save(User u){
		// TODO Auto-generated method stub
		int i = 0;
		PreparedStatement pstmt = null;
//		String sql = "insert into tab_user value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql = "insert into tab_user(username,password,rule,realname,sex,city,cert_type,cert,birthday,user_type,content,status,login_ip,image_path) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getRule());
			pstmt.setString(4, u.getRealname());
			pstmt.setString(5, u.getSex());
			pstmt.setInt(6, u.getCity().getId());
			pstmt.setInt(7, u.getCert_type().getID());
			pstmt.setString(8, u.getCert());
			pstmt.setString(9, u.getBirthday());
			pstmt.setInt(10, u.getUser_type().getId());
			pstmt.setString(11, u.getContent());
			pstmt.setString(12, u.getStatus());
			pstmt.setString(13, u.getLogin_ip());
			pstmt.setString(14, u.getImage_path());
//System.out.println(pstmt);
			i = pstmt.executeUpdate();
			if(i != 0) 
				return true;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("save error!");
		} 
		return false;
	}
	
//	@Override   //myself
//	public User findUser(User u) {
//		// TODO Auto-generated method stub
//		StringBuffer sb = new StringBuffer();
//		sb.append("select u.*, ");
//		sb.append("c.id cid, c.cityid ccityid,c.city ccity,c.father cfather, ");
//		sb.append("e.ID eID, e.content econtent, ");
//		sb.append("s.id sid, s.content scontent, ");
//		sb.append("p.id pid, p.provinceid pprovinceid, p.province pprovince ");
//		sb.append("from tab_certtype e, tab_city c, tab_province p, tab_user u, tab_usertype s ");
//		sb.append("where where u.city = c.id and u.cert_type = e.id and u.user_type = s.id");
//		
//		boolean bl = false;
//		if(u.getId() != 0 && u.getId() != null)
//		{
//			sb.append(" and u.id = " + u.getId());
//			bl = true;
//		}
//		
//		String username = u.getUsername();
//		if(username != null && username.isEmpty() != true)
//		{
//			sb.append(" and u.username = '"+ username+"'");
//			bl = true;
//		}
//		
//		String password = u.getPassword();
//		if(password != null && password.isEmpty() != true)
//		{
//			sb.append(" and u.password = '"+ password+"'");
//			bl = true;
//		}
//		
//		String rule = u.getRule();
//		if(rule != null && rule.isEmpty() != true)
//		{
//			sb.append(" and u.rule = '"+ rule+"'");
//			bl = true;
//		}
//		
//		String realname = u.getRealname();
//		if(realname != null && realname.isEmpty() != true)
//		{
//			sb.append(" and u.realname like '% "+ realname +"%'");
//			bl = true;
//		}
//		
//		String sex = u.getSex();
//		if(sex != null && sex.isEmpty() != true)
//		{
//			sb.append(" and u.sex = '"+ sex+"'");
//			bl = true;
//		}
//		
//		String cert = u.getCert();
//		if(cert != null && cert.isEmpty() != true)
//		{
//			sb.append(" and u.cert = '"+ cert+"'");
//			bl = true;
//		}
//		
//		if(u.getCert_type() != null){
//			Integer i = u.getCert_type().getID();
//			if(i != 0 && i != null)
//			{
//				sb.append(" and u.cert_type = " + i);
//				bl = true;
//			}
//		}
//		
//		if(u.getCity() != null){
//			Integer n = u.getCity().getId();
//			if(n != 0 && n != null)
//			{
//				sb.append(" and u.city = " + n);
//				bl = true;
//			}
//		}
//		
////		Date d = u.getBirthday();
////		if(d != null)
////		{
////			sb.append(" and u.birthday = "+ d);
////			bl = true;
////		}
//		
//		
//		if(u.getUser_type() != null)
//		{
//			Integer t = u.getUser_type().getId();
//			if(t != null & t != 0)
//			sb.append(" and u.user_type = " + t);
//			bl = true;
//		}
//		
//		String content = u.getContent();
//		if(content != null && content.isEmpty() != true)
//		{
//			sb.append(" and u.content like '%"+ content+"%'");
//			bl = true;
//		}
//		
//		String status = u.getStatus();
//		if(status != null && status.isEmpty() != true)
//		{
//			sb.append(" and u.status = '"+ status+"'");
//			bl = true;
//		}
//		
//		String loginip = u.getLogin_ip();
//		if(loginip != null && loginip.isEmpty() != true)
//		{
//			sb.append(" and u.login_ip = '"+ loginip+"'");
//			bl = true;
//		}
//		
//		String image_path = u.getImage_path();
//		if(image_path != null && image_path.isEmpty() != true)
//		{
//			sb.append(" and u.image_path = '"+ image_path+"'");
//			bl = true;
//		}	
//		
//		if(!bl) return null;
//
//		PreparedStatement pst = null;
//        User user = null;
//        ResultSet rs = null;
//		try {
//			pst = conn.prepareStatement(sb.toString());
//			rs = pst.executeQuery();
//			if(rs.next()){
//				user = new User();
//				user.setId(rs.getInt("id"));
//				user.setUsername(rs.getString("username"));
//				user.setPassword(rs.getString("password"));
//				user.setRule(rs.getString("rule"));
//				user.setRealname(rs.getString("realname"));
//				user.setSex(rs.getString("sex"));
//				user.setCert(rs.getString("cert"));
//				user.setBirthday(rs.getDate("birthday"));
//				user.setContent(rs.getString("content"));
//				user.setStatus(rs.getString("status"));
//				user.setLogin_ip(rs.getString("login_ip"));
//				user.setImage_path(rs.getString("image_path"));
//				
//				Province province = new Province();
//				province.setId(rs.getInt("pid"));
//				province.setProvinceid(rs.getString("pprovince"));
//				province.setProvinceid(rs.getString("provinceid"));
//				
//				City city = new City();
//				city.setId(rs.getInt("cid"));
//				city.setCityid(rs.getString("ccityid"));
//				city.setCity(rs.getString("ccity"));
//				city.setFather(province);
//				user.setCity(city);
//				
//				CertType ct = new CertType();
//				ct.setID(rs.getInt("eID"));
//				ct.setContent(rs.getString("econtent"));
//				user.setCert_type(ct);
//				
//				UserType ut = new UserType();
//				ut.setId(rs.getInt("sid"));
//				ut.setContent(rs.getString("scontent"));
//				user.setUser_type(ut);		
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("findUser error!");
//		}finally{
//			DBUtils.closeStatement(rs, pst);
//		}
//		return user;
//	}
	@Override
	public User findUser(User one) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT u.*, ");
		find_sql.append("c.id cid, c.cityid ccityid, c.city ccity, c.father cfather, ");
		find_sql.append("p.id pid, p.provinceid pprovinceid, p.province pprovince, ");
		find_sql.append("t.id tid, t.content tcontent, ");
		find_sql.append("e.ID eID, e.content econtent ");
		find_sql.append("FROM tab_user  u, tab_city c, tab_province p, tab_usertype t, tab_certtype e ");
		find_sql.append("WHERE u.city = c.id AND c.father = p.provinceid AND u.user_type = t.id AND u.cert_type = e.id");

		// 查询条件标记
		boolean tag = false;
		// 查询条件id字段
		Integer id = one.getId();
		if (id != null && id != 0) {
			find_sql.append(" AND u.id=" + id);
			tag = true;
		}
		// 查询条件username字段
		String username = one.getUsername();
		if (username != null && !username.isEmpty()) {
			find_sql.append(" AND u.username='" + username+"'");
			tag = true;
		}
		// 查询条件password字段
		String password = one.getPassword();
		if (password != null && !password.isEmpty()) {
			find_sql.append(" AND u.password='" + password + "'");
			tag = true;
		}
		// 查询条件rule字段
		String rule = one.getRule();
		if (rule != null && !rule.isEmpty()) {
			find_sql.append(" AND u.rule='" + rule + "'");
			tag = true;
		}
		// 查询条件realname字段，模糊查询
		String realname = one.getRealname();
		if (realname != null && !realname.isEmpty()) {
			find_sql.append(" AND u.realname LIKE '%" + realname + "%'");
			tag = true;
		}
		// 查询条件sex字段
		String sex = one.getSex();
		if (sex != null && !sex.isEmpty()) {
			find_sql.append(" AND u.sex='" + sex + "'");
			tag = true;
		}
		// 查询条件city字段
		if (one.getCity() != null) {
			Integer city = one.getCity().getId();
			if (city != null && city != 0) {
				find_sql.append(" AND u.city=" + city);
				tag = true;
			}
		}
		// 查询条件cert_type字段
		if (one.getCert_type() != null) {
			Integer certtype = one.getCert_type().getID();
			if (certtype != null && certtype != 0) {
				find_sql.append(" AND u.cert_type=" + certtype);
				tag = true;
			}
		}
		// 查询条件cert字段
		String cert = one.getCert();
		if (cert != null && !cert.isEmpty()) {
			find_sql.append(" AND u.cert LIKE '%" + cert + "%'");
			tag = true;
		}
		// 查询条件user_type字段
		if (one.getUser_type() != null) {
			Integer usertype = one.getUser_type().getId();
			if (usertype != null && usertype != 0) {
				find_sql.append(" AND u.user_type=" + usertype);
				tag = true;
			}
		}
		// 查询条件content字段
		String content = one.getContent();
		if (content != null && !content.isEmpty()) {
			find_sql.append(" AND u.content LIKE '%" + content + "%'");
			tag = true;
		}
		// 查询条件status字段
		String status = one.getStatus();
		if (status != null && !status.isEmpty()) {
			find_sql.append(" AND u.status='" + status + "'");
			tag = true;
		}
		// 查询条件login_ip字段
		String ip = one.getLogin_ip();
		if (ip != null && !ip.isEmpty()) {
			find_sql.append(" AND u.login_ip='" + ip + "'");
			tag = true;
		}
		// 查询条件image_path字段
		String image = one.getImage_path();
		if (image != null && !image.isEmpty()) {
			find_sql.append(" AND u.image_path='" + image + "'");
			tag = true;
		}

		// 若没有查询条件则返回对象为null
		if (!tag) {
			return null;
		}

		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(find_sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 解析结果集对象，封装查询结果
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRule(rs.getString("rule"));
				user.setRealname(rs.getString("realname"));
				user.setSex(rs.getString("sex"));

				// city
				Province province = new Province();
				province.setId(rs.getInt("pid"));
				province.setProvince(rs.getString("pprovince"));
				province.setProvinceid(rs.getString("pprovinceid"));

				City city = new City();
				city.setId(rs.getInt("cid"));
				city.setCityid(rs.getString("ccityid"));
				city.setCity(rs.getString("ccity"));
				city.setFather(province);

				user.setCity(city);

				// CertType
				CertType certType = new CertType();
				certType.setID(rs.getInt("eID"));
				certType.setContent(rs.getString("econtent"));
				user.setCert_type(certType);

				user.setCert(rs.getString("cert"));
				user.setBirthday(rs.getString("birthday"));

				// UserType
				UserType userType = new UserType();
				userType.setId(rs.getInt("tid"));
				userType.setContent(rs.getString("tcontent"));
				user.setUser_type(userType);

				user.setContent(rs.getString("content"));
				user.setStatus(rs.getString("status"));
				user.setLogin_ip(rs.getString("login_ip"));
				user.setImage_path(rs.getString("image_path"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
				System.out.println("findUser error!");
		} finally {
//System.out.println(pstmt);
			DBUtils.closeStatement(rs, pstmt);
		}
		return user;
	}
	
	@Override
	public User login(String username, String password){
		// SQL语句
		StringBuffer buff = new StringBuffer();
		buff.append("SELECT u.*, ");
		buff.append("c.id cid, c.cityid ccityid, c.city ccity, c.father cfather, ");
		buff.append("p.id pid, p.provinceid pprovinceid, p.province pprovince, ");
		buff.append("t.id tid, t.content tcontent, ");
		buff.append("e.ID eid, e.content econtent ");
		buff.append("FROM tab_user  u, tab_city c, tab_province p, tab_usertype t, tab_certtype e ");
		buff.append("WHERE u.city = c.id AND c.father = p.provinceid AND u.user_type = t.id AND u.cert_type = e.ID ");
		buff.append("AND username=? AND password = ? ");
		String find_sql = buff.toString();

		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 设置语句对象，SQL语句条件
			pstmt = conn.prepareStatement(find_sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 解析结果集对象，封装查询结果
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRule(rs.getString("rule"));
				user.setRealname(rs.getString("realname"));
				user.setSex(rs.getString("sex"));

				// city
				Province province = new Province();
				province.setId(rs.getInt("pid"));
				province.setProvince(rs.getString("pprovince"));
				province.setProvinceid(rs.getString("pprovinceid"));

				City city = new City();
				city.setId(rs.getInt("cid"));
				city.setCityid(rs.getString("ccityid"));
				city.setCity(rs.getString("ccity"));
				city.setFather(province);

				user.setCity(city);

				// CertType
				CertType certType = new CertType();
				certType.setID(rs.getInt("eid"));
				certType.setContent(rs.getString("econtent"));
				user.setCert_type(certType);

				user.setCert(rs.getString("cert"));
				user.setBirthday(rs.getString("birthday"));

				// UserType
				UserType userType = new UserType();
				userType.setId(rs.getInt("tid"));
				userType.setContent(rs.getString("tcontent"));
				user.setUser_type(userType);

				user.setContent(rs.getString("content"));
				user.setStatus(rs.getString("status"));
				user.setLogin_ip(rs.getString("login_ip"));
				user.setImage_path(rs.getString("image_path"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			// System.out.println("udim:" + pstmt);
			DBUtils.closeStatement(rs, pstmt);
		}

		return user;
	}

	@Override
	public boolean deleteUsers(int[] userIdList) throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		String param = Arrays.toString(userIdList).replace("[", "(").replace("]", ")");
		PreparedStatement pstmt = null;
		String sql = "delete from tab_user where id in "+param;
		try {
			pstmt = conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			if(i != 0) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deleteUsers error!");
		} 
		return false;
	}

	@Override
	public boolean deleteUsersProcedure(int[] userIdList) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUserListRowCount(User u) throws Exception {
		// TODO Auto-generated method stub
		int rowCount = 0;
		// SQL语句
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ");
		find_sql.append("FROM tab_user  u, tab_city c, tab_province p, tab_usertype t, tab_certtype e ");
		find_sql.append("WHERE u.city = c.id AND c.father = p.provinceid AND u.user_type = t.id AND u.cert_type = e.ID");

		// 查询条件id字段
		Integer id = u.getId();
		if (id != null && id != 0) {
			find_sql.append(" AND u.id=" + id);
		}
		// 查询条件username字段
		String username = u.getUsername();
		if (username != null && !username.isEmpty()) {
			find_sql.append(" AND u.username='" + username + "'");
		}
		// 查询条件password字段
		String password = u.getPassword();
		if (password != null && !password.isEmpty()) {
			find_sql.append(" AND u.password='" + password + "'");
		}
		// 查询条件rule字段
		String rule = u.getRule();
		if (rule != null && !rule.isEmpty()) {
			find_sql.append(" AND u.rule='" + rule + "'");
		}
		// 查询条件realname字段，模糊查询
		String realname = u.getRealname();
		if (realname != null && !realname.isEmpty()) {
			find_sql.append(" AND u.realname LIKE '%" + realname + "%'");
		}
		// 查询条件sex字段
		String sex = u.getSex();
		if (sex != null && !sex.isEmpty()) {
			find_sql.append(" AND u.sex='" + sex + "'");
		}
		// 查询条件city字段
		if (u.getCity() != null) {
			Integer city = u.getCity().getId();
			if (city != null && city != 0) {
				find_sql.append(" AND u.city=" + city);
			}
		}
		// 查询条件cert_type字段
		if (u.getCert_type() != null) {
			Integer certtype = u.getCert_type().getID();
			if (certtype != null && certtype != 0) {
				find_sql.append(" AND u.cert_type=" + certtype);
			}
		}
		// 查询条件cert字段
		String cert = u.getCert();
		if (cert != null && !cert.isEmpty()) {
			find_sql.append(" AND u.cert LIKE '%" + cert + "%'");
		}
		// 查询条件user_type字段
		if (u.getCert_type() != null) {
			Integer usertype = u.getCert_type().getID();
			if (usertype != null && usertype != 0) {
				find_sql.append(" AND u.user_type=" + usertype);
			}
		}
		// 查询条件content字段
		String content = u.getContent();
		if (content != null && !content.isEmpty()) {
			find_sql.append(" AND u.content LIKE '%" + content + "%'");
		}
		// 查询条件status字段
		String status = u.getStatus();
		if (status != null && !status.isEmpty()) {
			find_sql.append(" AND u.status='" + status + "'");
		}
		// 查询条件login_ip字段
		String ip = u.getLogin_ip();
		if (ip != null && !ip.isEmpty()) {
			find_sql.append(" AND u.login_ip='" + ip + "'");
		}
		// 查询条件image_path字段
		String image = u.getImage_path();
		if (image != null && !image.isEmpty()) {
			find_sql.append(" AND u.image_path='" + image + "'");
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(find_sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 根据每页条数计算列表总页数
				rowCount = rs.getInt(1);
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}

		return rowCount;
	}

	@Override
	public int getUserListPageCount(int pageSize, User one) throws Exception {
			int res = 0;
			int rowCount = getUserListRowCount(one);
			if (rowCount % pageSize == 0) {
				res = rowCount / pageSize;
			} else {
				res = rowCount / pageSize + 1;
			}

			return res;
		}

	@Override
	public List<User> getUserList(int pageSize, int rowNum, User one)
			throws Exception {
		// TODO Auto-generated method stub
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT u.*, ");
		find_sql.append("c.id cid, c.cityid ccityid, c.city ccity, c.father cfather, ");
		find_sql.append("p.id pid, p.provinceid pprovinceid, p.province pprovince, ");
		find_sql.append("t.id tid, t.content tcontent, ");
		find_sql.append("e.ID eid, e.content econtent ");
		find_sql.append("FROM tab_user  u, tab_city c, tab_province p, tab_usertype t, tab_certtype e ");
		find_sql.append("WHERE u.city = c.id AND c.father = p.provinceid AND u.user_type = t.id AND u.cert_type = e.ID");

		// 查询条件id字段
		Integer id = one.getId();
		if (id != null && id != 0) {
			find_sql.append(" AND u.id=" + id);
		}
		// 查询条件username字段
		String username = one.getUsername();
		if (username != null && !username.isEmpty()) {
			find_sql.append(" AND u.username='" + username + "'");
		}
		// 查询条件password字段
		String password = one.getPassword();
		if (password != null && !password.isEmpty()) {
			find_sql.append(" AND u.password='" + password + "'");
		}
		// 查询条件rule字段
		String rule = one.getRule();
		if (rule != null && !rule.isEmpty()) {
			find_sql.append(" AND u.rule='" + rule + "'");
		}
		// 查询条件realname字段，模糊查询
		String realname = one.getRealname();
		if (realname != null && !realname.isEmpty()) {
			find_sql.append(" AND u.realname LIKE '%" + realname + "%'");
		}
		// 查询条件sex字段
		String sex = one.getSex();
		if (sex != null && !sex.isEmpty()) {
			find_sql.append(" AND u.sex='" + sex + "'");
		}
		// 查询条件city字段
		if (one.getCity() != null) {
			Integer city = one.getCity().getId();
			if (city != null && city != 0) {
				find_sql.append(" AND u.city=" + city);
			}
		}
		// 查询条件cert_type字段
		if (one.getCert_type() != null) {
			Integer certtype = one.getCert_type().getID();
			if (certtype != null && certtype != 0) {
				find_sql.append(" AND u.cert_type=" + certtype);
			}
		}
		// 查询条件cert字段
		String cert = one.getCert();
		if (cert != null && !cert.isEmpty()) {
			find_sql.append(" AND u.cert LIKE '%" + cert + "%'");
		}
		// 查询条件user_type字段
		if (one.getUser_type() != null) {
			Integer usertype = one.getUser_type().getId();
			if (usertype != null && usertype != 0) {
				find_sql.append(" AND u.user_type=" + usertype);
			}
		}
		// 查询条件content字段
		String content = one.getContent();
		if (content != null && !content.isEmpty()) {
			find_sql.append(" AND u.content LIKE '%" + content + "%'");
		}
		// 查询条件status字段
		String status = one.getStatus();
		if (status != null && !status.isEmpty()) {
			find_sql.append(" AND u.status='" + status + "'");
		}
		// 查询条件login_ip字段
		String ip = one.getLogin_ip();
		if (ip != null && !ip.isEmpty()) {
			find_sql.append(" AND u.login_ip='" + ip + "'");
		}
		// 查询条件image_path字段
		String image = one.getImage_path();
		if (image != null && !image.isEmpty()) {
			find_sql.append(" AND u.image_path='" + image + "'");
		}
		// 分页SQL语句,这里可能得重写，因为不是在oracle中，而是在mysql中
		// String sql = "select * from(select a1.*,rownum rn from ("
		// + find_sql.toString() + ") a1 where rownum<=" + rowNum
		// * pageSize + ")where rn>=" + ((rowNum - 1) * pageSize + 1);

		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			// pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(find_sql.toString());// 先查询全部
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 解析结果集对象，封装查询结果
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRule(rs.getString("rule"));
				user.setRealname(rs.getString("realname"));
				user.setSex(rs.getString("sex"));

				// city
				Province province = new Province();
				province.setId(rs.getInt("pid"));
				province.setProvince(rs.getString("pprovince"));
				province.setProvinceid(rs.getString("pprovinceid"));

				City city = new City();
				city.setId(rs.getInt("cid"));
				city.setCityid(rs.getString("ccityid"));
				city.setCity(rs.getString("ccity"));
				city.setFather(province);

				user.setCity(city);

				// CertType
				CertType certType = new CertType();
				certType.setID(rs.getInt("eid"));
				certType.setContent(rs.getString("econtent"));
				user.setCert_type(certType);

				user.setCert(rs.getString("cert"));
//				user.setBirthday(rs.getDate("birthday"));

				// UserType
				UserType userType = new UserType();
				userType.setId(rs.getInt("tid"));
				userType.setContent(rs.getString("tcontent"));
				user.setUser_type(userType);

				user.setContent(rs.getString("content"));
				user.setStatus(rs.getString("status"));
				user.setLogin_ip(rs.getString("login_ip"));
				user.setImage_path(rs.getString("image_path"));

				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return list;
	}

	@Override
	public List<User> getUserListRS(int pageSize, int pageNum, User one)
			throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int updateUser(User one) throws Exception {
		// TODO Auto-generated method stub
		// SQL语句
				StringBuffer update_sql = new StringBuffer("UPDATE tab_user set");
				// 查询条件标记
				boolean tag = false;
				int row = 0;
				// 查询条件id字段
				Integer id = one.getId();
				if (id == null || id == 0) {
					return 0;
				}
				// 查询条件username字段
				String username = one.getUsername();
				if (username != null && !username.isEmpty()) {
					update_sql.append(" username= '" + username + "'");
					tag = true;
				}
				// 查询条件password字段
				String password = one.getPassword();
				if (password != null && !password.isEmpty()) {
					update_sql.append(", password='" + password + "'");
					tag = true;
				}
				// 查询条件rule字段
				String rule = one.getRule();
				if (rule != null && !rule.isEmpty()) {
					update_sql.append(", rule='" + rule + "'");
					tag = true;
				}
				// 查询条件realname字段，模糊查询
				String realname = one.getRealname();
				if (realname != null && !realname.isEmpty()) {
					update_sql.append(", realname='" + realname+"'");
					tag = true;
				}
				// 查询条件sex字段
				String sex = one.getSex();
				if (sex != null && !sex.isEmpty()) {
					update_sql.append(", sex='" + sex+ "'");
					tag = true;
				}
				// 查询条件city字段
				if (one.getCity() != null) {
					Integer city = one.getCity().getId();
					if (city != null && city != 0) {
						update_sql.append(", city=" + city);
						tag = true;
					}
				}
				// 查询条件cert_type字段
				if (one.getCert_type() != null) {
					Integer certtype = one.getCert_type().getID();
					if (certtype != null && certtype != 0) {
						update_sql.append(", cert_type=" + certtype);
						tag = true;
					}
				}
				// 查询条件cert字段
				String cert = one.getCert();
				if (cert != null && !cert.isEmpty()) {
					update_sql.append(", cert='" + cert+ "'");
					tag = true;
				}
				// 查询条件user_type字段
				if (one.getUser_type() != null) {
					Integer usertype = one.getUser_type().getId();
					if (usertype != null && usertype != 0) {
						update_sql.append(", user_type=" + usertype);
						tag = true;
					}
				}
				// 查询条件content字段
				String content = one.getContent();
				if (content != null && !content.isEmpty()) {
					update_sql.append(", content='" + content+"'");
					tag = true;
				}
				// 查询条件status字段
				String status = one.getStatus();
				if (status != null && !status.isEmpty()) {
					update_sql.append(", status='" + status+ "'");
					tag = true;
				}
				// 查询条件login_ip字段
				String ip = one.getLogin_ip();
				if (ip != null && !ip.isEmpty()) {
					update_sql.append(", login_ip='" + ip);
					tag = true;
				}
				// 查询条件image_path字段
				String image = one.getImage_path();
				if (image != null && !image.isEmpty()) {
					update_sql.append(", image_path='" + image+ "'");
					tag = true;
				}

				update_sql.append(" where id=" + id);

				// 若没有查询条件则返回对象为null
				if (!tag) {
					return 0;
				}

				PreparedStatement pstmt = null;
				try {
					// 设置语句对象，SQL语句条件
					pstmt = conn.prepareStatement(update_sql.toString());
					row = pstmt.executeUpdate();

				}
				catch(Exception e){
					e.printStackTrace();
				}finally {
					 System.out.println("udi:updateuser:" + pstmt);
					DBUtils.closeStatement(null, pstmt);
				}
				return row;
			}		 
}
 


