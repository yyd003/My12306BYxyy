package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.neuedu.my12306.common.Md5Utils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.Province;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.domain.UserType;
import com.neuedu.my12306.usermgr.service.CertTypeService;
import com.neuedu.my12306.usermgr.service.CityService;
import com.neuedu.my12306.usermgr.service.ProvinceService;
import com.neuedu.my12306.usermgr.service.UserServince;
import com.neuedu.my12306.usermgr.service.UserTypeServince;


/**
 * Servlet implementation class registerServlet
 */
//@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action == null || "register".equals(action)){
			doRegister(request,response);
		}
		
		else if("check".equals(action)){
			doUsernameCheck(request,response);
		}
		
		else if("show".equals(action)){
			try{
				dataInit(request,response);
				request.getRequestDispatcher("/Login.html").forward(request, response);
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		
		else if("findCity".equals(action)){
			try{
				doFindCity(request,response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
	
	protected void doUsernameCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		UserServince userService = UserServince.getInstance();
		JSONObject data = new JSONObject();
		User u = new User();
		u.setUsername(username);
		// 如果查找到此用户名，此返回yes，告诉对象这个名不能注册
		if(userService.findUser(u) != null){
			data.put("flag", "yes");			
		}
		//将消息输出到请求端
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(data.toString());
		pw.close();
		
//		User one = new User();
//		one = userService.findUser(u);
//		System.out.println(one);
//		String rs = "0";
//		if(one == null){
//			rs = "1";
//		}
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print(rs);
//		out.close();	
		
	}
	
	//用户注册
	protected void doRegister(HttpServletRequest request,HttpServletResponse response) throws IOException{
		User user = new User();
		populate(request,user);
		user.setRule("2");
		user.setStatus("1");
		String msg = null;
//		String msg = validate(user);
		//if(TextUtils.isEmpty(msg)){
			UserServince userService = UserServince.getInstance();
			User tmp = new User();
			tmp.setUsername(user.getUsername());
			User dbUser = userService.findUser(tmp);
			if(dbUser == null){
				user.setPassword(Md5Utils.md5(user.getPassword()));
				userService.save(user);
				msg = "注册成功";
			}else{
				msg = "用户名重复";
			}
		//}
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head> <meta charset = 'UTF-8'>");
			out.println("<title>hello</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>"  +msg + "<p>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
	}
	
	private void populate(HttpServletRequest request,User user){
		String loginIp = request.getRemoteAddr();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String certTypeId = request.getParameter("cert_type");
		String cert = request.getParameter("cert");
		String birthday = request.getParameter("birthday");
		String userTypeId = request.getParameter("user_type");
		String content = request.getParameter("content");
		user.setLogin_ip(loginIp);
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setSex(sex);
		City city = new City();
		city.setId(1);
		user.setCity(city);
		CertType certtype = new CertType();
		certtype.setID(Integer.parseInt(certTypeId.trim()));
		user.setCert_type(certtype);
		user.setCert(cert);
	//	if(!TextUtils.isEmpty(birthday)){
			user.setBirthday(birthday);
	//	}
			
		UserType userType = new UserType();
		userType.setId(Integer.parseInt(userTypeId.trim()));
		user.setUser_type(userType);
		
		user.setContent(content);
	}
	
	
	
	private void doFindCity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			Exception {
		JSONObject jsonData = new JSONObject();
		// 1 　得到要查询的父(province)的id
		String provinceId = request.getParameter("provinceid");
		// 2 　调用cityService的getCityListByProID方法查询其子(cityList)集合
		CityService cs = CityService.getInstance();
		List<City> cityList = cs.getCityListByProID(provinceId);
		// 2-1列表转json数据
		if (cityList != null) {
			jsonData.put("data", cityList);
		} else {
			jsonData.put("data", null);
		}
		// 3 　将查询到的子集合（cityList）以字符串形式传回到页面，在页面的js中处理结果接收并据此添加
		// 字符流
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// String cityData = jsonData.toString();
		out.print(jsonData);
		out.close();
		// 去js页面接收数据并产生option元素
	}
 
	private void dataInit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			Exception {
		certTypeDateInit(request,response);
		userTypeDateInit(request,response);
		provinceDateInit(request,response);
	}
	
	private void certTypeDateInit (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			Exception {
		JSONObject jsonData = new JSONObject();
		CertTypeService cts = CertTypeService.getInstance();
		List<CertType> dataList = cts.getCertType();
		if(dataList != null){
			jsonData.put("data", dataList);
		}else{
			jsonData.put("data", null);
		}
		request.getSession().setAttribute("certTypeData", jsonData);
	}	
	
	private void userTypeDateInit (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			Exception {
		JSONObject jsonData = new JSONObject();
		UserTypeServince cts = UserTypeServince.getInstance();
		List<UserType> dataList = cts.getUserType();
		if(dataList != null){
			jsonData.put("data", dataList);
		}else{
			jsonData.put("data", null);
		}
		request.getSession().setAttribute("userTypeData", jsonData);
	}	
	
	private void provinceDateInit (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			Exception {
		JSONObject jsonData = new JSONObject();
		ProvinceService cts = ProvinceService.getInstance();
		List<Province> dataList = cts.getProvinceList();
		if(dataList != null){
			jsonData.put("data", dataList);
		}else{
			jsonData.put("data", null);
		}
		request.getSession().setAttribute("provinceData", jsonData);
//		System.out.println(jsonData);
	}	
}
