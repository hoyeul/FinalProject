package com.FinalProject.Model.Board;

public class SearchDto {
String continent;
String selecttype;
String selectcontent;
String text;
String page;
public SearchDto() {}
public SearchDto(String continent, String selecttype, String selectcontent, String text,String page) {
	super();
	this.continent = continent;
	this.selecttype = selecttype;
	this.selectcontent = selectcontent;
	this.text = text;
	this.page=page;
}

public String getPage() {
	return page;
}
public void setPage(String page) {
	this.page = page;
}
public String getContinent() {
	return continent;
}
public void setContinent(String continent) {
	this.continent = continent;
}
public String getSelecttype() {
	return selecttype;
}
public void setSelecttype(String selecttype) {
	this.selecttype = selecttype;
}
public String getSelectcontent() {
	return selectcontent;
}
public void setSelectcontent(String selectcontent) {
	this.selectcontent = selectcontent;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
@Override
public String toString() {
	return "SearchDto [continent=" + continent + ", selecttype=" + selecttype + ", selectcontent=" + selectcontent
			+ ", text=" + text + ", page=" + page + "]";
}


}
