package cn.sdcet.shop.dao;
import java.util.List;

import cn.sdcet.shop.domain.Item;

public interface ItemDao {
	/**
	 * 首页展示商品
	 */
	public List<Item> findAll(); 

	/**
	 *返回单件商品详细 
	 */
	public Item findById(int id); 
	
	/**
	 *根据类型编号，得到该类型的所有商品 
	 */
	public List<Item> getItemList(int catalogId);
	
	/**
	 * 根据关键字进行搜索商品
	 */
	public List<Item> findItemByName(String name); 
	/**
	 * 后台添加商品
	 */
	public void rootAddDao(Item item);
	/**
	 * 判断商品名是否重复
	 */
	public boolean addcheck(String name);
	/**
	 * 删除商品管理里面的商品
	 */		
	public void deleteItem(int id) ;
	/**
	 * 后台修改商品信息
	 * @param item
	 */
	public void updateItemInfo(Item item);
	
}
