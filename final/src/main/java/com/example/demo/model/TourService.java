package com.example.demo.model;

import org.springframework.web.client.RestTemplate;
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


public class TourService {

	private final String serviceKey = "lqQazXlaDVBCC6RSW8rmSCPJnO4+6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4/PezxtDigZOOtR4lZbgcvg==";
	private final String isX = "latitude_value";
	private final String isY = "longitude_value";

	private final String numOfRows = "10";
	private final String pageNo = "1";
	private final String MobileOS = "ETC";
	private final String MobileApp = "AppTest";
	private final String _type = "json";
	private final String listYN = "Y";
	private final String arrange = "A";
	private final String keyword = "%EA%B0%95%EC%9B%90";
	
	

	public void fetchDataFromExternalAPI() {
		String apiUrl = String.format(
				"https://apis.data.go.kr/B551011/KorService1",
				serviceKey, numOfRows, pageNo,MobileOS,MobileApp,_type,listYN,arrange,keyword);

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiUrl, String.class);

		// 이후 result를 파싱하거나 원하는 작업을 수행
		System.out.println(result);
	}
	
	public void HttpRequestExample() {

	        try {
	            // URL 설정
	            String url = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1?MobileOS=ETC&MobileApp=AppTest&keyword=%EA%B0%95%EC%9B%90&serviceKey=lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D";
	            URI uri = URI.create(url);

	            // HttpClient 생성
	            HttpClient httpClient = HttpClient.newHttpClient();

	            // HttpRequest 생성
	            HttpRequest httpRequest = HttpRequest.newBuilder()
	                    .uri(uri)
	                    .header("accept", "*/*")
	                    .build();

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
	
	
	

}
