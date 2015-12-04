package org.maruhan.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {

	protected static final Logger logger = LoggerFactory.getLogger(DataSourceTest.class);
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void test() throws Exception{
//		System.out.println(ds); // Autowired를 확인하는 수준.
		logger.info(ds.toString());
		
		Connection con = ds.getConnection(); // 연결 잘 맺어지는 지 확인.
		logger.info(con.toString());
		
		con.close();
	}

}
