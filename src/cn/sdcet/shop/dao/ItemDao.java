package cn.sdcet.shop.dao;
import java.util.List;

import cn.sdcet.shop.domain.Item;

public interface ItemDao {
	/**
	 * ��ҳչʾ��Ʒ
	 */
	public List<Item> findAll(); 

	/**
	 *���ص�����Ʒ��ϸ 
	 */
	public Item findById(int id); 
	
	/**
	 *�������ͱ�ţ��õ������͵�������Ʒ 
	 */
	public List<Item> getItemList(int catalogId);
	
	/**
	 * ���ݹؼ��ֽ���������Ʒ
	 */
	public List<Item> findItemByName(String name); 
	/**
	 * ��̨�����Ʒ
	 */
	public void rootAddDao(Item item);
	/**
	 * �ж���Ʒ���Ƿ��ظ�
	 */
	public boolean addcheck(String name);
	/**
	 * ɾ����Ʒ�����������Ʒ
	 */		
	public void deleteItem(int id) ;
	/**
	 * ��̨�޸���Ʒ��Ϣ
	 * @param item
	 */
	public void updateItemInfo(Item item);
	
}
