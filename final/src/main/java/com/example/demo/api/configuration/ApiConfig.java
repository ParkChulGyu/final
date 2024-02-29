package com.example.demo.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.api.ApiProperties;
import com.example.demo.api.model.GpsTransfer;
import com.example.demo.api.model.TourService;
import com.example.demo.api.model.WeatherService;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class ApiConfig {

	private final ApiProperties apiProperties = new ApiProperties();

	
	@Bean
    public TourService tourService() {
        return new TourService();
    }
	
	@Bean
	public PagingDTO pagingDTO() {
		return new PagingDTO();
	}

	@Bean
	public WeatherService weatherService() {
		return new WeatherService();
	}
	
	@Bean
	public GpsTransfer gpsTransfer() {
		return new GpsTransfer();
	}
	
	
}
