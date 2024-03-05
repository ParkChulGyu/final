package com.example.demo.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import java.net.URLEncoder;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import java.io.UnsupportedEncodingException;



@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

	 private final FileService fileService;
	 
	 private final QuestionService questionService;
	 
	 private final FileUtils fileUtils;

	    // 파일 리스트 조회
	    @GetMapping("/posts")
	    public List<FileRequest> findAllFileByPostId(@RequestParam(value="postId") Integer postId ) {
	    	Question question = this.questionService.getQuestion(postId);
	    	
	    	return fileService.findAllFilesByIds(question);
	    }
	    
	    
	 // 첨부파일 다운로드
	    @GetMapping("/download/{fileId}")
	    public ResponseEntity<Resource> downloadFile( @PathVariable(value="fileId") final Long fileId) {
	       
	    	
	    	FileRequest file = fileService.findFileById(fileId);
	        Resource resource = fileUtils.readFileAsResource(file);
	        try {
	            String filename = URLEncoder.encode(file.getOriginalName(), "UTF-8");
	            return ResponseEntity.ok()
	                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + filename + "\";")
	                    .header(HttpHeaders.CONTENT_LENGTH, file.getSize() + "")
	                    .body(resource);

	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("filename encoding failed : " + file.getOriginalName());
	        }
	    }
	    
	   
	    
	    
	
}
