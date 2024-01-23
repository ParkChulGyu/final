package com.myweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.RestaurantDTO;
import com.myweb.dto.TestDTO;

public interface IRestaurantService {

	List<RestaurantDTO> getRestaurantList();
	List<RestaurantDTO> getResNameList();
	public int getRestotalCount(String search);	
	public List<String> getResPaging(Map<String, Object> pstr);
	
	public RestaurantDTO getResNameSelec(String name);	

}
