package com.one.app.home.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
	
	
	//시작 번호
	private Long startNum;
	//끝 번호
	private Long endNum;
	//검색 종류
	private String kind;
	
	//검색어
	private String search;
	
	
	//페이지 번호 (파라미터 대입)
	private Long page;
	
	//한 페이지당 출력할 row의 갯수 
	private Long perPage =10L;
	
	
	private Long start;
	
	private Long end;
	
	private boolean endCheck;
	
	

	
	
	public String getKind() {
		if(this.kind == null) {
			this.kind = "k1";
		}
		return kind;
	}
	
	
	
	public String getSearch() {
		if(this.search == null) {
			this.search = ""; // 빈 문자열 
		}
		return search;
	}
	
	
	public Long getStrartNum() {
		if(this.startNum==null || this.startNum<0) {
			this.startNum=0L;
		}
		return startNum;
	}
	
	
	
	//시작번호 끝번호 계산 
	public void makeNum() {
		this.startNum= (this.getPage()-1)*this.getPerPage();
		this.endNum = (this.getPage()*this.getPerPage());
	}

	
	
	
	public Long getPage() {
		if(this.page==null) {
			this.page = 1L;
		}
		return this.page;
	}

	
	
	
    public Long getPerPage() {
        if (this.perPage == null || this.perPage <= 0) {
            return 10L; // 기본값 10
        }
        return this.perPage;
    }
    
    
    
    
	
    public void make(Long totalCount) {
		//1. TotalPage
		Long totalPage = totalCount/this.perPage;
		if(totalCount%this.perPage != 0) {
			totalPage++;
		}
		
		Long perBlock=5L;
		//2. TotalBlock
		Long totalBlock = totalPage/perBlock;
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		//3. page번호로 Block 번호 구하기
		Long curBlock = this.getPage()/perBlock;
		
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		//4.Block번호로 시작 번호 끝번호 계산 
		Long start = (curBlock - 1) * perBlock + 1;
		Long end = curBlock * perBlock;
		
		
		
		this.setStart(start);
		this.setEnd(end);
		
		//5. curBlock이 마지막 블럭 이라면 
		if(totalBlock == curBlock) {
			this.setEnd(totalPage);
			this.setEndCheck(true);
		}
	}
	
	
	

}
