package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.rootDao;
import cn.sdcet.shop.dao.jdbc.rootDaoJDBCImpl;



public class rootlogincheck extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String message = null;
		String name = request.getParameter("rootname");
		String password = request.getParameter("rootpsword");
		
		try {
			rootDao dao = new rootDaoJDBCImpl();
			boolean check = dao.rootlogincheck(name, password);
			if(check==true){
				
				
			
				request.getSession().setAttribute("rootname", name);
				
				response.sendRedirect("admin/admin.jsp");
			}else{
				//登录失败
				request.setAttribute("message", "用户名或密码不正确");			
				RequestDispatcher dispatcher = request.getRequestDispatcher("rootlogin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("失败：");
		}
	}
	
	}

