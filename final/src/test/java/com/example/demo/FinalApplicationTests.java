package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.TourService;

@SpringBootTest
class FinalApplicationTests {

	TourService t_service = new TourService();

	@Test
	void contextLoads() {
		
		t_service.fetchDataFromExternalAPI();
		
	}
	
	@Test
	void contextLoads2() {
		
		t_service.HttpRequestExample();
		
	}
	
	
	
	
	

}
