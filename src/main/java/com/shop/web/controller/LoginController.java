package com.shop.web.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.AccountModel;
import com.shop.service.IAccountService;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IAccountService accountService;
  
    public LoginController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 HttpSession session = request.getSession();
		 String email = request.getParameter("email");
		 String pass = request.getParameter("password");
		 AccountModel account = accountService.checkAccount(email);
		 if(account != null) {
			 session.setAttribute("account", account);
			 RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
			 rd.forward(request, response);
			 response.sendRedirect("web-home");
		 }else {
			 response.sendRedirect("login");
		 }
		 
	}

}
