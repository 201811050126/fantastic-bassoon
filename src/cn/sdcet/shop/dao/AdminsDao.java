package cn.sdcet.shop.dao;

import cn.sdcet.shop.domain.Admins;

public interface AdminsDao {
	/**
	 * �ж�ע�����Ƿ��ظ�
	 */
	public boolean registerCheckAdmins(String name);
	/**
	 * �ж��û��Ƿ����
	 */
	public boolean hasMatchAdmins(String name , String password);
	
	/**
	 *����û� 
	 */
	public void addAdmins(Admins admins);
	
	/**
	 *������������id 
	 */
	public int getAdminsIdByName(String name); 
	/**
	 ͨ��id��ѯname 
	 */
	public String getAdminsIdById(int id);
	/**
	 * ͨ��id��ѯemail
	 */
	public String getAdminsemailById(int id);
}
