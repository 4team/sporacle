package org.maruhan.service;

import java.util.List;

import org.maruhan.domain.BoardVO;
import org.maruhan.persistence.AbstractCRUDMapper;

public class BoardMapperImpl extends AbstractCRUDMapper<BoardVO, Integer> implements BoardService {

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".list");
	}

}
