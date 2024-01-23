package com.myweb.dto;

public class PagingDTO {
	int totalCount;
	int listNum;
	int blockNum;
	int pageNum;
	
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
	
	public PagingDTO(int totalCount, int pageNum, int listNum, int blockNum) {
		this.totalCount = totalCount;
		this.pageNum = pageNum;
		this.listNum = listNum;
		this.blockNum = blockNum;
	}
	
	public void setPaging(){
		// 전체 페이지
		totalPage = (totalCount-1) / listNum + 1;
		//totalPage = (int)Math.ceil(((totalCount*0.1)/listNum)*10);

		// 시작, 끝 페이지 
		startPage = ((pageNum-1) / blockNum) * blockNum + 1;
		endPage = startPage + blockNum -1;
		if(endPage > totalPage) endPage = totalPage;
		
		// 1 ~ 10 => 1, 11 ~ 20 => 11, 21 ~ 30 => 21
	    start_rownum = (pageNum - 1) * listNum + 1 ;
	    end_rownum = pageNum * listNum ;
		

		// isBPrev, isBNext
		isBPrev = startPage > 1;
		isBNext = totalPage > endPage; 

		//isPrev, isNext
		isPrev = pageNum > 1;
		isNext = pageNum < totalPage; 
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getListNum() {
		return listNum;
	}
	
	public int getStart_rownum() {
		return start_rownum;
	}
	
	public int getEnd_rownum() {
		return end_rownum;
	}
	

	public int getBlockNum() {
		return blockNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean getIsPrev() {
		return isPrev;
	}

	public boolean getIsNext() {
		return isNext;
	}

	public boolean getIsBPrev() {
		return isBPrev;
	}

	public boolean getIsBNext() {
		return isBNext;
	}

	@Override
	public String toString() {
		return "PagingDTO [totalCount=" + totalCount + ", listNum=" + listNum + ", blockNum=" + blockNum + ", pageNum="
				+ pageNum + ", start_rownum=" + start_rownum + ", end_rownum=" + end_rownum + ", totalPage=" + totalPage
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", isPrev=" + isPrev + ", isNext=" + isNext
				+ ", isBPrev=" + isBPrev + ", isBNext=" + isBNext + "]";
	}

	
	
	
}
