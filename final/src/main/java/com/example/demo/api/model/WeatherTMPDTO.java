package com.example.demo.api.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class WeatherTMPDTO {
	private String fcstTime; //예보 시간 1200 시간별
    private String TMP; //    1시간 기온	℃
   

	public WeatherTMPDTO() {
	}


	public WeatherTMPDTO( String fcstTime,String tMP) {
		super();
		this.fcstTime = fcstTime;
		TMP = tMP;
	}


	
	// 생성자
	
	// 생성자
	
	

}