package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.ShopCarItem;

public interface ShopCarItemDao {
	/**
	 * 首页显示类别
	 */
	public List<ShopCarItem> findAll(int adminsId); 
}
