package cn.sdcet.shop.dao;


public interface CarDao {
	/**
	 * 删除购物车条目
	 */
	public void delete(int shopcaritemId,int adminsId);
	
	/**
	 *修改商品数量 
	 */
	public void update(int itemId ,int adminsId ,int quantity);
	
	/**
	 * 增加商品至购物车
	 */
	public void add(int itemId,int adminsId);
	
	/**
	 * 清空购物车
	 */
	public void clear(int adminId);
	
	/**
	 * 返回购物车中总价
	 */
	public float getPayment(int adminId);
	}
