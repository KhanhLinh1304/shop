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

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IProductService productService;
	@Inject 
	private ICategoryService categoryService;
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");  
		   String name = request.getParameter("name");
		   List<ProductModel> products = productService.SearchByNameProduct(name);
		   List<CategoryModel> categories = categoryService.getAllCategory();
		   
		  boolean isEmmty = products.isEmpty();
		  request.setAttribute("isEmpty",isEmmty);
		   request.setAttribute("categories", categories);
		   request.setAttribute("products", products);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/search.jsp");
		    rd.forward(request, response);
		   
	}

}
