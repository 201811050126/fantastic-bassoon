package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sdcet.shop.dao.AdminsDao;
import cn.sdcet.shop.dao.CarDao;
import cn.sdcet.shop.dao.jdbc.AdminsDaoJDBCImpl;
import cn.sdcet.shop.dao.jdbc.CarDaoJDBCImpl;
import cn.sdcet.shop.domain.Admins;

public class GetUserShopCarServlet extends HttpServlet {

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
			throws ServletException, IOException {doPost(request, response);}

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
		String id = request.getParameter("itemId");
		int itemId = Integer.parseInt(id);
		
		HttpSession httpSession = request.getSession();
		String strId = (String) httpSession.getAttribute("id");
		int adminsId =Integer.parseInt(strId);

		try {
			CarDao cardao = new CarDaoJDBCImpl();
			cardao.add(itemId, adminsId);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("调用添加购物车条目失败:" + e);
		}
		
		response.sendRedirect("car.jsp");
	}

}
