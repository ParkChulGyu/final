package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.api.ApiProperties;
import com.example.demo.api.model.TourService;


@SpringBootTest
class FinalApplicationTests {
	
	private final ApiProperties apiProperties = new ApiProperties();

	TourService t_service = new TourService();
	
	
	@Test // 실패
	void contextLoads() {
		
		t_service.fetchDataFromExternalAPI();
		
	}
	
	@Test
	void contextLoads2() {
		
		t_service.HttpRequestExample();
		
	}
	
	
	@Test // 실패
	void contextLoads3() {
		
	}
	
	
	

}
