package com.example.demo.api;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
	
    private final String apiUri = "/areaBasedList1";
    private final String serviceKey2 ="%2BQYAKoWIGdnlk7%2BVvmY7rlSQ5e%2FAmCPo9zZzsqXnPvqlVVxL3BYkrnE2scXxduZ8pJzcBS81z%2BC6WwX5VGVGgA%3D%3D";
    private final String serviceKey = "?serviceKey=";
//    private final String defaultQueryParam = "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
//    private final String listYN = "&listYN=Y";
//    private final String arrange = "&arrange=A";
//    private final String areaCode = "&areaCode=6";
//    private final String sigunguCode = "&sigunguCode=";
//    
//    private final String cat1 =	"&cat1=A05";
//    private final String cat2 = "&cat2=A0502";
//    private final String cat3 = "&cat3=";
 //   private final String keyword = "&keyword=강원";

    
    
    
//    private final String apidetailUri = "/detailCommon1";
//    private final String defaultdetailParam = "&MobileOS=ETC&MobileApp=AppTest&_type=json";
 //   private final String contentId = "&contentId=2707041";
//    private final String overviewYN = "&overviewYN=Y";

    
    
  
    
//    private String makeUrlareaBasedList() throws UnsupportedEncodingException {
//        //지역 기반
//    	return BASE_URL +
//                apiUri +
//                serviceKey +
//                serviceKey2 +
//                defaultQueryParam +
//                listYN +
//                arrange +
//                areaCode+
//                sigunguCode+
//                cat1+
//                cat2+
//                cat3;
//            //    keyword +
//              
//    }
    
//    private String makeUrldetailCommon(String Contentid) throws UnsupportedEncodingException {
//     
//    	String contentId = "&contentId=" + Contentid;
//    	
//    	
//    	return BASE_URL +
//        		apidetailUri +
//                serviceKey +
//                serviceKey2 +
//                defaultdetailParam +
//                contentId +
//                overviewYN;
//            //    keyword +
//              
//    }
    
    
    

//    public List<placeDTO> fetchAll() throws UnsupportedEncodingException, ParseException, MalformedURLException, URISyntaxException {
//        System.out.println(makeUrlareaBasedList());
//       
//       
//        URL url = new URL(makeUrlareaBasedList());
//        URI uri = url.toURI();
//        RestTemplate restTemplate = new RestTemplate();
//      
//		String jsonString = restTemplate.getForObject(uri, String.class);
//
//        System.out.println(jsonString);
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
//        // items는 JSON임, 이제 그걸 또 배열로 가져온다
//        JSONArray jsonItemList = (JSONArray) jsonItems.get("item");
//
//        	System.out.println("json아 오니?" + jsonItemList);
//        
//        List<placeDTO> result = new ArrayList<>();
//        
//        for (Object o : jsonItemList) {
//            JSONObject item = (JSONObject) o;
//          
//            
//            result.add(makeLocationDto(item));
//        }
//        
//        
//        return result;
//        
//    }
    
    
    
    public List<list_boxDTO> xy_call(String city_lat, String city_lng) throws Exception {
    	String api_Uri_xy = "/locationBasedList1";
    	String default_xy = "&numOfRows=10&pageNo=2&MobileOS=ETC&MobileApp=AppTest&_type=json";
    	
    	URL url = new URL(BASE_URL+api_Uri_xy+serviceKey+serviceKey2+default_xy+"&listYN=Y&arrange=A&mapX="+city_lng+"&mapY="+city_lat+"&radius=10000&contentTypeId=");
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
            JSONObject item = (JSONObject) o;
            System.out.println("너 왜 3개 와? " + item);
            
            list_box.add(makexyDTO(item));
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
    
    
    
    private list_boxDTO makexyDTO(JSONObject item) {
    	list_boxDTO dto = list_boxDTO.builder().
    			
    	//		addr1((String) item.get("addr1")).
    	//		addr2((String) item.get("addr2")).
    //			areacode((String) item.get("areacode")).
    	//		cat1((String) item.get("cat1")).
    			cat2((String) item.get("cat2")).
    			cat3((String) item.get("cat3")).
    //			contentid((String) item.get("contentid")).
    //			contenttypeid((String) item.get("contenttypeid")).
    			firstimage((String) item.get("firstimage")).
    //			firstimage2((String) item.get("firstimage2")).
    //			mapx((String) item.get("mapx")).
    //			mapy((String) item.get("mapy")).
    //			mlevel((String) item.get("mlevel")).
    //			tel((String) item.get("tel")).
    			title((String) item.get("title")).
    			build();
    	return dto;
    }
   
    
    

}
