package org.maruhan.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return session.selectOne(namespace+".searchCount",cri);
	}

	@Override
	public List<BoardVO> list() {
		return session.selectList(namespace+".list");
	}

	@Override
	public void updateReplyCnt(Integer bno, int amount) throws Exception {
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);
		
		session.update(namespace+".updateReplyCnt",paramMap);
	}

	
}
