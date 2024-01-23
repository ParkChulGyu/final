package com.myweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.CultureDTO;
import com.myweb.dto.HotelDTO;
import com.myweb.dto.TourDTO;

public interface ITourService {

	List<TourDTO> getTourList();
	List<TourDTO> getTourNameList();
	public int getTourtotalCount(String search);	
	public List<String> getTourPaging(Map<String, Object> pstr);	

	
	public TourDTO getTourNameSelec(String name);
	
	
}
