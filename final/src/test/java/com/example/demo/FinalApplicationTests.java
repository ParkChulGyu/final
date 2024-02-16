package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.api.controller.FlaskController;
import com.example.demo.api.model.GpsTransfer;
import com.example.demo.api.model.WeatherService;

@SpringBootTest
class FinalApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void contextLoads2() throws Exception {
		
		
		
		Map<String, Object> map = new HashMap<>();
		
		WeatherService weatherService = new WeatherService();
		
		weatherService.fetchDataFromExternalAPIweather(map);
		 
		
	}
	
	@Test
	void contextLoads3() throws Exception {
		
		GpsTransfer gpsTransfer = new GpsTransfer(55, 127);
		
		gpsTransfer.transfer(gpsTransfer, 1);
		
		System.out.println(gpsTransfer.getLat());
	}
	
	

}
