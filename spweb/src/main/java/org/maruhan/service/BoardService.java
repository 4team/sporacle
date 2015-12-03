package org.maruhan.service;

import java.util.List;

import org.maruhan.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardService {

	@Autowired
	BoardMapper mapper;
	
	public void regist(BoardVO vo) throws Exception{
		mapper.create(vo);
	}
	
	public BoardVO view(int bno) throws Exception{
		return mapper.read(bno);
	}
	
	public void remove(int bno) throws Exception{
		mapper.delete(bno);
	}
	
	public void update(int bno) throws Exception{
		mapper.delete(bno);
	}
	
	public List<BoardVO> list() throws Exception{
		return mapper.listAll();
	}
}
