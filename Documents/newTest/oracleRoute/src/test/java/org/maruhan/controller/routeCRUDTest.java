package org.maruhan.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.maruhan.domain.RouteVO;
import org.maruhan.persistence.RouteMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class routeCRUDTest{

	@Autowired
	private RouteMapperImpl mapper;
	
	@Test
	public void test() throws Exception {
		System.out.println(mapper.read(1));
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void createRoute() throws Exception{
		String name = "seounMiddleSchool";
		double lat = 37.4935662;
		double lng = 127.0226473;
		
		RouteVO vo = new RouteVO();
		vo.setRoutename(name);
		vo.setLat(lat);
		vo.setLng(lng);
		mapper.create(vo);
	}

	@Test
	public void listTest() throws Exception{
		List<RouteVO> list = mapper.listAll();
		System.out.println(list);
	}
}
