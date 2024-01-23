package com.myweb.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MoveDTO;
import com.myweb.dto.MywritelistDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;
import com.myweb.mybatis.mapper.AdminNoticeMapper;
import com.myweb.service.AdminNoticeService;

@Service("AdminNoticeServiceImpl")
public class AdminNoticeServiceImpl implements AdminNoticeService{
	
	@Autowired
	AdminNoticeMapper admin;

	@Override
	public
	AdminNoticeDTO getBoradone(int idx) {
		return admin.getBoradone(idx);
	}
	@Override
	public
	MoveDTO getMove(int idx) {
		return admin.getMove(idx);
	}

	@Override
	public
	List<AdminNoticeDTO> getBoradlist() throws Exception{
		return admin.getBoradlist();
		} 
	
	@Override
	public
	int getBoardcount(String search)  throws Exception{
		return admin.getBoardcount(search);
	} 
	
	@Override
	public
	List<AdminNoticeDTO> getMemberPaging(Map<String, Object> pstr) {
		return admin.getMemberPaging(pstr);
	} 

	@Override
	public
	int insertFile(AdminNoticeDTO dto) throws Exception{
		return admin.insertFile(dto);
	} 
	@Override
	public
	int  updatecount(int idx) throws Exception {
		return admin.updatecount(idx);
	}
	
	@Override
	public
	 ArrayList<ReplyDTO> replyList(ReplyDTO dto) {
		return admin.replyList(dto);
	} 
	@Override
	public
	ArrayList<ReplyDTO> showrereply(ReplyDTO dto) {
		return admin.showrereply(dto);
		
	} 
	@Override
	
	public int pictureWriteReReply(ReplyDTO dto) throws Exception{
 
		return admin.pictureWriteReReply(dto);
		
		
	} 
	@Override
	
	public int DeleteReply(ReplyDTO dto) throws Exception{
		
		return admin.DeleteReply(dto);
		
		
	} 
	@Override
	
	public int DeleteReReply(ReplyDTO dto) throws Exception{
		
		return admin.DeleteReReply(dto);
		
		
	} 
	@Override
	
	public int pictureWriteReply(ReplyDTO dto) throws Exception{
		System.out.println("dto.getIdx() 체크 : " + dto.getIdx());
		return admin.pictureWriteReply(dto) ;
	} 
	@Override
	
	public int p_reply_max_no() throws Exception{ 
		
		return admin.p_reply_max_no();
	} 
	@Override
	
	public int pictureWriteReplyupdate(ReplyDTO dto) throws Exception {
		return admin.pictureWriteReplyupdate(dto);
	}
	@Override
	
	public int p_reply_max_Grps(ReplyDTO dto) throws Exception {
		return admin.p_reply_max_Grps(dto);
	}
		
	@Override
	
	public int pictureWriteReplyupdateGrpas(ReplyDTO dto) throws Exception {
	
		return admin.pictureWriteReplyupdateGrpas(dto);
	}
	 
	
	
	@Override
	public
	ArrayList<ReplyDTO> replyanswerList(ReplyDTO dto) {
		return admin.replyanswerList(dto);
	} 
	
	
	@Override
	public
	int getinfoadmincount(String nickname)  throws Exception{
		return admin.getinfoadmincount(nickname);
	} 
	
	
	@Override
	public
	List<AdminNoticeDTO> getinformationadminPaging(Map<String, Object> pstr) {
		return admin.getinformationadminPaging(pstr);
	}
	
	
	@Override
	public
	int getinforeplycount(String nickname)  throws Exception{
		return admin.getinforeplycount(nickname);
	} 
	
	@Override
	public
	List<ReplyDTO> getinformationareplyPaging(Map<String, Object> pstr) {
		return admin.getinformationareplyPaging(pstr);
	}
	@Override
	public
	int getinformywritecount(Map<String, Object> checkcount)  throws Exception{
		return admin.getinformywritecount(checkcount);
	} 
	
	@Override
	public int pictureWriteReplydeleteGrpas(ReplyDTO dto) throws Exception{
		return admin.pictureWriteReplydeleteGrpas(dto);
	} 
	
	
	
	@Override
	public
	List<MywritelistDTO> getinfomywritelistPaging(Map<String, Object> pstr) {
		return admin.getinfomywritelistPaging(pstr);
	}
	
	
	@Override
	public
	String getname(String idx ) {
		return admin.getname(idx);
	}
	
	
	@Override
	public
	String matchgrp(String bidx) {
		return admin.matchgrp(bidx);
	}
	@Override
	public ReplyDTO getonemember(String idx) {
		return admin.getonemember(idx);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
