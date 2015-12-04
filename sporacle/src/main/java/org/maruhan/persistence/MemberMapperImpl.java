package org.maruhan.persistence;

import org.maruhan.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberMapperImpl extends AbstractCRUDMapper<MemberVO, String> implements MemberMapper {

	@Override
	public String getTime() {
		return session.selectOne(namespace+".getTime");
	}

}
