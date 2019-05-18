package cn.sdcet.shop.domain;

public class Car {
	private ShopCarItem shopCarItem;
	private Admins admins;
	public Car() {
	}
	public ShopCarItem getShopCarItem() {
		return shopCarItem;
	}
	public void setShopCarItem(ShopCarItem shopCarItem) {
		this.shopCarItem = shopCarItem;
	}
	public Admins getAdmins() {
		return admins;
	}
	public void setAdmins(Admins admins) {
		this.admins = admins;
	}
	
}
