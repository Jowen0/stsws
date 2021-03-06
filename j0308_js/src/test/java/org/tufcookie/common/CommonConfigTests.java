package org.tufcookie.common;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tufcookie.common.config.CommonConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CommonConfig.class})
@Log4j
public class CommonConfigTests {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		log.info("1--------------");

		String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC";
		// &를 추가 할거면 jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC&amp;timeout 이렇게 써야한다.
		String username = "js";
		String password = "js";

		Connection con = DriverManager.getConnection(url, username, password);

		log.info(con);

		con.close();

	}
	
	@Test
	public void test1() {
		
		log.info("test1................");
		assertNotNull(ds); // ds가 Null인지 아닌지
		
	}
	
	@Test
	public void testSession() {
		
		log.info("session....................");
		SqlSession session = sqlSessionFactory.openSession();
		log.info(session);
		
		session.close();
		
	}
	
}
