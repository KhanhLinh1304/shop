package com.shop.web.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.CategoryModel;
import com.shop.model.ProductModel;
import com.shop.service.ICategoryService;
import com.shop.service.IProductService;
import com.shop.service.impls.CategoryService;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/categoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IProductService productService;
	@Inject
	private ICategoryService categoryService;
	
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idCategory"));
		List<ProductModel> products = productService.getProductByIdCategory(id);
		List<CategoryModel> categories = categoryService.getAllCategory();
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/productByCategory.jsp");
		rd.forward(request, response);
	}


}
