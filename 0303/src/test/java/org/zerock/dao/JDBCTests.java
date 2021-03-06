package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBCTests {
	
	@Test
	public void testConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		log.info("1--------------");
		
		String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC";
		// &를 추가 할거면 jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC&amp;timeout 이렇게 써야한다.
		String username = "springuser";
		String password = "springuser";
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		log.info(con);
		
		con.close();
		//여기까지가 JDBC 연결 1단계
		
		
	}
	
}
