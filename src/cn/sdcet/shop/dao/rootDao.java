package cn.sdcet.shop.dao;

public interface rootDao {
	public boolean rootlogincheck(String rootname , String rootpsword);
	public void updateroot(String password);
}
