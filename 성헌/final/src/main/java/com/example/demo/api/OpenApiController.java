package com.example.demo.api;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class OpenApiController {
	
	 private final OpenApiManager openApiManager;

//	    @GetMapping("open-api")
//	    public List<placeDTO> fetchAll() throws UnsupportedEncodingException, ParseException,MalformedURLException, URISyntaxException {
//	       
//	    	
//	    	return  openApiManager.fetchAll();
//	    }
//		
//	    
//	    @GetMapping("open")
//	    public String fetchOne(String Contentid) throws Exception {
//	       
//	    	
//	    	return  openApiManager.fetchOne(Contentid);
//	    }
//	
	    
	    public List<list_boxDTO> xy_call(String city_lat, String city_lng) throws Exception {
	    	
	    	
	    	return  openApiManager.xy_call(city_lat,city_lng);
	    }
	
	
	
	
	
	
	
	
	
}
