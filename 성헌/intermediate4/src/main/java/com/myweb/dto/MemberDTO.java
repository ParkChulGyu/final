package com.myweb.dto;

import java.util.Date;

import com.google.protobuf.Timestamp;

import lombok.Data;

@Data
public class MemberDTO{
	
	private  int user_idx;
	private	String user_id;
	private  String pw;
	private String name;
	private String nickname;
	private String email;
	private String PhoneNumber;
	private String sysdate ;
	private int point;
	private String grade;
	private String birth;
	
}




	
	
	

