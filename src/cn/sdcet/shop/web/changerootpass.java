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
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class changerootpass extends HttpServlet {

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
		String rootname = (String)request.getSession().getAttribute("rootname");
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String renewpassword = request.getParameter("renewpassword");
	try {
			rootDao dao = new rootDaoJDBCImpl();
			boolean check = dao.rootlogincheck(rootname, password);
		if(check == true){
			
			if(renewpassword.length()==0){
				request.setAttribute("message", "密码不准为空，请重新输入");			
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/pass.jsp");
				dispatcher.forward(request, response);
			}
			else{
				if(password.equals(newpassword)==false){
					if(newpassword.equals(renewpassword)==true){
						dao.updateroot(newpassword);
						RequestDispatcher dispatcher = request.getRequestDispatcher("admin/success.jsp");
						dispatcher.forward(request, response);
					}
					else{
						request.setAttribute("message", "新密码与确认密码不相同，请重新输入");			
						RequestDispatcher dispatcher = request.getRequestDispatcher("admin/pass.jsp");
						dispatcher.forward(request, response);
					}
				}
				else{
					request.setAttribute("message", "新密码与原密码相同，请重新输入");			
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/pass.jsp");
					dispatcher.forward(request, response);
				}
			}
			

		}else{
			//登录失败
			request.setAttribute("message", "原密码不正确，请重新输入");			
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin/pass.jsp");
			dispatcher.forward(request, response);
		}
	} catch (NamingException e) {
		e.printStackTrace();
		throw new RuntimeException("失败：");
	}

	}

}
