package cn.sdcet.shop.dao;

import cn.sdcet.shop.domain.Admins;

public interface AdminsDao {
	/**
	 * 判断注册名是否重复
	 */
	public boolean registerCheckAdmins(String name);
	/**
	 * 判断用户是否符合
	 */
	public boolean hasMatchAdmins(String name , String password);
	
	/**
	 *添加用户 
	 */
	public void addAdmins(Admins admins);
	
	/**
	 *根据姓名返回id 
	 */
	public int getAdminsIdByName(String name); 
	/**
	 通过id查询name 
	 */
	public String getAdminsIdById(int id);
	/**
	 * 通过id查询email
	 */
	public String getAdminsemailById(int id);
}
