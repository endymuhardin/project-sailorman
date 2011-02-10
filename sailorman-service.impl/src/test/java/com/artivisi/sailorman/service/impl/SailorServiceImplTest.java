package com.artivisi.sailorman.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.artivisi.sailorman.domain.Country;
import com.artivisi.sailorman.service.SailorService;


public class SailorServiceImplTest {
	private static AbstractApplicationContext applicationContext;
	private static SailorService sailorService;
	
	@BeforeClass
	public static void initSpring() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/applicationContext.xml");
		applicationContext.registerShutdownHook();
		
		sailorService = (SailorService) applicationContext.getBean("sailorService");

		//clearDatabase();
	}

	private static void clearDatabase() throws SQLException {
		DataSource ds = (DataSource) applicationContext.getBean("dataSource");
		Connection conn = ds.getConnection();
		conn.createStatement().executeUpdate("truncate m_sailor");
		conn.createStatement().executeUpdate("truncate m_vessel");
		conn.createStatement().executeUpdate("truncate m_country");
		conn.close();
	}
	
	@AfterClass
	public static void destroySpring(){
		applicationContext.destroy();
	}
	
	//@Test
	public void testCountry(){
		Country c = new Country();
		c.setCode("id");
		c.setName("Indonesia");
		
		sailorService.save(c);
	}
	@Test
	public void testHello(){
		System.out.println("Hello World");
	}
	
}
