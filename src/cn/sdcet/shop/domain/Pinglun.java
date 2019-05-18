package cn.sdcet.shop.domain;

public class Pinglun {

	private int id;
	private String content;
	private Item item;
	private Admins admin;
	private int adminId;
	private int itemId;
	private String time;
	public Pinglun() {
	}
	public Pinglun(int id, String content, int adminId, int itemId, String time) {
		super();
		this.id = id;
		this.content = content;
		this.adminId = adminId;
		this.itemId = itemId;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Admins getAdmin() {
		return admin;
	}
	public void setAdmin(Admins admin) {
		this.admin = admin;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
