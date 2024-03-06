package com.example.demo.api;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenApiManager {
	private final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1";
//    private final String apiUri = "/searchKeyword1";
	
    private final String serviceKey2 ="%2BQYAKoWIGdnlk7%2BVvmY7rlSQ5e%2FAmCPo9zZzsqXnPvqlVVxL3BYkrnE2scXxduZ8pJzcBS81z%2BC6WwX5VGVGgA%3D%3D";
    private final String serviceKey = "?serviceKey=";

    
    
    
    public List<list_boxDTO> xy_call(String city_lat, String city_lng,String check_call_Num) throws Exception {
    	String api_Uri_xy = "/locationBasedList1";
    	String default_xy = "&numOfRows=10&pageNo="+check_call_Num+"&MobileOS=ETC&MobileApp=AppTest&_type=json";
    	
    	URL url = new URL(BASE_URL+api_Uri_xy+serviceKey+serviceKey2+default_xy+"&listYN=Y&arrange=O&mapX="+city_lng+"&mapY="+city_lat+"&radius=10000&contentTypeId=");
    
    	URI uri = url.toURI();
   
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String jsonString = restTemplate.getForObject(uri, String.class);
    	
    	
    	JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
        // 가장 큰 JSON 객체 response 가져오기
        JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
        JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
        // 그 다음 body 부분 파싱

        // 그 다음 위치 정보를 배열로 담은 items 파싱
        JSONObject jsonItems = (JSONObject) jsonBody.get("items");

        // items는 JSON임, 이제 그걸 또 배열로 가져온다
        JSONArray jsonItemList = (JSONArray) jsonItems.get("item");
        	
        
        	List<list_boxDTO> list_box = new ArrayList<>();        
        	

        	
        	for (Object o : jsonItemList) {
        		list_boxDTO dto = new list_boxDTO();
            JSONObject item = (JSONObject) o;
            dto.setCat2((String) item.get("cat2"));
			dto.setCat3((String) item.get("cat3"));
			dto.setTitle((String) item.get("title"));
			dto.setFirstimage((String) item.get("firstimage"));
			dto.setMapx((String) item.get("mapx"));
			dto.setMapy((String) item.get("mapy"));
			dto.setContentid((String) item.get("contentid"));
			dto.setContenttypeid((String) item.get("contenttypeid"));
			
            
			list_box.add(dto);
        }
    	
    	
    	
    	
    	
    	
    	return list_box;
    }
    
    
    public list_boxDTO detail_call(String contentid) throws Exception {
    	String api_Uri_detail = "/detailCommon1";
    	String default_detail = "&MobileOS=ETC&MobileApp=AppTest&_type=json";
    	
    	URL url = new URL(BASE_URL+api_Uri_detail+serviceKey+serviceKey2+default_detail+"&contentId="+contentid+"&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&numOfRows=1&pageNo=1");
    	
    	URI uri = url.toURI();
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String jsonString = restTemplate.getForObject(uri, String.class);
    	
    	
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
    	// 가장 큰 JSON 객체 response 가져오기
    	JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
    	
    	// 그 다음 body 부분 파싱
    	JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
    	
    	// 그 다음 위치 정보를 배열로 담은 items 파싱
    	JSONObject jsonItems = (JSONObject) jsonBody.get("items");
    	
    	// items는 JSON임, 이제 그걸 또 배열로 가져온다
    	JSONArray jsonItemList = (JSONArray) jsonItems.get("item");
    	
    	
    	
    	list_boxDTO dto = new list_boxDTO();
    	for (Object o : jsonItemList) {
    		JSONObject item = (JSONObject) o;
    		dto.setCat2((String) item.get("cat2"));
    		dto.setCat3((String) item.get("cat3"));
    		dto.setTitle((String) item.get("title"));
    		dto.setFirstimage((String) item.get("firstimage"));
    		dto.setMapx((String) item.get("mapx"));
    		dto.setMapy((String) item.get("mapy"));
    		dto.setAddr1((String) item.get("addr1"));
    		dto.setAddr2((String) item.get("addr2"));
    		dto.setHomepage((String) item.get("homepage"));
    		dto.setContentid((String) item.get("contentid"));
    		dto.setOverview((String) item.get("overview"));
    		dto.setContenttypeid((String) item.get("contenttypeid"));
    		
    	}
    	
    	
    	return dto;
    }
    
    
    public List<list_boxDTO> location_contenttype_call(String areaCode, String contenttype_id,String check_call_Num) throws Exception {
    	String api_Uri_location = "/areaBasedList1";
    	String default_location = "&numOfRows=10&pageNo="+check_call_Num+"&MobileOS=ETC&MobileApp=AppTest&_type=json";
    	
    	URL url = new URL(BASE_URL+api_Uri_location+serviceKey+serviceKey2+default_location+"&listYN=Y&arrange=O&contentTypeId="+contenttype_id+"&areaCode="+areaCode+"");
    	System.out.println(url); 
    	
    	URI uri = url.toURI();
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String jsonString = restTemplate.getForObject(uri, String.class);
    	
    	
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
    	// 가장 큰 JSON 객체 response 가져오기
    	JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
    	
    	// 그 다음 body 부분 파싱
    	JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
    	
    	// 그 다음 위치 정보를 배열로 담은 items 파싱
    	JSONObject jsonItems = (JSONObject) jsonBody.get("items");
    	
    	// items는 JSON임, 이제 그걸 또 배열로 가져온다
    	JSONArray jsonItemList = (JSONArray) jsonItems.get("item");
    	
    	
    	List<list_boxDTO> list_box = new ArrayList<>();        
    	
    	for (Object o : jsonItemList) {
    		list_boxDTO dto = new list_boxDTO();
    		JSONObject item = (JSONObject) o;
    		dto.setCat2((String) item.get("cat2"));
    		dto.setCat3((String) item.get("cat3"));
    		dto.setTitle((String) item.get("title"));
    		dto.setFirstimage((String) item.get("firstimage"));
    		dto.setMapx((String) item.get("mapx"));
    		dto.setMapy((String) item.get("mapy"));
    		dto.setContentid((String) item.get("contentid"));
    		dto.setContenttypeid((String) item.get("contenttypeid"));
    		
    		list_box.add(dto);
    	}
    	
    	
    	
    	
    	
    	
    	return list_box;
    }
    public List<list_boxDTO> location_cat3_call(String cat3, String areaCode,String contenttype_id,String check_call_Num) throws Exception {
    	String api_Uri_location = "/areaBasedList1";
    	String default_location = "&numOfRows=10&pageNo="+check_call_Num+"&MobileOS=ETC&MobileApp=AppTest&_type=json";
   
    	URL url = new URL(BASE_URL+api_Uri_location+serviceKey+serviceKey2+default_location+"&listYN=Y&arrange=O&contentTypeId="+contenttype_id+"&areaCode="+areaCode+""+"&cat3="+cat3+"");
    	URI uri = url.toURI();
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String jsonString = restTemplate.getForObject(uri, String.class);
    	
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
    	// 가장 큰 JSON 객체 response 가져오기
    	JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
    	
    	// 그 다음 body 부분 파싱
    	JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
    	
    	// 그 다음 위치 정보를 배열로 담은 items 파싱
    	JSONObject jsonItems = (JSONObject) jsonBody.get("items");
    	
    	// items는 JSON임, 이제 그걸 또 배열로 가져온다
    	JSONArray jsonItemList = (JSONArray) jsonItems.get("item");
    	
    	
    	List<list_boxDTO> list_box = new ArrayList<>();        
    	
    	for (Object o : jsonItemList) {
    		list_boxDTO dto = new list_boxDTO();
    		JSONObject item = (JSONObject) o;
    		dto.setCat2((String) item.get("cat2"));
    		dto.setCat3((String) item.get("cat3"));
    		dto.setTitle((String) item.get("title"));
    		dto.setFirstimage((String) item.get("firstimage"));
    		dto.setMapx((String) item.get("mapx"));
    		dto.setMapy((String) item.get("mapy"));
    		dto.setContentid((String) item.get("contentid"));
    		dto.setContenttypeid((String) item.get("contenttypeid"));
    		
    		list_box.add(dto);
    	}
    	
    	
    	
    	
    	
    	
    	return list_box;
    }
    public List<list_boxDTO> searchKeyword(String keyword) throws Exception {
    	String api_Uri_Keyword = "/searchKeyword1";
    	String default_Keyword = "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=O";
    	String encodedString = URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString());
    	System.out.println("encodedString" + encodedString);
    	URL url = new URL(BASE_URL+api_Uri_Keyword+serviceKey+serviceKey2+default_Keyword+"&keyword="+encodedString+"");
    	System.out.println(url); 
    	
    	URI uri = url.toURI();
    	RestTemplate restTemplate = new RestTemplate();
     	System.out.println(uri); 
    	String jsonString = restTemplate.getForObject(uri, String.class);
    	
    	
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
    	// 가장 큰 JSON 객체 response 가져오기
    	JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
    	
    	// 그 다음 body 부분 파싱
    	JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
    	
    	// 그 다음 위치 정보를 배열로 담은 items 파싱
    	JSONObject jsonItems = (JSONObject) jsonBody.get("items");
    	
    	// items는 JSON임, 이제 그걸 또 배열로 가져온다
    	JSONArray jsonItemList = (JSONArray) jsonItems.get("item");
    	
    	
    	List<list_boxDTO> list_box = new ArrayList<>();        
    	
    	for (Object o : jsonItemList) {
    		list_boxDTO dto = new list_boxDTO();
    		JSONObject item = (JSONObject) o;
    		dto.setCat2((String) item.get("cat2"));
    		dto.setCat3((String) item.get("cat3"));
    		dto.setTitle((String) item.get("title"));
    		dto.setFirstimage((String) item.get("firstimage"));
    		dto.setMapx((String) item.get("mapx"));
    		dto.setMapy((String) item.get("mapy"));
    		dto.setContentid((String) item.get("contentid"));
    		dto.setContenttypeid((String) item.get("contenttypeid"));
    		
    		list_box.add(dto);
    	}
    	
    	
    	
    	
    	
    	
    	return list_box;
    }
    
    
    
    





//    public String fetchOne(String Contentid) throws Exception {
//        System.out.println(makeUrldetailCommon(Contentid));
//
//
//        
//        
//        RestTemplate restTemplate = new RestTemplate();
//        
//        URL url = new URL(makeUrldetailCommon(Contentid));
//        URI uri = url.toURI();
//        
//        
//        String jsonString = restTemplate.getForObject(uri, String.class);
//        JSONParser jsonParser = new JSONParser();
//        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
//        // 가장 큰 JSON 객체 response 가져오기
//        JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
//
//        // 그 다음 body 부분 파싱
//        JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
//
//        // 그 다음 위치 정보를 배열로 담은 items 파싱
//        JSONObject jsonItems = (JSONObject) jsonBody.get("items");
//        
//        
//        JSONArray jsonItem = (JSONArray) jsonItems.get("item");
//        
//     
//
//        
//        
//        String overview = null;
//        for (Object o : jsonItem) {
//            JSONObject item = (JSONObject) o;
//          
//            overview = item.get("overview").toString();
//        }
//        
//        
//      
//           
//        return overview;
//        
//    }
    
    
    
    
    
    
    
    
    
//    private placeDTO makeLocationDto(JSONObject item) {
//    	placeDTO dto = placeDTO.builder().
//    			
//                title((String) item.get("title")).
//                addr1((String) item.get("addr1")).
//                addr2((String) item.get("addr2")).
//                cat1((String) item.get("cat1")).
//                cat2((String) item.get("cat2")).
//                cat3((String) item.get("cat3")).
//                contentid((String) item.get("contentid")).
//                firstimage((String) item.get("firstimage")).
//                firstimage2((String) item.get("firstimage2")).
//                mapx((String) item.get("mapx")).
//                mapy((String) item.get("mapy")).
//                build();
//        return dto;
//    }
    
    
   



   
    
    

}
