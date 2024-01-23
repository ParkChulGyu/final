package com.myweb.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.HotelDTO;
import com.myweb.mybatis.mapper.HotelMapper;
import com.myweb.service.IHotelService;

@Service("HotelMybatisMapperServiceImpl")
public class HotelMybatisMapperServiceImpl implements IHotelService{
	
	@Autowired
	HotelMapper dao;


	@Override
	public List<HotelDTO> getHotelList() {
		
		return dao.getHotelList();
	}
	@Override
	public List<HotelDTO> getHotelNmaeList() {
		
		return dao.getHotelNmaeList();
	}
	@Override
	public int getHoteltotalCount(String search) {
		// TODO Auto-generated method stub
		return dao.getHoteltotalCount(search);
	}
	@Override
	public List<String> getHotelPaging(Map<String, Object> pstr) {
		// TODO Auto-generated method stub
		return dao.getHotelPaging(pstr);
	}
	@Override
	public HotelDTO getHotelNameSelec(String name) {
		// TODO Auto-generated method stub
		return dao.getHotelNameSelec(name);
	}

}
