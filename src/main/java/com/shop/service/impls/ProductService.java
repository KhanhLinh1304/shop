package com.shop.service.impls;

import java.util.List;

import javax.inject.Inject;

import com.shop.dao.IProductDAO;
import com.shop.model.ProductModel;
import com.shop.model.SizeColorModel;
import com.shop.service.IProductService;

public class ProductService implements IProductService {
	@Inject
	private IProductDAO productdao;

	@Override
	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return productdao.getAllProduct();
	}

	@Override
	public void CreateProduct(ProductModel product) {
		productdao.CreateProduct(product);
		
	}

	@Override
	public void UpdateProduct(ProductModel product) {
		productdao.UpdateProduct(product);
		
	}

	@Override
	public void DeleteProduct(int idProduct) {
		productdao.DeleteProduct(idProduct);
		
	}

	@Override
	public ProductModel getProductByIdProduct(int idProduct) {
		return productdao.getProductByIdProduct(idProduct);
	}

	@Override
	public List<ProductModel> getProductByIdCategory(int idCategory) {
		return productdao.getProductByIdCategory(idCategory);
	}

	@Override
	public List<SizeColorModel> getSizeColorProduct(int idProduct) {
		// TODO Auto-generated method stub
		return productdao.getSizeColorProduct(idProduct);
	}

	@Override
	public List<ProductModel> SearchByNameProduct(String name) {
		// TODO Auto-generated method stub
		return productdao.searchByNameProduct(name);
	}

}
