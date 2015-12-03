package org.maruhan.controller;

import java.util.ArrayList;
import java.util.List;

import org.maruhan.domain.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//@Autowired
	//private BoardService service;
	
	
	@RequestMapping(value = "/list" , method= RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info("BoardController........ info");
		
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		for (int i = 0; i < 10; i++) {
			BoardVO vo = new BoardVO();
			vo.setBno(i);
			vo.setTitle("제목"+i);
			vo.setWriter("작성자"+i);
			vo.setContent("내용"+i);
			list.add(vo);
		}
		
		model.addAttribute("list",list);
		
		
		//model.addAttribute("list", service.listAll());
	}
	
	
	
	@RequestMapping(value = "/create" , method= RequestMethod.GET)
	public void createGET(Model model) throws Exception{
		logger.info("Create get......");
		

	}
	
	
	@RequestMapping(value = "/create" , method= RequestMethod.POST)
	public String createPOST(Model model, BoardVO vo) throws Exception{
		logger.info("Create post......");
		
		model.addAttribute("result", "success");
		
		return "/board/success";

	}

	@RequestMapping(value = "/read" , method= RequestMethod.GET)
	public String readGET(Model model, @RequestParam("bno") int bno) throws Exception{
		logger.info("Read get......");
		
		model.addAttribute("result", "success");
		
		return "/board/success";

	}

}
