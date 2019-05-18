package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Pinglun;

public interface PinglunDao {
	/**
	 * �г���������
	 */
	public List<Pinglun> findAllPinglun();
	/**
	 * ͨ����Ʒid��ѯ��������
	 * @param itemId
	 * @return
	 */
	public List<Pinglun> findPinglunByItemId(int itemId);
	/**
	 * ��������
	 * @param pinglun
	 */
	public void addPinglun(Pinglun pinglun);
	/**
	 * ɾ�� 
	 * @param pinglun
	 */
	public void deletePinglun(int id);

}
