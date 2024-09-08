package com.security.test.dto;


public class Product {
	private int pid;
	private String name;
	private int qty;
	private int price;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product(int pid, String name, int qty, int price) {
		super();
		this.pid = pid;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
	
	
	
	

}
