package com.example.demo.api.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingDTO {

	
	int totalCount;
	int listNum;
	int blockNum;
	int pageNo;
	
    int start_rownum; 
    int end_rownum;
    
	int totalPage;
	int startPage;
	int endPage;
	boolean isPrev;
	boolean isNext;
	boolean isBPrev;
	boolean isBNext;
	
	public PagingDTO() {
	}
	
	public PagingDTO(int totalCount, int pageNo, int listNum, int blockNum) {
		this.totalCount = totalCount;
		this.pageNo = pageNo;
		this.listNum = listNum;
		this.blockNum = blockNum;
	}
	
	public void setPaging(){
		// 전체 페이지
		totalPage = (totalCount-1) / listNum + 1;
		//totalPage = (int)Math.ceil(((totalCount*0.1)/listNum)*10);

		// 시작, 끝 페이지 
		startPage = ((pageNo-1) / blockNum) * blockNum + 1;
		endPage = startPage + blockNum -1;
		if(endPage > totalPage) endPage = totalPage;
		
		// 1 ~ 10 => 1, 11 ~ 20 => 11, 21 ~ 30 => 21
	    start_rownum = (pageNo - 1) * listNum + 1 ;
	    end_rownum = pageNo * listNum ;
		

		// isBPrev, isBNext
		isBPrev = startPage > 1;
		isBNext = totalPage > endPage; 

		//isPrev, isNext
		isPrev = pageNo > 1;
		isNext = pageNo < totalPage; 
	}
}
