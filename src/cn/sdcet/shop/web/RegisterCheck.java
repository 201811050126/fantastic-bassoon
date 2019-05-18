package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.AdminsDao;
import cn.sdcet.shop.dao.jdbc.AdminsDaoJDBCImpl;
import cn.sdcet.shop.domain.Admins;

public class RegisterCheck extends HttpServlet {

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
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		String passT = request.getParameter("passwordT");
		String email = request.getParameter("email");
		int number = -1;
		if (name == "") {
			number = 1;
		}
		if (pass == "") {
			number = 1;
		}
		if (passT == "") {
			number = 1;
		}
		if (email == "") {
			number = 1;
		}
		if (number == -1 && pass.equals(passT) == true) {

			try {
				AdminsDao dao = new AdminsDaoJDBCImpl();
				boolean check = dao.registerCheckAdmins(name);
				System.out.println(check);
				if (check == true) {
					Admins admin = new Admins();
					admin.setName(name);
					admin.setPassword(pass);
					admin.setEmail(email);
					dao.addAdmins(admin);
					response.sendRedirect("login.jsp");
				}else{
				//下回分解
					request.setAttribute("message", "您的用户名已被别人注册！");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
					dispatcher.forward(request, response);
				}

			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String message = "密码不相同或不能有空值";
			request.setAttribute("message", message);
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
	}

}
