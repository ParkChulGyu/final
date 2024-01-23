package com.myweb.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.CartDTO;
import com.myweb.dto.HotelDTO;
import com.myweb.dto.TourDTO;
import com.myweb.mybatis.mapper.CartMapper;
import com.myweb.mybatis.mapper.TourMapper;
import com.myweb.service.ICartService;
import com.myweb.service.ITourService;

@Service("CartMybatisMapperServiceImpl")
public class CartMybatisMapperServiceImpl implements ICartService{
	
	@Autowired
	CartMapper dao;

	@Override
	public int getCarttotalCount(Map<String, Object> map) {
		return dao.getCarttotalCount(map);
	}

	@Override
	public List<CartDTO> getCartPaging(Map<String, Object> map) {
		return dao.getCartPaging(map);
	}
	
	@Override
	public int getLike(Map<String, Object> map) {
		return dao.getLike(map);
	}

	@Override
	public int insertCart(Map<String, Object> map) {
		return dao.insertCart(map);
	}

	@Override
	public int deleteCart(Map<String, Object> map) {
		return dao.deleteCart(map);
	}

	

}
