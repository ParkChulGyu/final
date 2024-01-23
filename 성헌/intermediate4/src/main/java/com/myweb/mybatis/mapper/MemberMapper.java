package com.myweb.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.AdminNoticeDTO;
import com.myweb.dto.MemberDTO;
import com.myweb.dto.PagingDTO;
import com.myweb.dto.QnaDTO;

@Mapper
public interface MemberMapper {	
	
public int totalCount(String search) ;
	
	public List<MemberDTO> getMemberPaging(Map<String, Object> pstr) ;
	
	public MemberDTO getMembermapper(MemberDTO dto) throws Exception; 

	public List<MemberDTO> getMemberList();	
	
	public int insertmember(MemberDTO dto);
	
	public int update(MemberDTO dto);
	
	public int delete(MemberDTO dto);
	
	public int deleteMember(MemberDTO dto) throws Exception;

	public String idfind(String email) throws Exception;

	public int idfindcount(String email) throws Exception;

	public int nameCheck(String name) throws Exception;

	public int checkId(String user_id) throws Exception;
	
	
	public MemberDTO readMember(String user_id) throws Exception;
	
	public int updatePw(MemberDTO dto) throws Exception;
	
	int removeqnaone(int idx) throws Exception;
	
	public int removeadminone(int idx) throws Exception;
	
	
	List<QnaDTO> QnaList();
	
	List<AdminNoticeDTO> AdminList();
	
	
	
	
	
}
