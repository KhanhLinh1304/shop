package com.shop.service;

import java.util.List;

import com.shop.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> getAllCategory();
	void CreateCategory(CategoryModel category);
	void UpdateCategory(CategoryModel category);
	void deleteCategory(int idCategory);

}
