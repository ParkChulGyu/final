package com.example.demo.api;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.ui.Model;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/plan")
public class PlanController {

	private final OpenApiManager openApiManager;
	private final ApiSearchBlog apisearchblog;
	

//	@GetMapping("result")
//	public String result(Model model) throws Exception {
//
//		List<placeDTO> tests = openApiController.fetchAll();
//		String Contentid;
//		String overview;
//		System.out.println("몇개 오는 지 확인 해보자   : " + tests.size());
//
//		for (placeDTO test : tests) {
//			Contentid = test.getContentid();
//			overview = openApiController.fetchOne(Contentid);
//			test.setOverview(overview);
//
//			System.out.println("한 번 체 크 해 보 자 : " + test.getCat3());
//
//			// planService.create(test);
//		}
//
////	    	model.addAttribute("responseData", tests);
//
//		return "qna/test";
//	}

	
	@ResponseBody
	@GetMapping("call_list_box")
	public List<list_boxDTO> call_list_box(@RequestParam(value="city_lat") String city_lat,@RequestParam(value="city_lng") String city_lng) throws Exception {
		//위치기반 관광정보조회
		List<list_boxDTO> list_box = openApiManager.xy_call(city_lat,city_lng);
		
		
		return list_box;
	}
	@ResponseBody
	@GetMapping("search_blog")
	public List<search_blogDTO> search_blog(@RequestParam(value="title") String title) throws Exception {
		//위치기반 관광정보조회
		
		List<search_blogDTO> list_box = apisearchblog.main(title);
		
		return list_box;
	}
	
	@ResponseBody
	@GetMapping("detail")
	public list_boxDTO detail(@RequestParam(value="contentid") String contentid) throws Exception {
		//위치기반 관광정보조회
		list_boxDTO box = openApiManager.detail_call(contentid);
		
		
		return box;
	}

	@ResponseBody
	@GetMapping("contenttype_id")
	public List<list_boxDTO> contenttype_id(@RequestParam(value="areaCode") String areaCode,@RequestParam(value="contenttype_id") String contenttype_id) throws Exception {
		//위치기반 관광정보조회
		List<list_boxDTO> list_box = openApiManager.location_contenttype_call(areaCode,contenttype_id);
		
		
		return list_box;
	}
	@ResponseBody
	@GetMapping("cat3")
	public List<list_boxDTO> cat3(@RequestParam(value="cat3") String cat3,@RequestParam(value="areaCode") String areaCode,@RequestParam(value="contenttype_id") String contenttype_id) throws Exception {
		//위치기반 관광정보조회
		List<list_boxDTO> list_box = openApiManager.location_cat3_call(cat3,areaCode,contenttype_id);
		
		
		return list_box;
	}
	
	
	@ResponseBody
	@GetMapping("searchKeyword")
	public List<list_boxDTO> searchKeyword(@RequestParam(value="keyword") String keyword) throws Exception {
		//위치기반 관광정보조회
		List<list_boxDTO> list_box = openApiManager.searchKeyword(keyword);
		
		
		return list_box;
	}
	
	
	
	
	
	
	@GetMapping("plan_day")
	public String plan_day() {
			
		return "plan/plan_day";
	}

	
	
	
	@ResponseBody
	@GetMapping("plan_location_ajax")
	public Map<String, Object> plan_location_ajax(@RequestParam(value="start") String start,
													@RequestParam(value="end") String end,@RequestParam(value="locations_day")  String locations_day,@RequestParam(value="locations_where")  String locations_where) throws Exception {
		
		
		
		List<String> list = new ArrayList<>();
		List<String> list_int = new ArrayList<>();

        // 정규 표현식을 사용하여 문자열에서 도시 이름을 추출
        Pattern pattern = Pattern.compile("\\b[가-힣]+\\b");
        Pattern patterns = Pattern.compile("\\b[1-9]+\\b");
        Matcher matcher = pattern.matcher(locations_where);
        Matcher matcher_int = patterns.matcher(locations_day);

        // 매칭된 각 도시 이름을 리스트에 추가
        while (matcher.find()) {
            list.add(matcher.group());
           // resultBuilder.append(matcher_int.group()).append(" ");
             
        }
        while (matcher_int.find()) {
        	list_int.add(matcher_int.group());
        	
        }
		
        
        
        
        
		
		
		Map<String, Object> response = new HashMap<>();
		response.put("start", start);
		response.put("end", end);
		response.put("list", list);
		response.put("list_int", list_int);
		
		return response;
	}
	
	
	
	
	
	
	@GetMapping("plan_location")
	public String plan_location(Model model,@RequestParam(value="start") String start,
			@RequestParam(value="end") String end,@RequestParam(value="locations_where")  ArrayList<String> locations_where,
			@RequestParam(value="locations_day")  ArrayList<String> locations_day,
			@RequestParam(value="lattis")  ArrayList<String> lattis,
			@RequestParam(value="lngis")  ArrayList<String> lngis) {
		
		List<set_dayDTO> set_daylist = new ArrayList<>();
		System.out.println(locations_where);
			
		for (int i = 0; i < locations_where.size(); i++) {
				
				set_dayDTO set_day = new set_dayDTO();
				set_day.setDay(locations_day.get(i));
				set_day.setLocation(locations_where.get(i));
				set_day.setLat(lattis.get(i));
				set_day.setLng(lngis.get(i));
				set_daylist.add(set_day);
				
			}
			
			
			
		model.addAttribute("set_daylist",set_daylist);
		model.addAttribute("end",end);
		model.addAttribute("start",start);
		
			
		return "plan/plan_location";
	}
	

	

}
