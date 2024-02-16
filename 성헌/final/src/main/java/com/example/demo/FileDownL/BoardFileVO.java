package com.example.demo.FileDownL;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardFileVO {
	private String memberId;
    private String title;
    private String content;
    private List<MultipartFile> files;

}
