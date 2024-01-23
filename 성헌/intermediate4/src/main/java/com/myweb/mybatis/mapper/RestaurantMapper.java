package com.myweb.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.HotelDTO;
import com.myweb.dto.RestaurantDTO;

@Mapper
public interface RestaurantMapper {

	public List<RestaurantDTO> getRestaurantList();	
	public List<RestaurantDTO> getResNameList();	
	public int getRestotalCount(String search);	
	public List<String> getResPaging(Map<String, Object> map);	
	
	public RestaurantDTO getResNameSelec(String name);	
	

}
