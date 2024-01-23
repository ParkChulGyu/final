package com.myweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.CultureDTO;

public interface ICultureService {

	List<CultureDTO> getCultureList();
	List<CultureDTO> getCulNameList();
	public int getCulturetotalCount(String search);	
	public List<String> getCulturePaging(Map<String, Object> pstr);	
	
	public CultureDTO getCulNameSelec(String name);	
	

}
