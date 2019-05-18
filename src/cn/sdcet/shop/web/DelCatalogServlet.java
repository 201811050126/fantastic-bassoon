package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.CatalogDao;
import cn.sdcet.shop.dao.ItemDao;
import cn.sdcet.shop.dao.PinglunDao;
import cn.sdcet.shop.dao.jdbc.CatalogDaoJDBCImpl;
import cn.sdcet.shop.dao.jdbc.ItemDaoJDBCImpl;
import cn.sdcet.shop.dao.jdbc.pinglunDaoJDBCImpl;
import cn.sdcet.shop.domain.Item;

public class DelCatalogServlet extends HttpServlet {

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
		String strid = request.getParameter("id");
		int id = Integer.parseInt(strid);
		try {
			ItemDao item = new ItemDaoJDBCImpl();
			List<Item> items=item.getItemList(id);
			if(items.size() == 0){
				CatalogDao catalog = new CatalogDaoJDBCImpl();
				catalog.deleteCatalog(id);
				response.sendRedirect("admin/cate.jsp");
			}else{
				String message1 = "删除失败（分类下存在商品）！";
				request.setAttribute("message1", message1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/cate.jsp");
				dispatcher.forward(request, response);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除分类条目失败:" + e);
		}finally{
			
		}
		


	}


	

}
