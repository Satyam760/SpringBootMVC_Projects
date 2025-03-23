package com.nt.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderService;

@Controller
public class SeasonOperationController {

	@Autowired
	private ISeasonFinderService service;
	
	@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/seaso")
	public String showSeason(Map<String, Object>map) {
		//use service
		String msg=service.findSeason();
		//keep result in Model Attribute
		map.put("resultMsg", msg);
		map.put("date",LocalDate.now());
		//return LVN
		return "display";
	}
	
	
	
}
