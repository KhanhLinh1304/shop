package com.shop.model;

public class SizeColorModel {
	private int idProduct;
	private int idSize;
	private int idColor;
	private String nameSize;
	private String nameColor;
	public SizeColorModel(int idProduct, int idSize, int idColor, String nameSize, String nameColor) {
		super();
		this.idProduct = idProduct;
		this.idSize = idSize;
		this.idColor = idColor;
		this.nameSize = nameSize;
		this.nameColor = nameColor;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdSize() {
		return idSize;
	}
	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}
	public int getIdColor() {
		return idColor;
	}
	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}
	public String getNameSize() {
		return nameSize;
	}
	public void setNameSize(String nameSize) {
		this.nameSize = nameSize;
	}
	public String getNameColor() {
		return nameColor;
	}
	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}
	

}
