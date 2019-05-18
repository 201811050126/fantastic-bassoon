package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.domain.Catalog;
import cn.sdcet.shop.dao.CatalogDao;
import cn.sdcet.shop.dao.jdbc.CatalogDaoJDBCImpl;

public class AddCatalogServlet extends HttpServlet {

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
		String name = request.getParameter("title");
		int num=1;
		
		if(name=="")
		{
			num=0;
		}
		if(num!=0){
		try {
			CatalogDao dao =new CatalogDaoJDBCImpl();
			dao.addCatalog(name);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			response.sendRedirect("admin/cate.jsp");
		}
		}else{
			String message = "分类名称不能为空！";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin/cate.jsp");
			dispatcher.forward(request, response);
		}
		
		


	}

}
