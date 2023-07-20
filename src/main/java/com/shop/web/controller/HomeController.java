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

/**
 * Servlet implementation class HomeController
 * 
 */
@WebServlet(urlPatterns = "/web-home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
    private IProductService productService;
	@Inject
    private ICategoryService categoryService;
    public HomeController() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<ProductModel> products = productService.getAllProduct();
		List<CategoryModel> categories = categoryService.getAllCategory();
		request.setAttribute("categories", categories);
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
	    rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}

	

}
