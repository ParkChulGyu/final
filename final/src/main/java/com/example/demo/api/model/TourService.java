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
import java.sql.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class TourService {

	ApiProperties apiProperties = new ApiProperties();

	TouristEntity touristEntity = new TouristEntity();
	
	public Map<String, Object> fetchDataFromExternalAPIdetail(Map<String, Object> map) throws Exception {
		TourDetailDTO tourDetailDTO = new TourDetailDTO();

		// Apiproperties에서 필요값 세팅하기
		String apiUrl = apiProperties.getKapp_api_url();
		String serviceKey = apiProperties.getPcg_service_key();
		// URL 설정
//		String baseUrl = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1";
//		String serviceKey = "lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D";
//		String searchKeyword = "searchKeyword";
		String mobileOS = "ETC";
		String mobileApp = "AppTest";
		String contentId = (String) map.get("contentid");

		//System.out.println("map : "+map);
		//System.out.println("contentId =="+contentId);

		if(contentId == null)contentId = "2792802";

		
		String uri = apiUrl + "/detailCommon1" + "?serviceKey=" + serviceKey + "&MobileOS=" + mobileOS + "&MobileApp="
				+ mobileApp + "&_type=json" + "&contentId="+contentId
				+ "&defaultYN=Y&firstImageYN=Y&areacodeYN=N&catcodeYN=N&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&numOfRows=1&pageNo=1";

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
		tourDetailDTO = mapElementsToDtoListDetail(jsonItem);
		// System.out.println("tourDetailDTO == "+tourDetailDTO);
		map.put("tourDetailDTO", tourDetailDTO);

		// 응답 헤더 출력
		// HttpHeaders headers = response.headers();
		// headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		return map;
	}


	public Map<String, Object> fetchDataFromExternalAPI(Map<String, Object> map) {
				List<TouristDTO> touristDTO = new ArrayList<>();

				// Apiproperties에서 필요값 세팅하기
				String apiUrl = apiProperties.getKapp_api_url();
				String serviceKey = apiProperties.getPcg_service_key();
				// URL 설정
//				String baseUrl = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1";
//				String serviceKey = "lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D";
//				String searchKeyword = "searchKeyword";
				String mobileOS = "ETC";
				String mobileApp = "AppTest";
				String listYN = "Y";
				String arrange = "A";

				String contentTypeId = (String) map.get("contentTypeId");
				String numOfRows = (String) map.get("numOfRows");
				;
				String pageNo = (String) map.get("pageNo");
				String keyword = (String) map.get("keyword");
				

//						System.out.println("map : "+map);

				if (contentTypeId == null)contentTypeId = "12";
				if (numOfRows == null)numOfRows = "6";
				if (pageNo == null)pageNo = "1";
				if (keyword == null)keyword = "강원";

				int totalCount = 0;

		

		try {

			String uri = apiUrl + "/searchKeyword1" + "?numOfRows=" + numOfRows + "&pageNo=" + pageNo
					+ "&contentTypeId=" + contentTypeId + "&MobileOS=" + mobileOS + "&MobileApp=" + mobileApp
					+ "&listYN=" + listYN + "&arrange=" + arrange + "&keyword="  
					+ URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString()) + "&serviceKey=" + serviceKey;

			URI finalUri = URI.create(uri);
			// System.out.println("finalUri : " + finalUri);

			// HttpClient 생성
			HttpClient httpClient = HttpClient.newHttpClient();

			// HttpRequest 생성
			HttpRequest httpRequest = HttpRequest.newBuilder().uri(finalUri).header("accept", "*/*").build();

			// System.out.println("httpRequest : "+ httpRequest );

			// HttpResponse 받기
			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			// 응답 출력
			// System.out.println("document =="+document);
//	            System.out.println("Response Code: " + response.statusCode());
//	            System.out.println("Response Body: " + response.body());

			// JSoup을 사용하여 <title> 값을 추출
			Document document = Jsoup.parse(response.body());
			// 응답 출력
			// System.out.println("Response Code: " + response.statusCode());
			// System.out.println("Response Body: " + response.body());
			map.put("numOfRows",document.select("numOfRows").text());
			map.put("pageNo",document.select("pageNo").text());

			// System.out.println("totalcount text"+document.select("totalCount").text());

			map.put("totalCount",document.select("totalCount").text());

			Elements itemElements = document.select("item");

			touristDTO = mapElementsToDtoList(itemElements);
			map.put("touristDTO", touristDTO);

			// 응답 헤더 출력
			// HttpHeaders headers = response.headers();
			// headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return map;
	}

	public List<TouristDTO> fetchDataFromExternalAPI(String contentTypeId) {
		List<TouristDTO> touristDTO = new ArrayList<>();

		if (contentTypeId == null) {
			contentTypeId = "12";
		}

		// Apiproperties에서 필요값 가져오기
		String apiUrl = apiProperties.getKapp_api_url();
		String serviceKey = apiProperties.getPcg_service_key();
		// URL 설정
//		String baseUrl = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1";

		String searchKeyword = "searchKeyword";
		String mobileOS = "ETC";
		String mobileApp = "AppTest";
		String keyword = "강원";
//		String serviceKey = "lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D";
		int numOfRows = 5;
		int pageNo = 1;
		String listYN = "Y";
		String arrange = "A";

		try {

			String uri = apiUrl + "/searchKeyword1" + "?numOfRows=" + numOfRows + "&pageNo=" + pageNo
					+ "&contentTypeId=" + contentTypeId + "&MobileOS=" + mobileOS + "&MobileApp=" + mobileApp
					+ "&listYN=" + listYN + "&arrange=" + arrange + "&keyword="
					+ URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString()) + "&serviceKey=" + serviceKey;

			URI finalUri = URI.create(uri);
			// System.out.println("finalUri : " + finalUri);

			// HttpClient 생성
			HttpClient httpClient = HttpClient.newHttpClient();

			// HttpRequest 생성
			HttpRequest httpRequest = HttpRequest.newBuilder().uri(finalUri).header("accept", "*/*").build();

			// System.out.println("httpRequest : "+ httpRequest );

			// HttpResponse 받기
			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			// 응답 출력
//	            System.out.println("Response Code: " + response.statusCode());
//	            System.out.println("Response Body: " + response.body());

			// JSoup을 사용하여 <title> 값을 추출
			Document document = Jsoup.parse(response.body());
			// 응답 출력
			// System.out.println("Response Code: " + response.statusCode());
			//System.out.println("Response Body: " + response.body());

			Elements itemElements = document.select("item");

			touristDTO = mapElementsToDtoList(itemElements);

			// 응답 헤더 출력
			// HttpHeaders headers = response.headers();
			// headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return touristDTO;

	}

	public List<TouristDTO> fetchDataFromExternalAPI() {
		List<TouristDTO> touristDTO = new ArrayList<>();

		// Apiproperties에서 필요값 가져오기
		String apiUrl = apiProperties.getKapp_api_url();
		String serviceKey = apiProperties.getPcg_service_key();
		// URL 설정
//		String baseUrl = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1";

		String searchKeyword = "searchKeyword";
		String mobileOS = "ETC";
		String mobileApp = "AppTest";
		String listYN = "Y";
		String arrange = "A";
//		String serviceKey = "lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D";
		String keyword = "강원";
		int numOfRows = 6;
		int pageNo = 1;
		String totalCount = "";

		try {

			String uri = apiUrl + "/searchKeyword1" + "?numOfRows=" + numOfRows + "&pageNo=" + pageNo + "&MobileOS="
					+ mobileOS + "&MobileApp=" + mobileApp + "&listYN=" + listYN + "&arrange=" + arrange + "&keyword="
					+ URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString()) + "&serviceKey=" + serviceKey;

			URI finalUri = URI.create(uri);
			// System.out.println("finalUri : " + finalUri);

			// HttpClient 생성
			HttpClient httpClient = HttpClient.newHttpClient();

			// HttpRequest 생성
			HttpRequest httpRequest = HttpRequest.newBuilder().uri(finalUri).header("accept", "*/*").build();

			// System.out.println("httpRequest : "+ httpRequest );

			// HttpResponse 받기
			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			// 응답 출력
//	            System.out.println("Response Code: " + response.statusCode());
//	            System.out.println("Response Body: " + response.body());

			// JSoup을 사용하여 <title> 값을 추출
			Document document = Jsoup.parse(response.body());
			// 응답 출력
			// System.out.println("Response Code: " + response.statusCode());
			// System.out.println("Response Body: " + response.body());

			totalCount = document.select("totalCount").text();

			Elements itemElements = document.select("item");

			touristDTO = mapElementsToDtoList(itemElements);
			
			//System.out.println("touristDTO ==" + touristDTO);

			// 응답 헤더 출력
			// HttpHeaders headers = response.headers();
			// headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return touristDTO;

	}

	public void HttpRequestExample() {

		try {
			// URL 설정
			String url = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1?MobileOS=ETC&MobileApp=AppTest&keyword=%EA%B0%95%EC%9B%90&serviceKey=lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D";
			URI uri = URI.create(url);
			// HttpClient 생성
			HttpClient httpClient = HttpClient.newHttpClient();
			// HttpRequest 생성
			HttpRequest httpRequest = HttpRequest.newBuilder().uri(uri).header("accept", "*/*").build();
			//System.out.println("httpRequest : " + httpRequest);
			// HttpResponse 받기
			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			// 응답 출력
//	            System.out.println("Response Code: " + response.statusCode());
//	            System.out.println("Response Body: " + response.body());
			// JSoup을 사용하여 <title> 값을 추출
			Document document = Jsoup.parse(response.body());
			Elements titleElements = document.select("title");

			if (!titleElements.isEmpty()) {
				for (Element titleElement : titleElements) {
					String title = titleElement.text();
					System.out.println("Title: " + title);
				}
			} else {
				System.out.println("No <title> elements found in the response.");
			}
			// 응답 헤더 출력
			HttpHeaders headers = response.headers();
			headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ... (이전 코드 생략)

	private List<TouristDTO> mapElementsToDtoList(Elements elementsList) {
		List<TouristDTO> touristDtoList = new ArrayList<>();

		if (!elementsList.isEmpty()) {

			for (Element element : elementsList) {
				TouristDTO touristDto = new TouristDTO();
				touristDto.setTitle(element.select("title").text());
				touristDto.setAddr1(element.select("addr1").text());
				touristDto.setAddr2(element.select("addr2").text());
				touristDto.setAreacode(element.select("areacode").text());
				touristDto.setBooktour(element.select("booktour").text());
				touristDto.setCat1(element.select("cat1").text());
				touristDto.setCat2(element.select("cat2").text());
				touristDto.setCat3(element.select("cat3").text());
				touristDto.setContentid(element.select("contentid").text());
				touristDto.setContenttypeid(element.select("contenttypeid").text());
				touristDto.setCreatedtime(element.select("createdtime").text());
				touristDto.setFirstimage(element.select("firstimage").text());
				touristDto.setFirstimage2(element.select("firstimage2").text());
				touristDto.setCpyrhtDivCd(element.select("cpyrhtDivCd").text());
				touristDto.setMapx(element.select("mapx").text());
				touristDto.setMapy(element.select("mapy").text());
				touristDto.setMlevel(element.select("mlevel").text());
				touristDto.setModifiedtime(element.select("modifiedtime").text());
				touristDto.setSigungucode(element.select("sigungucode").text());
				touristDto.setTel(element.select("tel").text());

				touristDtoList.add(touristDto);
			}
		} else {
			System.out.println("No <title> elements found in the response.");
		}

		return touristDtoList;
	}
	
	
	private TourDetailDTO mapElementsToDtoListDetail(JSONArray elementsList) {
		TourDetailDTO tourDetaiDto = new TourDetailDTO();

//		System.out.println("elementsList ::::"+elementsList);

		for (Object element : elementsList) {
			JSONObject jo = (JSONObject) element;
//				System.out.println("jo:::::"+jo);
			tourDetaiDto.setTitle((String) jo.get("title"));
//				System.out.println("tourDetaiDto ::::::"+tourDetaiDto.getTitle());
			tourDetaiDto.setAddr1((String) jo.get("addr1"));
			tourDetaiDto.setAddr2((String) jo.get("addr2"));
			tourDetaiDto.setBooktour((String) jo.get("booktour"));
			tourDetaiDto.setContentid((String) jo.get("contentid"));
			tourDetaiDto.setContenttypeid((String) jo.get("contenttypeid"));
			tourDetaiDto.setCreatedtime((String) jo.get("createdtime"));
			tourDetaiDto.setModifiedtime((String) jo.get("modifiedtime"));
			tourDetaiDto.setTel((String) jo.get("tel"));
			tourDetaiDto.setTelname((String) jo.get("telname"));
			tourDetaiDto.setHomepage((String) jo.get("homepage"));
			tourDetaiDto.setFirstimage((String) jo.get("firstimage"));
			tourDetaiDto.setFirstimage2((String) jo.get("firstimage2"));
			tourDetaiDto.setCpyrhtDivCd((String) jo.get("cpyrhtDivCd"));
			tourDetaiDto.setZipcode((String) jo.get("zipcode"));
			tourDetaiDto.setMapx((String) jo.get("mapx"));
			tourDetaiDto.setMapy((String) jo.get("mapy"));
			tourDetaiDto.setMlevel((String) jo.get("mlevel"));
			tourDetaiDto.setOverview((String) jo.get("overview"));
		}

		return tourDetaiDto;
	}
	
	

}
