package com.myweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.AlarmDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.MoveDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;




public interface AlarmService {
	
	
	
	public QnaDTO getQnaOne(int idx) throws Exception;

	public void insertAlram(AlarmDTO dto) throws Exception;
	
	public List<AlarmDTO> alramList(String toid) throws Exception;
	
	
	public int checkcount(String toid) throws Exception;

	public void alarmRemove(int idx) throws Exception;

	public QnaDTO alarmClick(QnaDTO Qna) throws Exception;
	
	public ReplyDTO getadminrereinfo(int bidx) throws Exception;
	
	public ReplyDTO getwriteradmininfo(int idx) throws Exception;
	
	public int getadminidx() throws Exception;
	
	public void alarmRead(int idx);
	
	public List<AlarmDTO> getmembers(String toid);
	
	
	
	
	
	
}
