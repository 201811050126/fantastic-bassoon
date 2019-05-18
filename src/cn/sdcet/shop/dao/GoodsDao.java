package cn.sdcet.shop.dao;
import java.util.List;

import cn.sdcet.shop.domain.Goods;
import cn.sdcet.shop.domain.Item;

public interface GoodsDao {
	/**
	 * ��ҳչʾ��Ʒ
	 */
	public List<Goods> findAll(); 

	/**
	 *���ݱ�ŵõ���Ʒ
	 */
	public Goods getGoodsByGNo(int gNo);
	
	/**
	 * ���ݹؼ��ֽ���������Ʒ
	 */
	public List<Goods> findGoodsByName(String name); 
	/**
	 * ��̨�����Ʒ
	 */
	public void rootAddDao(Goods goods);
	/**
	 * �ж���Ʒ���Ƿ��ظ�
	 */
	public boolean addcheck(String name);
	/**
	 * ɾ����Ʒ�����������Ʒ
	 */		
	public void deleteGoods(int id) ;
	/**
	 * ��̨�޸���Ʒ��Ϣ
	 * @param item
	 */
	public void updateGoodsInfo(Goods goods);
	
}
