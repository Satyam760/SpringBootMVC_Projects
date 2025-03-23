package com.nt.frontcontroller;

import java.io.IOException;

import com.nt.controller.LinksHandler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class WebFrontControllerServlet extends HttpServlet{
	private LinksHandler handler=null;
	
	@Override
	public void init() throws ServletException {
		handler=new LinksHandler();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("WebFrontControllerServlet.doGet() :: "+req.getServletPath());
		//Navigation management 
		String lvn=null;
		if(req.getServletPath().equalsIgnoreCase("/wish")) {
			lvn=handler.showWishMessage(req);
		}
		else if(req.getServletPath().equalsIgnoreCase("/lang")) {
			lvn=handler.showAllLanguages(req);
		}
		else {
			lvn="home";
		}
		
		//View management
		String destPage=null;
		if(lvn.equalsIgnoreCase("wish_result")) {
			destPage="/show_wish.jsp";
		}
		else if(lvn.equalsIgnoreCase("all_lang")) {
			destPage="/show_languages.jsp";
		}
		else {
			destPage="index.jsp";
		}
		
		//forward the request page to destination page
		RequestDispatcher rd=req.getRequestDispatcher(destPage);
		rd.forward(req, res);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
