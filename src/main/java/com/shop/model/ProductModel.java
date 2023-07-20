package com.shop.model;

public class ProductModel {
	private int idP;
	private int idC;
	private int quantity;
	private float price;
	private String image;
	private String name;
	public ProductModel(int idProduct, int idCategory, int quantity, float price, String image, String name) {
		this.idP = idProduct;
		this.idC = idCategory;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.name = name;
	}
	public int getIdProduct() {
		return this.idP;
	}
	public void setIdProduct(int idProduct) {
		this.idP = idProduct;
	}
	public int getIdCategory() {
		return idC;
	}
	public void setIdCategory(int idC) {
		this.idC = idC;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
