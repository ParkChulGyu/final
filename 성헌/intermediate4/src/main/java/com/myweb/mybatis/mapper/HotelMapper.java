package com.myweb.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.CultureDTO;
import com.myweb.dto.HotelDTO;

@Mapper
public interface HotelMapper {

	public List<HotelDTO> getHotelList();	
	public List<HotelDTO> getHotelNmaeList();	
	public int getHoteltotalCount(String search);	
	public List<String> getHotelPaging(Map<String, Object> map);	
	
	public HotelDTO getHotelNameSelec(String name);	
	
	

}
