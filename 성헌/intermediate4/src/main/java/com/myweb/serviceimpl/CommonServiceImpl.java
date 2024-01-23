package com.myweb.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MoveDTO;
import com.myweb.dto.ReplyDTO;
import com.myweb.mybatis.mapper.AdminNoticeMapper;
import com.myweb.mybatis.mapper.CommonMapper;
import com.myweb.mybatis.mapper.QnaMapper;
import com.myweb.service.AdminNoticeService;
import com.myweb.service.CommonService;
import com.myweb.service.QnaService;

import edu.emory.mathcs.backport.java.util.Arrays;

@Service("CommonServiceImpl")
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	CommonMapper admin;
	
@Override
	
	public String upload(String category, MultipartFile file, HttpSession session) {
		//서버의 업로드할 물리적 위치
		// workspace/.metadata/....../wtpwebapps/iot/resources
		String resources = session.getServletContext().getRealPath("resources");
		String upload = resources + "/upload";
		
		//업로드할 파일의 형태 : .../upload/notice/2020/07/13/abc.txt
		//String folder = upload + "/upload/2020/07/13";
		String folder = upload + "/" + category + "/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		
		//폴더가 없다면 폴더를 생성
		File f = new File(folder);
		if(!f.exists()) { f.mkdirs(); } //폴더가 존재하지 않으면 경로 생성
		
		//동시 다발적 동일명의 파일 업로드를 위한 고유 ID 부여: afd324adfa_abc.txt
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		try {
			file.transferTo( new File(folder, uuid) );
		} catch (Exception e) {
			System.out.println(e.getMessage());		
		}
		
		// /upload/.../asdfadsfsa_abc.txt ▶ 업로드한 파일의 경로를 반환
		// ① folder.replace(resources, "")
		// ② folder.substring(resources.length()) + "/" + uuid;
		return folder.substring(resources.length()) + "/" + uuid;
	}

//첨부 파일 다운로드 처리///////////////////////////////////////////////////////
	public ResponseEntity<byte[]> download(String fileName, String filePath, HttpSession session, HttpServletResponse response) throws Exception {
		
	      
		System.out.println("하위 2"); 
		
		
	      File file = new File(filePath + fileName);
	       byte[] fileContent = Files.readAllBytes(file.toPath());
	      
	       System.out.println("fileContent 2" + Arrays.toString(fileContent)); 
	    
	       
	      
	       HttpHeaders headers = new HttpHeaders();
	       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

	       String encodedFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
	       headers.setContentDispositionFormData("attachment", encodedFileName);

	       return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);

	       
	       
	       String encodedFileContent = new String(fileContnet.getBytes("UTF-8"), "ISO-8859-1");
			
			
		   String content = new String(fileContnet., StandardCharsets.UTF_8);
	     
		   
		   
		   System.out.println("File Content: " + content);
	       
	       
		
		
	}





	


	
}
