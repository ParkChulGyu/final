package com.myweb.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.CultureDTO;
import com.myweb.dto.HotelDTO;
import com.myweb.dto.NameDTO;
import com.myweb.dto.TourDTO;

@Mapper
public interface NameMapper {

	public int getNametotalCount(Map<String, String> map);	
	public List<NameDTO> getNamePaging(Map<String, Object> map);
	public List<NameDTO> getHomeRand();	
	
	

}
