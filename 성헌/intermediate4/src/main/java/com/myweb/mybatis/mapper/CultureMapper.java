package com.myweb.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.CultureDTO;

@Mapper
public interface CultureMapper {

	public List<CultureDTO> getCultureList();	
	public List<CultureDTO> getCulNameList();	
	public int getCulturetotalCount(String search);	
	public List<String> getCulturePaging(Map<String, Object> map);	
	
	public CultureDTO getCulNameSelec(String name);	
	

}
