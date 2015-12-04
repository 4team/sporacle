package org.maruhan.persistence;

import java.util.List;

import org.junit.Test;
import org.maruhan.domain.BoardVO;
import org.maruhan.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardMapperTest extends DataSourceTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void readTest() throws Exception{ // 완료
		System.out.println(mapper.read(2021));
	}
	
	@Test 
	public void createTest() throws Exception{ //완료
		BoardVO board = new BoardVO();
		board.setTitle("sporacle에서 테스트하는 제목");
		board.setContent("내용이니깐.ㅎ");
		board.setWriter("마루한님");
		mapper.create(board);
	}
	
	@Test
	public void deleteTest() throws Exception{
		mapper.delete(2095);
	}
	
	@Test
	public void updateTest() throws Exception{
		BoardVO board = mapper.read(2093);
	
		board.setTitle("안 될리가 없지!");
		board.setContent("한숨노노");
		
		mapper.update(board);
	}
	
	@Test
	public void testSearch() throws Exception{
		Criteria cri = new Criteria();
		cri.setPerPage(20);
		cri.setType("w");
		cri.setKeyword("마루한");
		List<BoardVO> list = mapper.search(cri);
		logger.info(list.toString());
	}

}
