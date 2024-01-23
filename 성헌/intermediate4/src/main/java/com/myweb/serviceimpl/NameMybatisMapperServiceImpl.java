package com.myweb.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.NameDTO;
import com.myweb.mybatis.mapper.NameMapper;
import com.myweb.service.INameService;

@Service("NameMybatisMapperServiceImpl")
public class NameMybatisMapperServiceImpl implements INameService{
	
	@Autowired
	NameMapper dao;

	@Override
	public int getNametotalCount(Map<String, String> map) {
		return dao.getNametotalCount(map);
	}

	@Override
	public List<NameDTO> getNamePaging(Map<String, Object> map) {
		return dao.getNamePaging(map);
	}

	@Override
	public List<NameDTO> getHomeRand() {
		return dao.getHomeRand();
	}


	
	
	

}
