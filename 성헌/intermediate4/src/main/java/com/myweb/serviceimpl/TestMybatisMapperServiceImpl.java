package com.myweb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.TestDTO;
import com.myweb.mybatis.mapper.TestMapper;
import com.myweb.service.ITestService;

@Service("TestMybatisMapperServiceImpl")
public class TestMybatisMapperServiceImpl implements ITestService{
	
	@Autowired
	TestMapper dao;


	@Override
	public List<TestDTO> getTestList() {
		
		return dao.getTestList();
	}

}
