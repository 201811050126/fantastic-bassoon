package cn.sdcet.shop.domain;

public class ShopCarItem {
	private Item item;
	private int quantity;
	public ShopCarItem() {
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ShopCarItem(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}
	
}
