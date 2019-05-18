package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.jdbc.ItemDaoJDBCImpl;
import cn.sdcet.shop.domain.Item;

public class UpdateItemInfoServlet extends HttpServlet {

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
		
		String idsr = request.getParameter("id");
		int id =Integer.parseInt(idsr);
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int p=Integer.parseInt(price);
		String pref = request.getParameter("pref");
		String catalogid=request.getParameter("catalogid");
		int c = Integer.parseInt(catalogid);

		try {

			ItemDaoJDBCImpl dao =new ItemDaoJDBCImpl();
			boolean check = dao.addcheck(name);
			System.out.println(check);
			if (check == true) {
				Item item = new Item();

				item.setId(id);
				item.setName(name);
				item.setPrice(p);
				item.setPref(pref);
				item.setCatalogid(c);

				dao.updateItemInfo(item);
				response.sendRedirect("admin/list.jsp");

			}else{
				request.setAttribute("message", "修改名称不能和原名相同！");
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/updateItem.jsp");
				dispatcher.forward(request, response);
			}			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改商品信息失败：");
		}

	}

}
