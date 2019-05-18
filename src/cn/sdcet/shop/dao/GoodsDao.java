package cn.sdcet.shop.dao;
import java.util.List;

import cn.sdcet.shop.domain.Goods;
import cn.sdcet.shop.domain.Item;

public interface GoodsDao {
	/**
	 * 首页展示商品
	 */
	public List<Goods> findAll(); 

	/**
	 *根据编号得到商品
	 */
	public Goods getGoodsByGNo(int gNo);
	
	/**
	 * 根据关键字进行搜索商品
	 */
	public List<Goods> findGoodsByName(String name); 
	/**
	 * 后台添加商品
	 */
	public void rootAddDao(Goods goods);
	/**
	 * 判断商品名是否重复
	 */
	public boolean addcheck(String name);
	/**
	 * 删除商品管理里面的商品
	 */		
	public void deleteGoods(int id) ;
	/**
	 * 后台修改商品信息
	 * @param item
	 */
	public void updateGoodsInfo(Goods goods);
	
}
