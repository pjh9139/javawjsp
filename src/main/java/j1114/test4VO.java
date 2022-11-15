package j1114;

import java.util.Arrays;

public class test4VO {
	String name;
	String classification;
	String[] products;
	String[] strprice;
	String[] strnumber;
	int total;
	public String getName() {
		
		return name;
	}
	public test4VO(String name, String classification, String[] products, String[] strprice, String[] strnumber,
			int total) {
		super();
		this.name = name;
		this.classification = classification;
		this.products = products;
		this.strprice = strprice;
		this.strnumber = strnumber;
		this.total = total;
	}
	@Override
	public String toString() {
		return "test4VO [name=" + name + ", classification=" + classification + ", products=" + Arrays.toString(products)
				+ ", strprice=" + Arrays.toString(strprice) + ", strnumber=" + Arrays.toString(strnumber) + ", total=" + total
				+ "]";
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
}
