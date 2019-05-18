package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Catalog;

public interface CatalogDao {
	/**
	 * ��ҳ��ʾ���
	 */
	public List<Catalog> findAll(); 
	/**
	 * ��ӷ���
	 */
	public void addCatalog(String name);
	/**
	 * ɾ�� 
	 * @param pinglun
	 */
	public void deleteCatalog(int id);
	/**
	 *���ķ���
	 * @param pinglun
	 */
	public void updateCatalog(int id,String name);
	/**
	 *ͨ������id��ѯ ��������
	 * @param pinglun
	 */
	public String findnameBycatalogId(int catalogId);
}
