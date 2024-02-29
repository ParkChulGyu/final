package com.example.demo.api.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class WeatherDTO {
	private String POP; //    강수확률	%
	private String PTY; //    강수형태	코드값
	private String PCP; //    1시간 강수량	범주 (1 mm)
	private String REH; //    습도	%
	private String SNO; //    1시간 신적설	범주(1 cm)
    private String SKY; //    하늘상태	코드값
    private String TMP; //    1시간 기온	℃
    private String TMN; //    일 최저기온	℃
    private String TMX; //    일 최고기온	℃
    private String UUU; //    풍속(동서성분)	m/s
    private String VVV; //    풍속(남북성분)	m/s
    private String WAV; //    파고	M
    private String VEC; //    풍향	deg
    private String WSD; //    풍속	m/s
    private String fcstTime; //예보 시간 1200 시간별
   

//    강수확률	%
//    강수형태	코드값
//    1시간 강수량	범주 (1 mm)
//    습도	%
//    1시간 신적설	범주(1 cm)
//    하늘상태	코드값
//    1시간 기온	℃
//    일 최저기온	℃
//    일 최고기온	℃
//    풍속(동서성분)	m/s
//    풍속(남북성분)	m/s
//    파고	M
//    풍향	deg
//    풍속	m/s

	public WeatherDTO() {
	}


	public WeatherDTO(String pOP, String pTY, String pCP, String rEH, String sNO, String sKY, String tMP, String tMN,
			String tMX, String uUU, String vVV, String wAV, String vEC, String wSD, String fcstTime) {
		super();
		POP = pOP;
		PTY = pTY;
		PCP = pCP;
		REH = rEH;
		SNO = sNO;
		SKY = sKY;
		TMP = tMP;
		TMN = tMN;
		TMX = tMX;
		UUU = uUU;
		VVV = vVV;
		WAV = wAV;
		VEC = vEC;
		WSD = wSD;
		this.fcstTime = fcstTime;
	}


	
	// 생성자
	
	// 생성자
	
	

}