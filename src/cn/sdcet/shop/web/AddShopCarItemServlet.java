package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.CarDao;
import cn.sdcet.shop.dao.jdbc.CarDaoJDBCImpl;

public class AddShopCarItemServlet extends HttpServlet {

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
		String id = (String) request.getSession().getAttribute("id");
		id = id == null ? "0" : id;
		int adminsId = Integer.parseInt(id);
		
		String strid = request.getParameter("itemId");
		strid = strid == null ? "0" : strid;
		
		int itemId = 0;
		if (!strid.equals("0")){
			itemId = Integer.parseInt(strid);
			try {
				CarDao carDao = new CarDaoJDBCImpl();
				carDao.add(itemId,adminsId);
				
			} catch (NamingException e) {
				e.printStackTrace();
				throw new RuntimeException("调用增加购物车条目失败:" + e);
			}finally{
				response.sendRedirect("car.jsp");
			}
		}
	}
}
