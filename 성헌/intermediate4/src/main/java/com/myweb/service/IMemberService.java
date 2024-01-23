package com.myweb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.QnaDTO;




public interface IMemberService {
	
	int totalCount(String search) ;
	public List<MemberDTO> getMemberPaging(Map<String, Object> pstr) ;
	List<MemberDTO> getMemberList();
	MemberDTO getMembermapper(MemberDTO dto) throws Exception ;
	int insertmember(MemberDTO dto) throws Exception;
	int update(MemberDTO dto) ;
	int delete(MemberDTO dto) ;
	int deleteMember(MemberDTO dto) throws Exception;
	String idfind(String email) throws Exception;
	int idfindcount(String email) throws Exception;
	int nameCheck(String name) throws Exception;
	int checkId(String user_id) throws Exception;

	int removeqnaone(int idx) throws Exception;
	
	public int removeadminone(int idx) throws Exception;
	
	
	List<QnaDTO> QnaList();
	
	List<AdminNoticeDTO> AdminList();
	
	

//이메일발송
public void sendEmail(MemberDTO dto, String div) throws Exception;

//비밀번호찾기
public void findPw(HttpServletResponse resp, MemberDTO dto) throws Exception;

}
