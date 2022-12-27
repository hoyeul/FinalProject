package com.FinalProject.Model.Board;

public class RecommendDto {
	
	String rec_up;
	String rec_down;
	int b_num;
	String id;
	
	public RecommendDto() {
	}
	
	public RecommendDto(String rec_up, String rec_down, int b_num, String id) {
		super();
		this.rec_up = rec_up;
		this.rec_down = rec_down;
		this.b_num = b_num;
		this.id = id;
	}
	
	public String getRec_up() {
		return rec_up;
	}
	public void setRec_up(String rec_up) {
		this.rec_up = rec_up;
	}
	public String getRec_down() {
		return rec_down;
	}
	public void setRec_down(String rec_down) {
		this.rec_down = rec_down;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RecommendDto [rec_up=" + rec_up + ", rec_down=" + rec_down + ", b_num=" + b_num + ", id=" + id + "]";
	}
}
