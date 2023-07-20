package com.shop.dao;

import java.util.List;

import com.shop.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> getAllCategory();
	void CreateCategory(CategoryModel category);
	void UpdateCategory(CategoryModel category);
	void DeleteCategory(int idCategory);

}
