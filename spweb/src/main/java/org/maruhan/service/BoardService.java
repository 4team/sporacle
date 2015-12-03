package org.maruhan.service;

import java.util.List;

import org.maruhan.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> listAll() throws Exception;
	
}
