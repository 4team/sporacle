package org.maruhan.persistence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberMapperTest extends DataSourceTest {
	
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void getTimetest() throws Exception{
		System.out.println(mapper.getTime());
	}
	
}
