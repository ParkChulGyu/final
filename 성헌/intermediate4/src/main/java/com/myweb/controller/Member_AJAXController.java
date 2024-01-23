package com.myweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.dto.MemberDTO;
import com.myweb.service.IMemberService;

@RestController
@RequestMapping("member")
public class Member_AJAXController {

	

	@Autowired
	@Qualifier("memberMybatisMapperServiceImpl")
	IMemberService service;
	
	
		
	@GetMapping("memberListJson")
	public Map<String, Object> memberListJson() {
		System.out.println("memberListJson");
		
		List<MemberDTO> list = service.getMemberList();		
		Map<String, Object> map = new HashMap<String, Object>();
		if(list.size() != 0) {
			map.put("rs", list);
		}else {
			map.put("rs","0");			
		}
		
		return map;
		
	}
	
}
