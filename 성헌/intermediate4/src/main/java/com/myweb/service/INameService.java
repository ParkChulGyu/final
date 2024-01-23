package com.myweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.CultureDTO;
import com.myweb.dto.NameDTO;

public interface INameService {

	public List<NameDTO> getHomeRand();
	public int getNametotalCount(Map<String, String> map);	
	public List<NameDTO> getNamePaging(Map<String, Object> map);
		

}
