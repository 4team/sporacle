package org.maruhan.persistence;

import java.util.List;

import org.maruhan.domain.BoardVO;
import org.maruhan.domain.Criteria;
import org.springframework.stereotype.Repository;
@Repository
public class BoardMapperImpl extends AbstractCRUDMapper<BoardVO, Integer> implements BoardMapper {

	@Override
	public List<BoardVO> search(Criteria cri) throws Exception {
		return session.selectList(namespace+".search",cri);
	}

	@Override
	public int searchCount(Criteria cri) throws Exception {
		return session.selectOne(namespace+".searchCount");
	}

	@Override
	public List<BoardVO> listAll() {
		return session.selectList(namespace+".list");
	}

	
}
