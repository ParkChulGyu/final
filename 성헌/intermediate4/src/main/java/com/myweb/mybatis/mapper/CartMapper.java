package com.myweb.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.CartDTO;
import com.myweb.dto.CultureDTO;

@Mapper
public interface CartMapper {

	public int getCarttotalCount(Map<String, Object> map);	
	public List<CartDTO> getCartPaging(Map<String, Object> map);	
	public int getLike(Map<String, Object> map);	
	
	public int insertCart(Map<String, Object> map);	
	public int deleteCart(Map<String, Object> map);	
	

}
