package com.artivisi.sailorman.service.impl;

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
	public static void initSpring(){
		applicationContext = new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/applicationContext.xml");
		applicationContext.registerShutdownHook();
		
		sailorService = (SailorService) applicationContext.getBean("sailorService");
	}
	
	@AfterClass
	public static void destroySpring(){
		applicationContext.destroy();
	}
	
	@Test
	public void testCountry(){
		Country c = new Country();
		c.setCode("id");
		c.setName("Indonesia");
		
		sailorService.save(c);
	}
	
}
