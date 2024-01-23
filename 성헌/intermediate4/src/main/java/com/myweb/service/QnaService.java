package com.myweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.MoveDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;




public interface QnaService {
	
	
	public List<QnaDTO> Qna_list();
	
	List<QnaDTO> getinformationqnalist(Map<String, Object> pstr);
	
	
	public void insertFile(QnaDTO dto);

	List<QnaDTO> getMemberPaging(Map<String, Object> pstr);
	
	public int read(int idx) throws Exception;
	
	
	public QnaDTO detail(int idx) throws Exception;
	
	public void delete(int idx) throws Exception;
	
	public void update(QnaDTO dto);
	

	public void stepupdate(QnaDTO dto);
	
	public void insertQna(QnaDTO dto);
	
	public void rootupdate();
	
	int getQnacount(String search)  throws Exception;

	int getinfoQnacount(String nickname)  throws Exception;
	
	
	
}
