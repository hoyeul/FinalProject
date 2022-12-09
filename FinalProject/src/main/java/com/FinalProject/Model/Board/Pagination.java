package com.FinalProject.Model.Board;

public class Pagination {

public static PageDto getPageInfo(int currentPage, int listCount) {
        
        PageDto pi = null;      
        int pageLimit = 5;     
        int maxPage;            
        int startPage;          
        int endPage;     
        int boardLimit = 10;         
        maxPage = (int)((double)listCount / boardLimit + 0.9);
        startPage = (((int)((double)currentPage / pageLimit + 0.9)) - 1) * pageLimit + 1;
        endPage = startPage + pageLimit - 1;
        if(maxPage < endPage) {
            endPage = maxPage;
        }
        pi = new PageDto(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);      
        return pi;
    }
}
