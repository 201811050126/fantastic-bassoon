package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.ShopCarItem;

public interface ShopCarItemDao {
	/**
	 * ��ҳ��ʾ���
	 */
	public List<ShopCarItem> findAll(int adminsId); 
}
