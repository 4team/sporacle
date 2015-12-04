package org.maruhan.persistence;

import org.maruhan.domain.MemberVO;

public interface MemberMapper extends CRUDMapper<MemberVO,String>{
	
	public String getTime();
	
}
