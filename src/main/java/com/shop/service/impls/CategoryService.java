package com.shop.service.impls;

import java.util.List;

import javax.inject.Inject;

import com.shop.dao.ICategoryDAO;
import com.shop.model.CategoryModel;
import com.shop.service.ICategoryService;

public class CategoryService implements ICategoryService {
	@Inject
	private ICategoryDAO categorydao;
	@Override
	public List<CategoryModel> getAllCategory() {
		// TODO Auto-generated method stub
		return categorydao.getAllCategory();
	}

	@Override
	public void CreateCategory(CategoryModel category) {
		categorydao.CreateCategory(category);
		
	}

	@Override
	public void UpdateCategory(CategoryModel category) {
		categorydao.UpdateCategory(category);
		
	}

	@Override
	public void deleteCategory(int idCategory) {
		categorydao.DeleteCategory(idCategory);;
		
	}

}
