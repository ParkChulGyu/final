package com.myweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.MoveDTO;
import com.myweb.dto.MywritelistDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.QnaDTO;
import com.myweb.dto.ReplyDTO;




public interface AdminNoticeService {
	
	AdminNoticeDTO getBoradone(int idx);

	MoveDTO getMove(int idx);

	List<AdminNoticeDTO> getBoradlist() throws Exception;
	
	int getBoardcount(String search) throws Exception;
	
	public List<AdminNoticeDTO> getMemberPaging(Map<String, Object> pstr) ;
	
	int insertFile(AdminNoticeDTO dto) throws Exception;

	int updatecount(int idx) throws Exception;
	
	
	public ArrayList<ReplyDTO> replyList(ReplyDTO dto) ;
	
	public ArrayList<ReplyDTO> showrereply(ReplyDTO dto) ;
	
	public int pictureWriteReReply(ReplyDTO dto) throws Exception;

	public int pictureWriteReplydeleteGrpas(ReplyDTO dto) throws Exception;

	public int pictureWriteReply(ReplyDTO dto) throws Exception;

	public int p_reply_max_no() throws Exception;
	
	public int pictureWriteReplyupdate(ReplyDTO dto) throws Exception;
	
	public int p_reply_max_Grps(ReplyDTO dto) throws Exception;

	public int pictureWriteReplyupdateGrpas(ReplyDTO dto) throws Exception;

	public int DeleteReply(ReplyDTO dto) throws Exception;
	
	public int DeleteReReply(ReplyDTO dto) throws Exception;
	
	public ArrayList<ReplyDTO> replyanswerList(ReplyDTO dto) ;
	
	int getinfoadmincount(String nickname)  throws Exception;
	
	List<AdminNoticeDTO> getinformationadminPaging(Map<String, Object> pstr);
	
	int getinforeplycount(String nickname)  throws Exception;
	
	List<ReplyDTO> getinformationareplyPaging(Map<String, Object> pstr);
	
	int getinformywritecount(Map<String, Object> checkcount)  throws Exception;
	
	List<MywritelistDTO> getinfomywritelistPaging(Map<String, Object> pstr);
	
	
	String getname(String idx );
	
	String matchgrp(String bidx );
	
	ReplyDTO getonemember(String idx);
	
	
}
