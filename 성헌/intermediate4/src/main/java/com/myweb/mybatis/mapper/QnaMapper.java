package com.myweb.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.QnaDTO;

@Mapper
public interface QnaMapper {	
	
	
	public List<QnaDTO> Qna_list();	
	
	public List<QnaDTO> getinformationqnalist(String nickname);

	
	
	
	int getQnacount(String search)  throws Exception;
	
	List<QnaDTO> getMemberPaging(Map<String, Object> pstr);
	
	List<QnaDTO> getinformationqnalist(Map<String, Object> pstr);
			
	public void insertFile(QnaDTO dto);
	
	public int read(int idx)  throws Exception;
	
	
	public QnaDTO detail(int idx) throws Exception;
	
	public void delete(int idx) throws Exception;
	
	public void update(QnaDTO dto);
	
	
	
	public void stepupdate(QnaDTO dto);
	
	public void insertQna(QnaDTO dto);

	public void rootupdate();
	
	int getinfoQnacount(String nickname)  throws Exception;
	


}
