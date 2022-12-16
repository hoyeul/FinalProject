package com.FinalProject.Model.Board;

public class CommentDto {
 int num;
 int Cnum;
 int Recm;
 String text;
 String name;
 String date;
 
public CommentDto() {
	
}



public CommentDto(int num, int cnum, int recm, String text, String name, String date) {
	super();
	this.num = num;
	this.Cnum = cnum;
	this.Recm = recm;
	this.text = text;
	this.name = name;
	this.date = date;
}



public CommentDto(int num,int cnum, String text, String name, String date) {
	this.num = num;
	this.Cnum = cnum;
	this.text = text;
	this.name = name;
	this.date = date;
}

public CommentDto(int num,String text) {
	this.num=num;
	this.text = text;
}
public CommentDto(int num) {
	this.num=num;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getCnum() {
	return Cnum;
}
public void setCnum(int cnum) {
	Cnum = cnum;
}



public int getRecm() {
	return Recm;
}



public void setRecm(int recm) {
	Recm = recm;
}



@Override
public String toString() {
	return "CommentDto [num=" + num + ", Cnum=" + Cnum + ", Recm=" + Recm + ", text=" + text + ", name=" + name
			+ ", date=" + date + "]";
}




}
