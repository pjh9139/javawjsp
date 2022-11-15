package hw;

import java.util.Arrays;

public class hw1115VO {
	String name;
	String classification;
	String[] products;
	String[] strprice;
	String[] strnumber;
	public hw1115VO(String name, String classification, String[] products, String[] strprice, String[] strnumber,
			int total, int cnt) {
		super();
		this.name = name;
		this.classification = classification;
		this.products = products;
		this.strprice = strprice;
		this.strnumber = strnumber;
		this.total = total;
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String[] getProducts() {
		return products;
	}
	public void setProducts(String[] products) {
		this.products = products;
	}
	public String[] getStrprice() {
		return strprice;
	}
	public void setStrprice(String[] strprice) {
		this.strprice = strprice;
	}
	public String[] getStrnumber() {
		return strnumber;
	}
	public void setStrnumber(String[] strnumber) {
		this.strnumber = strnumber;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "hw1115VO [name=" + name + ", classification=" + classification + ", products="
				+ Arrays.toString(products) + ", strprice=" + Arrays.toString(strprice) + ", strnumber="
				+ Arrays.toString(strnumber) + ", total=" + total + ", cnt=" + cnt + "]";
	}
	int total;
	int cnt;
}
