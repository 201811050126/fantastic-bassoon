package cn.sdcet.shop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.GoodsDao;
import cn.sdcet.shop.dao.jdbc.GoodsDaoJDBCImpl;
import cn.sdcet.shop.domain.Goods;

public class GoodsServlet extends HttpServlet {
	GoodsDao dao = new GoodsDaoJDBCImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 统一执行doPost方法
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置文件编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 获取请求参数
		String type = request.getParameter("type");
		String strgNo = request.getParameter("gNo");
		String gId = request.getParameter("gId");
		String gType =request.getParameter("gType");
		String gColor =request.getParameter("gColor");
		String gSize =request.getParameter("gSize");
		String strgNum =request.getParameter("gNum");
		String strgPrice_input =request.getParameter("gPrice_input");
		String strgPrice =request.getParameter("gPrice");
		String strgSale =request.getParameter("gSale");
		// 跳转到更新页面
		if("toFrom".equals(type)){
			// 先判断再转类型  防止空指针
			if(strgNo!=null&&!"".equals(strgNo)){
				int gNo = Integer.parseInt(strgNo);
				// 查询要更新的商品
				Goods goods = dao.getGoodsByGNo(gNo);
				request.setAttribute("goods", goods);
				forword("", "admin/goods/update.jsp", request, response);
			}else{
				forword("商品编号[gNO]不能为空", "admin/goods/list.jsp", request, response);	
			}
		// 添加商品
		}else if("doAdd".equals(type)){
			int gNum = Integer.parseInt(strgNum);
			double gPrice_input = Double.parseDouble(strgPrice_input);
			double gPrice = Double.parseDouble(strgPrice);
			double gSale = Double.parseDouble(strgSale);
			Goods goods = new Goods( gId, gType, gColor, gSize, gNum, gPrice_input, gPrice, gSale);
			if(!dao.addcheck(gId)){
				forword("商品编号[gNO]不能重复", "admin/goods/add.jsp", request, response);	
			}else{
				dao.rootAddDao(goods);
				redirect("goods?type=findAll", response);
			}
			
		// 更新商品
		}else if("doUpdate".equals(type)){
				int gNo = Integer.parseInt(strgNo);
				int gNum = Integer.parseInt(strgNum);
				double gPrice_input = Double.parseDouble(strgPrice_input);
				double gPrice = Double.parseDouble(strgPrice);
				double gSale = Double.parseDouble(strgSale);
				Goods goods = new Goods(gNo, gId, gType, gColor, gSize, gNum, gPrice_input, gPrice, gSale);
				dao.updateGoodsInfo(goods);
			redirect("goods?type=findAll", response);
		// 删除商品
		}else if("doDelete".equals(type)){
			if(strgNo!=null&&!"".equals(strgNo)){
				int gNo = Integer.parseInt(strgNo);
				dao.deleteGoods(gNo);
				redirect("admin/goods/list.jsp", response);
			}else{
				forword("商品编号[gNO]不能为空", "admin/goods/list.jsp", request, response);	
			}
		// 查询所有的商品
		}else if("findAll".equals(type)){
			List<Goods> goodsList = dao.findAll();
			request.setAttribute("goodsList", goodsList);
			forword("", "admin/goods/list.jsp", request, response);
		// 根据商品代号查询商品
		}else if("findByName".equals(type)){
			List<Goods> goodsList = dao.findGoodsByName(gId);
			request.setAttribute("goodsList", goodsList);
			forword("", "admin/goods/list.jsp", request, response);
		}else{
			forword("", "admin/goods/list.jsp", request, response);
		}
		
	}
	/**
	 * 执行forward操作
	 * @param message 提示信息
	 * @param page 要跳转的页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void forword(String message,String page,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setAttribute("message", message);
		request.getRequestDispatcher(page).forward(request, response);
	}
	
	/**
	 * 执行redirect操作
	 * @param page 要跳转的页面
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void redirect(String page,HttpServletResponse response)throws ServletException, IOException {
		response.sendRedirect(page);
	}
	
	
}
