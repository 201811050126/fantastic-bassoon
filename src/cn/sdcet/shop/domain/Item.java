package cn.sdcet.shop.domain;

public class Item {
	private int id;
	private String name;
	private int price;
	private int catalogid;
	private String pref;
	private Catalog catalog;
	public Item() {
	}
	

	public Item(int id, String name, int price, int catalogid, String pref) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.catalogid = catalogid;
		this.pref = pref;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPref() {
		return pref;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	public int getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}
	
}
