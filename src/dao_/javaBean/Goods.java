package dao_.javaBean;

public class Goods {

	private int goods_id;
	private String goods_name;
	private double unitprice;
	private String category;
	private String provider;
	public Goods(int goods_id, String goods_name, double unitprice, String category, String provider) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.unitprice = unitprice;
		this.category = category;
		this.provider = provider;
	}
	public Goods() {
		super();
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	@Override
	public String toString() {
		return "\nGoods [goods_id=" + goods_id + ", goods_name=" + goods_name + ", unitprice=" + unitprice + ", category="
				+ category + ", provider=" + provider + "]";
	}
	
}
