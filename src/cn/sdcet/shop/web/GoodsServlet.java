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
		
		// ͳһִ��doPost����
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����ļ�����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// ��ȡ�������
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
		// ��ת������ҳ��
		if("toFrom".equals(type)){
			// ���ж���ת����  ��ֹ��ָ��
			if(strgNo!=null&&!"".equals(strgNo)){
				int gNo = Integer.parseInt(strgNo);
				// ��ѯҪ���µ���Ʒ
				Goods goods = dao.getGoodsByGNo(gNo);
				request.setAttribute("goods", goods);
				forword("", "admin/goods/update.jsp", request, response);
			}else{
				forword("��Ʒ���[gNO]����Ϊ��", "admin/goods/list.jsp", request, response);	
			}
		// �����Ʒ
		}else if("doAdd".equals(type)){
			int gNum = Integer.parseInt(strgNum);
			double gPrice_input = Double.parseDouble(strgPrice_input);
			double gPrice = Double.parseDouble(strgPrice);
			double gSale = Double.parseDouble(strgSale);
			Goods goods = new Goods( gId, gType, gColor, gSize, gNum, gPrice_input, gPrice, gSale);
			if(!dao.addcheck(gId)){
				forword("��Ʒ���[gNO]�����ظ�", "admin/goods/add.jsp", request, response);	
			}else{
				dao.rootAddDao(goods);
				redirect("goods?type=findAll", response);
			}
			
		// ������Ʒ
		}else if("doUpdate".equals(type)){
				int gNo = Integer.parseInt(strgNo);
				int gNum = Integer.parseInt(strgNum);
				double gPrice_input = Double.parseDouble(strgPrice_input);
				double gPrice = Double.parseDouble(strgPrice);
				double gSale = Double.parseDouble(strgSale);
				Goods goods = new Goods(gNo, gId, gType, gColor, gSize, gNum, gPrice_input, gPrice, gSale);
				dao.updateGoodsInfo(goods);
			redirect("goods?type=findAll", response);
		// ɾ����Ʒ
		}else if("doDelete".equals(type)){
			if(strgNo!=null&&!"".equals(strgNo)){
				int gNo = Integer.parseInt(strgNo);
				dao.deleteGoods(gNo);
				redirect("admin/goods/list.jsp", response);
			}else{
				forword("��Ʒ���[gNO]����Ϊ��", "admin/goods/list.jsp", request, response);	
			}
		// ��ѯ���е���Ʒ
		}else if("findAll".equals(type)){
			List<Goods> goodsList = dao.findAll();
			request.setAttribute("goodsList", goodsList);
			forword("", "admin/goods/list.jsp", request, response);
		// ������Ʒ���Ų�ѯ��Ʒ
		}else if("findByName".equals(type)){
			List<Goods> goodsList = dao.findGoodsByName(gId);
			request.setAttribute("goodsList", goodsList);
			forword("", "admin/goods/list.jsp", request, response);
		}else{
			forword("", "admin/goods/list.jsp", request, response);
		}
		
	}
	/**
	 * ִ��forward����
	 * @param message ��ʾ��Ϣ
	 * @param page Ҫ��ת��ҳ��
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
	 * ִ��redirect����
	 * @param page Ҫ��ת��ҳ��
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void redirect(String page,HttpServletResponse response)throws ServletException, IOException {
		response.sendRedirect(page);
	}
	
	
}
