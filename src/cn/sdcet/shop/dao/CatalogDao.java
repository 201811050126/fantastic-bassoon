package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Catalog;

public interface CatalogDao {
	/**
	 * 首页显示类别
	 */
	public List<Catalog> findAll(); 
	/**
	 * 添加分类
	 */
	public void addCatalog(String name);
	/**
	 * 删除 
	 * @param pinglun
	 */
	public void deleteCatalog(int id);
	/**
	 *更改分类
	 * @param pinglun
	 */
	public void updateCatalog(int id,String name);
	/**
	 *通过分类id查询 分类名称
	 * @param pinglun
	 */
	public String findnameBycatalogId(int catalogId);
}
