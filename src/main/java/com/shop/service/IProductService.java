package com.shop.service;

import java.util.List;

import com.shop.model.ProductModel;
import com.shop.model.SizeColorModel;

public interface IProductService {
	List<ProductModel> getAllProduct();
	void CreateProduct(ProductModel product);
	void UpdateProduct(ProductModel product);
	void DeleteProduct(int idProduct);
	ProductModel getProductByIdProduct(int idProduct);
	List<ProductModel> getProductByIdCategory(int idCategory);
	List<SizeColorModel> getSizeColorProduct(int idProduct);
	List<ProductModel> SearchByNameProduct(String name);

}
