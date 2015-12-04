package org.maruhan.service;

import java.util.List;

import org.maruhan.domain.BoardVO;
import org.maruhan.domain.Criteria;
import org.maruhan.persistence.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
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
	
	public void update(BoardVO vo) throws Exception{
		mapper.update(vo);
	}
	
	public List<BoardVO> list() throws Exception{
		return mapper.list();
	}
	
	public List<BoardVO> search(Criteria cri) throws Exception{
		return mapper.search(cri);
	}
	
}
