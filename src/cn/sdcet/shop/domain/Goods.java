package cn.sdcet.shop.domain;

public class Goods {

	private int gNo;
	private String gId;
	private String gType;
	private String gColor;
	private String gSize;
	private int gNum;
	private double gPrice_input;
	private double gPrice;
	private double gSale;
	public Goods(){
		super();
	}
	
	public Goods( String gId, String gType, String gColor,
			String gSize, int gNum, double gPrice_input, double gPrice,
			double gSale) {
		super();
		this.gId = gId;
		this.gType = gType;
		this.gColor = gColor;
		this.gSize = gSize;
		this.gNum = gNum;
		this.gPrice_input = gPrice_input;
		this.gPrice = gPrice;
		this.gSale = gSale;
	}
	
	public Goods(int gNo, String gId, String gType, String gColor,
			String gSize, int gNum, double gPrice_input, double gPrice,
			double gSale) {
		super();
		this.gNo = gNo;
		this.gId = gId;
		this.gType = gType;
		this.gColor = gColor;
		this.gSize = gSize;
		this.gNum = gNum;
		this.gPrice_input = gPrice_input;
		this.gPrice = gPrice;
		this.gSale = gSale;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
	}
	public String getgType() {
		return gType;
	}
	public void setgType(String gType) {
		this.gType = gType;
	}
	public String getgColor() {
		return gColor;
	}
	public void setgColor(String gColor) {
		this.gColor = gColor;
	}
	public String getgSize() {
		return gSize;
	}
	public void setgSize(String gSize) {
		this.gSize = gSize;
	}
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public double getgPrice_input() {
		return gPrice_input;
	}
	public void setgPrice_input(double gPrice_input) {
		this.gPrice_input = gPrice_input;
	}
	public double getgPrice() {
		return gPrice;
	}
	public void setgPrice(double gPrice) {
		this.gPrice = gPrice;
	}
	public double getgSale() {
		return gSale;
	}
	public void setgSale(double gSale) {
		this.gSale = gSale;
	}
	
	
}
