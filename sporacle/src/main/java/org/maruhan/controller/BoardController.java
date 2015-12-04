package org.maruhan.controller;

import org.maruhan.domain.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/slist")
	public void listSearch(@ModelAttribute("cri")Criteria cri) throws Exception{
		logger.info("================================");
		logger.info(cri.toString());
		logger.info("================================");
		
	}
}
