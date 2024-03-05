package com.example.demo.api.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class WeatherPOPDTO {
	private String fcstTime; //예보 시간 1200 시간별
    private String POP; //    1시간 기온	℃
   

	public WeatherPOPDTO() {
	}


	public WeatherPOPDTO(String fcstTime, String pOP) {
		super();
		this.fcstTime = fcstTime;
		POP = pOP;
	}


	
	// 생성자
	
	// 생성자
	
	

}