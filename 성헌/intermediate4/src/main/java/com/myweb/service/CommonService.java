package com.myweb.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.MoveDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.ReplyDTO;




public interface CommonService {
	
	
	String upload(String category, MultipartFile file, HttpSession session);
	
	
	
	public ResponseEntity<byte[]> download(String filename, String filepath, HttpSession session, HttpServletResponse response) throws Exception;
	
}
