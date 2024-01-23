package com.myweb.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.CultureDTO;
import com.myweb.mybatis.mapper.CultureMapper;
import com.myweb.service.ICultureService;

@Service("CultureMybatisMapperServiceImpl")
public class CultureMybatisMapperServiceImpl implements ICultureService{
	
	@Autowired
	CultureMapper dao;


	@Override
	public List<CultureDTO> getCultureList() {
		return dao.getCultureList();
	}
	@Override
	public List<CultureDTO> getCulNameList() {
		return dao.getCulNameList();
	}
	
	
	@Override
	public int getCulturetotalCount(String search) {
		return dao.getCulturetotalCount(search);
	}
	
	@Override
	public List<String> getCulturePaging(Map<String, Object> map) {
		return dao.getCulturePaging(map);
	}
	@Override
	public CultureDTO getCulNameSelec(String name) {
		// TODO Auto-generated method stub
		return dao.getCulNameSelec(name);
	}
	
	
	

}
