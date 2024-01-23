package com.myweb.dto;

import lombok.Data;

@Data
public class AdminNoticeDTO {

	
	private int idx;
    private String title;
    private String content;
    private String nickname;
    private String category;
    private String ofile;
    private String sfile;
    private String regdate;
    private int totalcount;
	
	
}
