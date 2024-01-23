package com.myweb.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaDTO {

	
	
	private int  no,readcnt, idx, root, step, indent;
	private String title, content, writer, filename, filepath, name;
	private String regdate;

    
	
	
}
