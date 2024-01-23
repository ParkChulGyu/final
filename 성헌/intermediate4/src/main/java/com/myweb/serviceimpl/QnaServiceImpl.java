package com.myweb.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MoveDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;
import com.myweb.mybatis.mapper.AdminNoticeMapper;
import com.myweb.mybatis.mapper.QnaMapper;
import com.myweb.service.AdminNoticeService;
import com.myweb.service.QnaService;

@Service("QnaServiceImpl")
public class QnaServiceImpl implements QnaService{
	
	@Autowired
	QnaMapper dao;

	
	
	@Override
	public List<QnaDTO> Qna_list() {
		return dao.Qna_list();
	}

	
	
	
	@Override
	public
	int getQnacount(String search)  throws Exception{
		return dao.getQnacount(search);
	} 
	
	
	
	@Override
	public
	int getinfoQnacount(String nickname)  throws Exception{
		return dao.getinfoQnacount(nickname);
	} 
	
	
	
	@Override
	public
	List<QnaDTO> getMemberPaging(Map<String, Object> pstr) {
		return dao.getMemberPaging(pstr);
	}
	
	@Override
	public
	List<QnaDTO> getinformationqnalist(Map<String, Object> pstr) {
		return dao.getinformationqnalist(pstr);
	}
	

	
	@Override
	public void insertFile(QnaDTO dto) {
		dao.insertFile(dto);
	}
	@Override
	 public int read(int idx) throws Exception{
		
		return dao.read(idx);
	}
	
	
	@Override
	public QnaDTO detail(int idx) throws Exception{
		return dao.detail(idx);
	}
	
	
	@Override
	public void delete(int idx)throws Exception {
		dao.delete(idx);
	}
	
	@Override
	public void update(QnaDTO dto) {
		dao.update(dto);
	}
	
	
	@Override
	public void stepupdate(QnaDTO dto) {
		dao.stepupdate(dto);
	}
	
	@Override
	public void insertQna(QnaDTO dto) {
		dao.insertQna(dto);
	}
	
	
	
	@Override
	public void rootupdate() {
		dao.rootupdate();
	}
	
	
}
