package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.CatalogDao;
import cn.sdcet.shop.dao.jdbc.CatalogDaoJDBCImpl;
import cn.sdcet.shop.domain.Catalog;

public class UpdateCatalogServlet extends HttpServlet {

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
		String idStr=request.getParameter("id");
		int id=Integer.parseInt(idStr);
		String name=request.getParameter("title");
		System.out.println("id="+id);
		System.out.println("name="+name);
		
		try {
			CatalogDao dao = new CatalogDaoJDBCImpl();
			dao.updateCatalog(id, name);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("¸üÐÂÊ§°Ü£º");
		}finally{
			response.sendRedirect("admin/cate.jsp");
		}
		


	}

}
