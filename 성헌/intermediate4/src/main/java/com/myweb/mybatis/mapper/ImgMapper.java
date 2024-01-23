package com.myweb.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.ImgDTO;

@Mapper
public interface ImgMapper {

	public List<ImgDTO> getImgList(String name);	
	public String getImgone(String name);	

	

}
