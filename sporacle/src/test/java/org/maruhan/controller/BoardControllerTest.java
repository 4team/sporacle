package org.maruhan.controller;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardControllerTest {

	
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardControllerTest.class);
	
	@Inject
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        logger.info("setup............");
    }
	
	@Test
	public void boardTest() throws Exception{
		System.out.println("호출됨....");
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/board/slist")
    			.param("pageNo", "2")
    			.param("type", "w")
    			.param("keyword", "안녕")
    			).andReturn();
    	
    	ModelAndView mav = result.getModelAndView();
    	
    	System.out.println("크리를 얻음 : "+mav.getModel().get("cri").toString());
    	System.out.println("모델 & 뷰 : "+mav.getViewName());
    	//컨트롤러에서 전달되는 모든 것은 Model And View이다.
	}
}
