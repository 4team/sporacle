package org.maruhan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.maruhan.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardServiceTest {
	
	@Autowired
	private BoardService service;
	
	
	@Test
	public void view() throws Exception{
		System.out.println(service);
	}
	
	@Test
	public void create() throws Exception{
		BoardVO dto = new BoardVO();
		dto.setTitle("테스트 제목입니다.");
		dto.setContent("테스트 내용입니다요.");
		dto.setWriter("테스터");
		service.create(dto);
	}
	
	@Test
	public void read() throws Exception{
		System.out.println(service.read(2099));
	}
	
	@Test
	public void delete() throws Exception{
		service.delete(2098);
	}
	
}
