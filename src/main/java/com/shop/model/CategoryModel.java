package com.shop.model;

public class CategoryModel {
	private int idCategory;
	private String nameCategory;
	public CategoryModel(int idCategory, String nameCategory) {
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;	
	}
	public int getIdCategory() {
		return idCategory;
		
	}
	public void setIdCategory(int id) {
		this.idCategory = id;
		
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String name) {
		this.nameCategory = name;
	}
	
	
	
}
