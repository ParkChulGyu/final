package com.example.demo.api.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.api.ApiProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.text.SimpleDateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class WeatherService {

	ApiProperties apiProperties = new ApiProperties();

	TouristEntity touristEntity = new TouristEntity();
	
	GpsTransfer gpsTransfer=new GpsTransfer();
	
	
	public Map<String, Object> fetchDataFromExternalAPIweather(Map<String, Object> map) throws Exception {
		List<WeatherDTO> weatherDTOList = new ArrayList<WeatherDTO>();
		List<WeatherTMPDTO> weatherTMPDTOList = new ArrayList<WeatherTMPDTO>();

		// Apiproperties에서 필요값 세팅하기
		String apiUrl = apiProperties.getKapp_api_url();
		String serviceKey = apiProperties.getPcg_service_key();
		
		// 현재 시간 설정
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        
        Date oneHourAgo = calendar.getTime();
		
		SimpleDateFormat day = new SimpleDateFormat("yyyyMMdd");
		
		
		SimpleDateFormat hour = new SimpleDateFormat("HH00");

        // 시간을 문자열로 변환하여 저장
        String daystamp = day.format(now);
        String hourstamp = (hour.format(oneHourAgo));

        // 결과 출력
        //System.out.println("오늘 날짜 : " + daystamp);
        //System.out.println("현재 시간: " + hourstamp);
        
        //변환된 x y 위경도 출력
        gpsTransfer = (GpsTransfer) map.get("gpsTransfer");
		
		double nx = gpsTransfer.getxLat();
		double ny = gpsTransfer.getyLon();
		// URL 설정
		
		//System.out.println("nx ny ::; = " + nx +","+ny);
		
		
		String uri = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"
				+ "?serviceKey=lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D"
				+ "&pageNo=1"
				+ "&numOfRows=1000"
				+ "&dataType=JSON"
				+ "&base_date=20240215"
				+ "&base_time=0800"
				+ "&nx=72"
				+ "&ny=135";
				
				
				
		URI finalUri = URI.create(uri);
//		System.out.println("finalUri : " + finalUri);

		// HttpClient 생성
		HttpClient httpClient = HttpClient.newHttpClient();

		// HttpRequest 생성
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(finalUri).header("accept", "*/*").build();

		// System.out.println("httpRequest : "+ httpRequest );

		// HttpResponse 받기
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

		// 응답 출력
//        System.out.println("Response Code: " + response.statusCode());
		// System.out.println("Response Body: " + response.body());

		// JSoup을 사용하여 <title> 값을 추출
		Document document = Jsoup.parse(response.body());
		// 응답 출력
		// System.out.println("Response Code: " + response.statusCode());
		// System.out.println("Response Body: " + response.body());
		// System.out.println("totalcount text"+document.select("totalCount").text());

		// System.out.println("document = "+ document);
		// Elements itemElements = document.select("body");
		// 값이 xml로 와서 JSONParser 을 사용으로 변경
		// System.out.println("itemElements = " + itemElements);
		String bodyresponse = document.select("body").text();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(bodyresponse);
		// 가장 큰 JSON 객체 response 가져오기
		JSONObject jsonResponse = (JSONObject) jsonObject.get("response");

		// 그 다음 body 부분 파싱
		JSONObject jsonBody = (JSONObject) jsonResponse.get("body");

		// 그 다음 위치 정보를 배열로 담은 items 파싱
		JSONObject jsonItems = (JSONObject) jsonBody.get("items");

		JSONArray jsonItem = (JSONArray) jsonItems.get("item");

//		System.out.println("jsonItem :::"+jsonItem);
//		weatherDTOList = mapElementsToDtoWeatherList(jsonItem);
//		map.put("weatherDTOList", weatherDTOList);
		weatherTMPDTOList = mapElementsToDtoWeatherTMPList(jsonItem);
//		System.out.println("tourDetailDTO == "+tourDetailDTO);
		map.put("weatherTMPDTOList", weatherTMPDTOList);
		
		//System.out.println("map :::" +map);

		// 응답 헤더 출력
		// HttpHeaders headers = response.headers();
		// headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		return map;
	}

	
	
	private List<WeatherDTO> mapElementsToDtoWeatherList(JSONArray elementsList) {
		List<WeatherDTO> weatherDTOList = new ArrayList<WeatherDTO>();
		WeatherDTO weatherDTO = new WeatherDTO();

		//System.out.println("elementsList ::::"+elementsList);

		for (Object element : elementsList) {
			JSONObject jo = (JSONObject) element;
//				System.out.println("jo:::::"+jo);
//				break;
				
//				if (jo.get("category").equals("POP"))weatherDTO.setPOP((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("PTY"))weatherDTO.setPTY((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("PCP"))weatherDTO.setPCP((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("REH"))weatherDTO.setREH((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("SNO"))weatherDTO.setSNO((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("SKY"))weatherDTO.setSKY((String)jo.get("fcstValue")); 
				if (jo.get("category").equals("TMP"))weatherDTO.setTMP((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("TMN"))weatherDTO.setTMN((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("TMX"))weatherDTO.setTMX((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("UUU"))weatherDTO.setUUU((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("VVV"))weatherDTO.setVVV((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("WAV"))weatherDTO.setWAV((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("VEC"))weatherDTO.setVEC((String)jo.get("fcstValue")); 
//				if (jo.get("category").equals("WSD"))weatherDTO.setWSD((String)jo.get("fcstValue")); 
				if (jo.get("category").equals("TMP"))weatherDTO.setFcstTime((String)jo.get("fcstTime")); 
				
				weatherDTOList.add(weatherDTO);

				//System.out.println("weatherDTOList:::" + weatherDTOList);
//				break;
		}
		//System.out.println("weatherDTOList:::" + weatherDTOList);

		return weatherDTOList;
	}
	private List<WeatherTMPDTO> mapElementsToDtoWeatherTMPList(JSONArray elementsList) {
		List<WeatherTMPDTO> weatherTMPDTOList = new ArrayList<WeatherTMPDTO>();

		//System.out.println("elementsList ::::"+elementsList);

		for (Object element : elementsList) {
			JSONObject jo = (JSONObject) element;
			WeatherTMPDTO weatherTMPDTO = new WeatherTMPDTO();
				//System.out.println("jo:::::"+jo);
//				break;
				
				if (jo.get("category").equals("TMP")) {
					weatherTMPDTO.setTMP((String)jo.get("fcstValue"));
					weatherTMPDTO.setFcstTime((String)jo.get("fcstTime")); 
					weatherTMPDTOList.add(weatherTMPDTO);
					//System.out.println("weatherDTOList:::" + weatherTMPDTOList);
					} 
				

//				break;
		}
		//System.out.println("weatherDTOList:::" + weatherTMPDTOList);

		return weatherTMPDTOList;
	}
	

}
