package com.myweb.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.CultureDTO;
import com.myweb.dto.HotelDTO;
import com.myweb.dto.TourDTO;

@Mapper
public interface TourMapper {

	public List<TourDTO> getTourList();	
	public List<TourDTO> getTourNameList();	
	public int getTourtotalCount(String search);	
	public List<String> getTourPaging(Map<String, Object> map);	
	
	public TourDTO getTourNameSelec(String name);	
	

}
