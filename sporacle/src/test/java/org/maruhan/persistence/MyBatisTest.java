package org.maruhan.persistence;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisTest extends DataSourceTest {
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testSession() throws Exception{
		SqlSession session = sqlFactory.openSession();
		logger.info(session.toString());
		session.close();
	}
	
}
