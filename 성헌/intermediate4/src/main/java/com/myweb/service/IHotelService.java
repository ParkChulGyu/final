package com.myweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.HotelDTO;
import com.myweb.dto.TestDTO;

public interface IHotelService {

	List<HotelDTO> getHotelList();
	List<HotelDTO> getHotelNmaeList();
	public int getHoteltotalCount(String search);	
	public List<String> getHotelPaging(Map<String, Object> pstr);
	
	public HotelDTO getHotelNameSelec(String name);	

}
