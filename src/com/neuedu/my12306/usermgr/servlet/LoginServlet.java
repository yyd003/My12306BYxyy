package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.my12306.common.Md5Utils;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.service.UserServince;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action == null || "login".equals(action)){
			doLogin(request, response);
		}
	}
	
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserServince us = new UserServince();
		User u = us.login(username, Md5Utils.md5(password));
		if(u == null){
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head> <meta charset = 'UTF-8'>");
			out.println("<title>hello</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>\"请先注册！\"<p>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}else{
			if("1".equals(u.getRule())){
//				response.sendRedirect(request.getContextPath()
//						+ "/Admin/Index.jsp");
				response.sendRedirect(request.getContextPath()
					+ "/Admin/admin?action=show");
			} else {
//				response.sendRedirect(request.getContextPath()
//						+ "/User/Index.jsp");
				response.sendRedirect(request.getContextPath()
						+ "/Manager.html");
			}
		}	
	}
}
