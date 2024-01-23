package com.myweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myweb.dto.ImgDTO;
import com.myweb.dto.TestDTO;

public interface IImgService {

	List<ImgDTO> getImgList(String name);
	String getImgone(String name);
	

}
