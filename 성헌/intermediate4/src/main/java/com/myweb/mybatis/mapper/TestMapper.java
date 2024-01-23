package com.myweb.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.TestDTO;

@Mapper
public interface TestMapper {

	public List<TestDTO> getTestList();	
	
	

}
