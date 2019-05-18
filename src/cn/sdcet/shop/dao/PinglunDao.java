package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Pinglun;

public interface PinglunDao {
	/**
	 * 列出所有评论
	 */
	public List<Pinglun> findAllPinglun();
	/**
	 * 通过商品id查询所有评论
	 * @param itemId
	 * @return
	 */
	public List<Pinglun> findPinglunByItemId(int itemId);
	/**
	 * 发表评论
	 * @param pinglun
	 */
	public void addPinglun(Pinglun pinglun);
	/**
	 * 删除 
	 * @param pinglun
	 */
	public void deletePinglun(int id);

}
