package com.FinalProject.Model.Board;

public class BoardDto {
	int Num;
	String Continent;
	String Select;
	String Title;
	String Text;
	String Date;
	int number;
	String id;
	
	public BoardDto() {
		
	}
	
	public BoardDto(String continent, String select, String title, String text) {
		super();
		Continent = continent;
		Select = select;
		Title = title;
		Text = text;
	}
	
	public BoardDto(int num, String continent, String select, String title, String date, int number,String id) {
		this.Num = num;
		this.Continent = continent;
		this.Select = select;
		this.Title = title;
		this.Date = date;
		this.number = number;
		this.id = id;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}
	public String getSelect() {
		return Select;
	}
	public void setSelect(String select) {
		Select = select;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
