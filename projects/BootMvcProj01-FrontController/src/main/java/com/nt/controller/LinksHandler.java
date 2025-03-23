package com.nt.controller;

import java.util.Set;

import com.nt.service.ILinkService;
import com.nt.service.LinksServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

public class LinksHandler {
	private ILinkService service;
	
	public LinksHandler() {
		service=new LinksServiceImpl();
	}
	
	//handler method1
	public String showWishMessage(HttpServletRequest req) {
		//use service method
		String resultMsg= service.generateWishMessage();
		//keep the result in request scope
		req.setAttribute("wmsg", resultMsg);
		//return Logical View Name (lvn) based which physical
		//jsp file name and location will decided
		return "wish_result";	
	}
	
	//handler method2
	public String showAllLanguages(HttpServletRequest req) {
		//use service
		Set<String>langSet=service.fetchAllLanguages();
		//keep the result in request scope
		req.setAttribute("langInfo", langSet);
		//return lvn
		return "all_lang";
		
	}
	
}
