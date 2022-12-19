package com.FinalProject.Model.Board;

public class BoardDto {
	int Num;
	int Num2;
	String Continent;
	String Select;
	String Title;
	String Text;
	String Date;
	int number;
	String id;
	String recommend;
	String upcnt;
	String downcnt;

	public BoardDto() {
		
	}

	public BoardDto(int num, int num2, String continent, String select, String title, String text, String date,
			int number, String id, String upcnt, String downcnt) {
		this.Num = num;
		this.Num2 = num2;
		this.Continent = continent;
		this.Select = select;
		this.Title = title;
		this.Text = text;
		this.Date = date;
		this.number = number;
		this.id = id;
		this.upcnt = upcnt;
		this.downcnt = downcnt;
	}

	public BoardDto( int num,String continent, String select, String title,String Text) {
		this.Num = num;
		this.Continent = continent;
		this.Select = select;
		this.Title = title;
		this.Text =Text;
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

	
	public BoardDto(int num,int num2, String continent, String select, String title, String date, int number, String id, String recommend) {
		this.Num = num;
		this.Num2 = num2;
		this.Continent = continent;
		this.Select = select;
		this.Title = title;
		this.Date = date;
		this.number = number;
		this.id = id;
		this.recommend = recommend;
		
	}
	
	public BoardDto(int num,int num2, String continent, String select, String title, String text, String date, int number,
			String id, String recommend) {
		this.Num = num;
		this.Num2 = num2;
		this.Continent = continent;
		this.Select = select;
		this.Title = title;
		this.Text = text;
		this.Date = date;
		this.number = number;
		this.id = id;
		this.recommend = recommend;
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

	public int getNum2() {
		return Num2;
	}
	public void setNum2(int num2) {
		Num2 = num2;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getUpcnt() {
		return upcnt;
	}

	public void setUpcnt(String upcnt) {
		this.upcnt = upcnt;
	}

	public String getDowncnt() {
		return downcnt;
	}

	public void setDowncnt(String downcnt) {
		this.downcnt = downcnt;
	}

	@Override
	public String toString() {
		return "BoardDto [Num=" + Num + ", Num2=" + Num2 + ", Continent=" + Continent + ", Select=" + Select
				+ ", Title=" + Title + ", Text=" + Text + ", Date=" + Date + ", number=" + number + ", id=" + id
				+ ", recommend=" + recommend + "]";
	}
}
