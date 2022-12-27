package com.FinalProject.Model.Board;

public class Pagination {

	public static PageDto page(String page,int Allrecoard){
		int currentPage=1;
		 if( page != null){
		 	 currentPage  =Integer.parseInt(page);	//5
		 }
		 int countpage  =Allrecoard; //51
		 int totRecords =countpage ;  //51
		 int pageSize = 10; 
		 int totalPage;               	 
		 int grpSize = 5;             
		 int currentGrp = 0;  	  	 	 
		 int reamin = totRecords  %  pageSize ;		 //51%10=5
		 if( reamin == 0 )
			 totalPage = totRecords / pageSize;		 
		 else 
			 totalPage = totRecords / pageSize +1;	//6
		 int remain2 = currentPage % grpSize;    //	5%5=1
		 if( remain2 == 0 )
			 currentGrp  = currentPage  / grpSize ;     		 
		 else 
			 currentGrp = currentPage  / grpSize  +1;    //2	 
		 int grpStartPage = ( currentGrp -1 ) * grpSize +1 ; // 6  
		 int grpEndPage = currentGrp * grpSize;                //10
		 if( grpEndPage > totalPage){
			 grpEndPage = totalPage;    
		 }	 	 
		 int index = grpStartPage;	 	//6
		 PageDto pi = null;      
	        pi = new PageDto(currentGrp,index,grpEndPage,totalPage);      
	        return pi;
	}
}
