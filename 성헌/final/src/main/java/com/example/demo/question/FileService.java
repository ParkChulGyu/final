package com.example.demo.question;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.DataNotFoundException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileService {
	
	 private final FileRepository fileRepository;

	 	@Transactional
	    public void saveFiles(final Question question, final List<FileRequest> files) {
	        if (CollectionUtils.isEmpty(files)) {
	            return;
	        }
	        for (FileRequest file : files) {
	            file.setPost(question);
	            file.setCreatedDate(LocalDateTime.now());
	            this.fileRepository.save(file);
	        }
	    }

	 	
	 	
	 	
	 	public List<FileRequest> findAllFilesByIds(final Question question) {
	 	    if (question != null) {
	 	        return fileRepository.findAllByPostId((long)question.getId());
	 	    } else {
	 	        return Collections.emptyList();
	 	    }
	 	}
	 	
	 	public FileRequest findAllFileById(final long id) {
	       
	        
	        return fileRepository.findAllById(id);
	    }
	 	
	 	
	 	 public FileRequest findFileById(final Long id) {
	        
	 		 return fileRepository.findAllById(id);
	     }
	 	
	 	
	 	

	 	 @Transactional
	     public void deleteAllFileByIds(final List<Long> ids) {
	         if (CollectionUtils.isEmpty(ids)) {
	             return;
	         }
	         
	         for (Long id : ids) {
	        	 
	        	 fileRepository.deleteById(id);
	         }
	     }
	  
	 	
	 	
	 	
}
