package com.myweb.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.AlarmDTO;
import com.myweb.dto.MoveDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;
import com.myweb.mybatis.mapper.AdminNoticeMapper;
import com.myweb.mybatis.mapper.AlarmMapper;
import com.myweb.mybatis.mapper.QnaMapper;
import com.myweb.service.AdminNoticeService;
import com.myweb.service.AlarmService;
import com.myweb.service.QnaService;

@Service("AlarmServiceImpl")
public class AlarmServiceImpl implements AlarmService{
	
	@Autowired
	AlarmMapper dao;

	
	@Override
	
	public QnaDTO getQnaOne(int idx)  throws Exception{
		return dao.getQnaOne(idx);
	}
	
	
	public void insertAlram(AlarmDTO dto) throws Exception{
		
		 dao.insertAlram(dto);
	}
	
	
	
	@Override
	public List<AlarmDTO> alramList(String toid) {
		return dao.alramList(toid);
	}
	
	@Override
	public int checkcount(String toid) throws Exception {
		return dao.checkcount(toid);
	}
	
	
	public void alarmRemove(int idx) throws Exception{
		
		dao.alarmRemove(idx);
	}
	
	@Override
	
	public QnaDTO alarmClick(QnaDTO Qna) throws Exception {
		return dao.alarmClick(Qna);
	
	}
	
	@Override
	
	public ReplyDTO getadminrereinfo(int bidx) throws Exception {
		return dao.getadminrereinfo(bidx);
	}
	@Override
	
	public ReplyDTO getwriteradmininfo(int idx) throws Exception {
		return dao.getwriteradmininfo(idx);
	}

	public  int getadminidx() throws Exception {
		return dao.getadminidx();
	}



	@Override
	public void alarmRead(int idx) {
		dao.alarmRead(idx);
	}


	@Override
	public List<AlarmDTO> getmembers(String toid) {
		return dao.getmembers(toid);
	}
	








}
