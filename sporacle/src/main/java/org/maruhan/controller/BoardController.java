package org.maruhan.controller;

import java.util.List;

import org.maruhan.domain.BoardVO;
import org.maruhan.domain.Criteria;
import org.maruhan.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	
	@RequestMapping(value="/slist")
	public String listSearch(@ModelAttribute("cri")Criteria cri,Model model) throws Exception{
		logger.info("================================");
		logger.info(cri.toString());
		logger.info("================================");
		
		List<BoardVO> list  = service.search(cri);
		System.out.println(list);
		model.addAttribute("list",list);
		return "/board/slist";
		
	}
	
	

	@RequestMapping(value = "/list")
	public String listAll(@ModelAttribute("cri")Criteria cri, Model model) throws Exception{
		logger.info("BoardController........ info");
		cri.setKeyword("w");
		
		model.addAttribute("list", service.list());
		return "/board/list";
		
	}
	
	
	
	@RequestMapping(value = "/create" , method= RequestMethod.GET)
	public void createGET() throws Exception{
		logger.info("create get......");
		
//		return "/board/create";
}
	
	@RequestMapping(value = "/create" , method= RequestMethod.POST)
	public String createPOST(BoardVO vo, Model model) throws Exception{
		
		logger.info("create post......");
				
	    service.regist(vo);
		
		model.addAttribute("msg", "글쓰기 완료!");
		
		return "/board/success";
	}
	@RequestMapping(value = "/read" , method= RequestMethod.GET)
	public String readGET(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.info("Read get......");
		
		model.addAttribute("read", service.view(bno));
		return "/board/read";
}
	
	@RequestMapping(value = "/remove" , method= RequestMethod.POST)
	public String removePOST(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.info("remove post......");
		
		service.remove(bno);
		
		model.addAttribute("msg", "삭제완료!");
		
		return "/board/success";
	}
	
	
	@RequestMapping(value = "/modify" , method= RequestMethod.GET)
	public String modifyGET(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.info("modify get......");
		
		model.addAttribute("board", service.view(bno));
		return "/board/modify";
}
	
	@RequestMapping(value = "/modify" , method= RequestMethod.POST)
	public String modifyPOST(BoardVO vo, Model model) throws Exception{
		
		logger.info("modify post......");
				
	    service.update(vo);
		
		model.addAttribute("msg", "수정 완료!");
		
		return "/board/success";
	}
}
