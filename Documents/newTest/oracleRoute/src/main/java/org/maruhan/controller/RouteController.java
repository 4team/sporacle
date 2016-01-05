package org.maruhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/route/*")
public class RouteController {
	
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listAll(Model model) {
		
	}
	
}
