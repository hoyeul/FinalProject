package com.FinalProject.Model.Board;

public class PageDto {
	int currentGrp; 
	int index;   
    int grpEndPage;   
    int totalPage;  

    public PageDto() {}
    
    public PageDto(int currentGrp) {
    	this.currentGrp = currentGrp;
    }

	public PageDto(int currentGrp, int index, int grpEndPage, int totalPage) {
		super();
		this.currentGrp = currentGrp;
		this.index = index;
		this.grpEndPage = grpEndPage;
		this.totalPage = totalPage;
	}

	public int getCurrentGrp() {
		return currentGrp;
	}

	public void setCurrentGrp(int currentGrp) {
		this.currentGrp = currentGrp;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getGrpEndPage() {
		return grpEndPage;
	}

	public void setGrpEndPage(int grpEndPage) {
		this.grpEndPage = grpEndPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PageDto [currentGrp=" + currentGrp + ", index=" + index + ", grpEndPage=" + grpEndPage + ", totalPage="
				+ totalPage + "]";
	}

	
}
