package cn.sdcet.shop.dao;


public interface CarDao {
	/**
	 * ɾ�����ﳵ��Ŀ
	 */
	public void delete(int shopcaritemId,int adminsId);
	
	/**
	 *�޸���Ʒ���� 
	 */
	public void update(int itemId ,int adminsId ,int quantity);
	
	/**
	 * ������Ʒ�����ﳵ
	 */
	public void add(int itemId,int adminsId);
	
	/**
	 * ��չ��ﳵ
	 */
	public void clear(int adminId);
	
	/**
	 * ���ع��ﳵ���ܼ�
	 */
	public float getPayment(int adminId);
	}
