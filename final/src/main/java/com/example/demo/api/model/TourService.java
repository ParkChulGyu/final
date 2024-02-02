package com.example.demo.api.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.api.ApiProperties;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.io.IOException;
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

@Service
public class TourService {

	ApiProperties apiProperties = new ApiProperties();

	TouristEntity touristEntity = new TouristEntity();

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
				String numOfRows = (String) map.get("numOfRows");;
				String pageNo = (String) map.get("pageNo");
				String keyword = (String) map.get("keyword");;


				if (contentTypeId == null)contentTypeId = "12";
				if (numOfRows == null)numOfRows = "5";
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
//	            System.out.println("Response Code: " + response.statusCode());
//	            System.out.println("Response Body: " + response.body());

			// JSoup을 사용하여 <title> 값을 추출
			Document document = Jsoup.parse(response.body());
			// 응답 출력
			// System.out.println("Response Code: " + response.statusCode());
			// System.out.println("Response Body: " + response.body());
			map.put("numOfRows",document.select("numOfRows").text());
			map.put("pageNo",document.select("pageNo").text());
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
			System.out.println("Response Body: " + response.body());

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
		int numOfRows = 5;
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
			System.out.println("Response Body: " + response.body());

			totalCount = document.select("totalCount").text();

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

	public void HttpRequestExample() {

		try {
			// URL 설정
			String url = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1?MobileOS=ETC&MobileApp=AppTest&keyword=%EA%B0%95%EC%9B%90&serviceKey=lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D";
			URI uri = URI.create(url);
			// HttpClient 생성
			HttpClient httpClient = HttpClient.newHttpClient();
			// HttpRequest 생성
			HttpRequest httpRequest = HttpRequest.newBuilder().uri(uri).header("accept", "*/*").build();
			System.out.println("httpRequest : " + httpRequest);
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

}
