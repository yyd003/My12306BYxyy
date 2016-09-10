package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.neuedu.my12306.common.Md5Utils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.domain.UserType;
import com.neuedu.my12306.usermgr.service.UserServince;
import com.neuedu.my12306.usermgr.service.UserTypeServince;

/**
 * Servlet implementation class AdminServlet
 */
//@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if ("show".equals(action)) {
			try {
				doShow(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("add".equals(action)) {
//			System.out.println("add");
			try {
				doAdd(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		
		if ("del".equals(action)) {
		 
			try {
				doDel(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		if("findAndPush".equals(action)){
			try {
				doFindAndPush(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		
		if("update".equals(action)){
			try {
				doUpdate(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

	}
	
	private void doShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 根据页面要求的页数，每页的记录数，生成数据，然后传到页面
		UserServince us = UserServince.getInstance();
		String strPageSize = request.getParameter("pageSize");
		String strPageNum = request.getParameter("page");
		int pageSize = 10, pageNum = 1;
		if (strPageSize != null) {
			pageSize = Integer.parseInt(strPageSize);
		}
		if (strPageNum != null) {
			pageNum = Integer.parseInt(strPageNum);
		}
		List<User> userList = us.getUserList(pageSize, pageNum, new User());

		// 包装成json数据
		JSONObject data = new JSONObject();
		String msg;
		if (userList != null) {
			data.put("users", userList);
		} else {
			data.put("users", null);
		}
		request.setAttribute("data", data);// request范围
//		System.out.println(request.getContextPath());
////		request.getRequestDispatcher("/Admin/newIndex.jsp")
////				.forward(request, response);
//		response.sendRedirect("Admin/newIndex.jsp");
		request.getRequestDispatcher("/Admin/newIndex.jsp")
		.forward(request, response);
	}
	
	//管理员增加用户
		protected void doAdd(HttpServletRequest request,HttpServletResponse response) throws IOException, Exception{
			User user = new User();
			populateuser(request,user);
			user.setStatus("1");
			user.setPassword(Md5Utils.md5("123456"));
			JSONObject jsonData = new JSONObject();
			UserServince userService = UserServince.getInstance();
			boolean bl = userService.save(user);			 
			if(bl){
				jsonData.put("flag", "yes");
				System.out.println(jsonData);
			}else{
				jsonData.put("flag", "no");
			}
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(jsonData.toString());
			pw.close();		
		}
		
		private void populateuser(HttpServletRequest request,User user){
			String loginIp = request.getRemoteAddr();
			String username = request.getParameter("username");
			String realname = request.getParameter("realname");
			String rule = request.getParameter("rule");
			String sex = request.getParameter("sex");
			String cityId = request.getParameter("city");
			String certTypeId = request.getParameter("cert_type");
			String cert = request.getParameter("cert");
			String birthday = request.getParameter("birthday");
			String userTypeId = request.getParameter("user_type");
			String content = request.getParameter("content");
			user.setLogin_ip(loginIp);
			user.setUsername(username);			
			user.setRealname(realname);
			user.setSex(sex);
			user.setRule(rule);
			
			City city = new City();
			city.setId(1);
		//	city.setId(Integer.parseInt(cityId.trim()));
			user.setCity(city);
			
			int aaa = 1;
			if ("1".equals(certTypeId)) {
				aaa = 1;
			} else if ("2".equals(certTypeId)) {
				aaa = 2;
			} else if ("3".equals(certTypeId)) {
				aaa = 3;
			} else if ("4".equals(certTypeId)) {
				aaa = 4;
			}
			
			CertType certtype = new CertType();
			certtype.setID(aaa);

			user.setCert_type(certtype);
			user.setCert(cert);
		 
			user.setBirthday(birthday);
	        
			int bbb = 1;
			if ("1".equals(userTypeId)) {
				bbb = 1;
			} else if ("2".equals(userTypeId)) {
				bbb = 2;
			} else if ("3".equals(userTypeId)) {
				bbb = 3;
			} else if ("4".equals(userTypeId)) {
				bbb = 4;
			}
				
			UserType userType = new UserType();
			userType.setId(bbb);
			
		//	userType.setId(3);
			user.setUser_type(userType);
			
			user.setContent(content);
		}
		
		private void doDel(HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			JSONObject data = new JSONObject();
			String[] ids = request.getParameter("ids_del").split(",");
			int[] userIdList = new int[ids.length];
			for(int i = 0; i < ids.length; i++){
				userIdList[i] = Integer.parseInt(ids[i]);
			}
			UserServince userService = UserServince.getInstance();
			boolean bl = userService.deleteUsers(userIdList);			 
			if(bl != false){
				data.put("flag", "yes");
			}
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(data.toString());
			pw.close();	
		}	
		
		private void doFindAndPush(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			User u = new User();
			u.setId(id);
			System.out.println(u.getId());
			UserServince us = UserServince.getInstance();
			User findUser = us.findUser(u);
			findUser.setId(u.getId());
			JSONObject data = new JSONObject();
			data.put("userData", findUser);
			System.out.println(data);
			request.getSession().setAttribute("data", data);
			request.getRequestDispatcher("/Admin/userAdd.jsp")
			.forward(request, response);
		}
		
		protected void doUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException, Exception{	 
				// List<IpAddress> list = service.getIpList();
				// TODO Auto-generated method stub
				User user = new User();
				populateuser(request, user);// 填充用户信息
				String sid = request.getParameter("id");
				user.setId(Integer.parseInt(sid));
				UserServince us = UserServince.getInstance();
				JSONObject data = new JSONObject();
				if (us.updateUser(user) != 0) {
					data.put("flag", "yes");
				}
				// 设置输出端的内容类型及格式
				response.setContentType("text/html;charset=utf-8");
				// 取得输出流
				PrintWriter pw = response.getWriter();
				// 向输出流写入内容
				pw.print(data.toString());
				// 清空输出流，将内容推送到响应端
				pw.close();
			}
}
