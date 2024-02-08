package com.example.demo.api.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.answer.AnswerForm;
import com.example.demo.api.ApiProperties;
import com.example.demo.api.configuration.PagingDTO;
import com.example.demo.api.model.TourService;
import com.example.demo.api.model.TouristDTO;
import com.example.demo.user.SiteUser;
import com.example.demo.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api")
public class FlaskJsonController {

	@Autowired
	TourService t_service = new TourService();
	
	
	@Autowired
	PagingDTO pagingDTO = new PagingDTO();
	
	Map<String, Object> map = new HashMap();
	
	@ResponseBody 
	@GetMapping("/updateList")
	public String updateList(@RequestParam(name = "contentTypeId") String contentTypeId
			, @RequestParam(value="pageNo", defaultValue="1") String pageNo
			, @RequestParam(value="listNum", defaultValue="6") String listNum
			, @RequestParam(value="blockNum", defaultValue="10") String blockNum
			, @RequestParam(value="totalCount", defaultValue="0") String totalCount
			, @RequestParam(value = "keyword", defaultValue = "_") String keyword
								) throws JsonProcessingException {
		
		
		//  파라미터 값 확인 사용
//		System.out.println("Received contentTypeId: " + contentTypeId);
//		System.out.println("Received pageno: " + pageNo);
//		System.out.println("Received listNum: " + listNum);
//		System.out.println("Received blockNum: " + blockNum);
//		System.out.println("Received totalCount: " + totalCount);
//		System.out.println("Received keyword: " + keyword);
		
		// 여기에서 원하는 작업 수행
		
		//카테고리 리스트
		// 토탈 카운트 받기
//		List<TouristDTO> touristDTOList = t_service.fetchDataFromExternalAPI(contentTypeId);
		map = t_service.fetchDataFromExternalAPI(map);
		
		map.put("contentTypeId", contentTypeId);
		map.put("pageNo", pageNo);
		map.put("numOfRows", listNum);
		map.put("keyword", keyword);
		
		//System.out.println(touristDTOList);
		System.out.println("map.get totalCount : "+map.get("totalCount"));
		
		// 페이징 값 세팅
		
		if (!(map.get("totalCount") == null))totalCount = (String)(map.get("totalCount"));
		
		pagingDTO.setPageNo(Integer.parseInt(pageNo));
		pagingDTO.setListNum(Integer.parseInt(listNum));
		pagingDTO.setBlockNum(Integer.parseInt(blockNum));
		pagingDTO.setTotalCount(Integer.parseInt(totalCount));
		
		pagingDTO.setPaging();
		
//		System.out.println("너왜 30이 나오냐"+pagingDTO.getEnd_rownum());
//		System.out.println(pagingDTO.getEndPage());
//		System.out.println(pagingDTO.getStartPage());
		
		map.put("pagingDTO", pagingDTO);
		
		//ajex 에 값 보내기
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResult = objectMapper.writeValueAsString(map);

		//System.out.println("jsonResult"+jsonResult);
		return jsonResult;
	}

}
