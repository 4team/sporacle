package org.maruhan.persistence;

import java.util.List;

import org.maruhan.domain.BoardVO;
import org.maruhan.domain.Criteria;

public interface BoardMapper extends CRUDMapper<BoardVO, Integer> {
	public List<BoardVO> search(Criteria cri) throws Exception;
	public int searchCount(Criteria cri) throws Exception;
}
