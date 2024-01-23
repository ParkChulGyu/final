package com.myweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.CartDTO;
import com.myweb.dto.CultureDTO;
import com.myweb.dto.HotelDTO;
import com.myweb.dto.TourDTO;

public interface ICartService {

	public int getCarttotalCount(Map<String, Object> map);	
	public List<CartDTO> getCartPaging(Map<String, Object> map);	
	public int getLike(Map<String, Object> map);	
	
	public int insertCart(Map<String, Object> map);	
	public int deleteCart(Map<String, Object> map);	
	
}
