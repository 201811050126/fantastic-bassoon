package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.PinglunDao;
import cn.sdcet.shop.dao.jdbc.pinglunDaoJDBCImpl;
import cn.sdcet.shop.domain.Pinglun;

public class AddPinglunServlet extends HttpServlet {

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
		
		String userId = (String) request.getSession().getAttribute("id");
		int adminId = Integer.parseInt(userId);
		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		String itemPref = request.getParameter("itemPref");
		String content = request.getParameter("textarea");
		String idstr = request.getParameter("itemID");
		
		int itemId = Integer.parseInt(idstr);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = df.format(date);
		System.out.println(time);
		
		try {
			PinglunDao dao =new pinglunDaoJDBCImpl();
			Pinglun pinglun =new Pinglun();
			pinglun.setAdminId(adminId);
			pinglun.setItemId(itemId);
			pinglun.setContent(content);
			pinglun.setTime(time);
			dao.addPinglun(pinglun);
			response.sendRedirect("productInfo.jsp?itemId="+itemId+"&itemName="+itemName+"&itemPrice="+itemPrice+"&itemPref="+itemPref);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Ê§°Ü£º");
		}
		

	}

}
