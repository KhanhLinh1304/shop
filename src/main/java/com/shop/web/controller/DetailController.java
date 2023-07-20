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

import com.shop.model.ProductModel;
import com.shop.model.SizeColorModel;
import com.shop.service.IProductService;

/**
 * Servlet implementation class DetailController
 */
@WebServlet("/detailController")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IProductService productService;
    
    public DetailController() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("idProduct"));
		ProductModel product = productService.getProductByIdProduct(id);
		List<SizeColorModel> lists = productService.getSizeColorProduct(id);
		request.setAttribute("product", product);
		request.setAttribute("lists", lists);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/detail.jsp");
		rd.forward(request, response);
	}



}
