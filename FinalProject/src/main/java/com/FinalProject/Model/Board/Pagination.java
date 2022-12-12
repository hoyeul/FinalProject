package com.FinalProject.Model.Board;

public class Pagination {

public static PageDto getPageInfo(int p,int a) {
	   
		int currentPage=1;
		
		 if( p !=0){
		 	currentPage = p;
		 }
		 int countpage  =a;
		
		 int totRecords =countpage ;
		 int pageSize =10;   
		 
		 int totalPage;             	 
		 int grpSize=5;             
		 int currentGrp =0;  	    
		 
		 int reamin = totRecords  %  pageSize ;		 
		 if( reamin ==0 ) {
			 totalPage = totRecords / pageSize;
		 }
		 else { 
			 totalPage = totRecords / pageSize +1;
		 }
		  
		 int remain2 = currentPage % grpSize;    
		 		 
		 if( remain2 ==0 ) {
			 currentGrp  = currentPage  / grpSize ;     
		 }
		 else { 
			 currentGrp = currentPage  / grpSize  +1;   
		 }
			 
		 int grpStartPage = ( currentGrp -1 ) * grpSize +1 ; 
		 int grpEndPage = currentGrp * grpSize;               
		 		 
		 if( grpEndPage > totalPage){
			 grpEndPage = totalPage;    
		 }
		 		 
		 int index = grpStartPage;
		 
        PageDto pi = null;      
        pi = new PageDto(currentGrp,index,grpEndPage,totalPage);      
        return pi;
		 
    }
}
