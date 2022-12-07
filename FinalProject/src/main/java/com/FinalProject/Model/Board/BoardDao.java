package com.FinalProject.Model.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDao {
	
	@Autowired
	DataSource dataSource;
	
	public ArrayList<BoardDto> Array() {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String sql = "select b_num,b_continent,b_select,b_title,to_char(b_date,'yyyy.mm.dd hh24:mi:ss'),b_count,b_name from board";
        ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
	        conn = dataSource.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        rs  = pstmt.executeQuery();         
	        while( rs.next()){
	        BoardDto dto = new BoardDto();
	        int a= rs.getInt(1);
	    	String b=rs.getString(2);
	    	String c=rs.getString(3);
	    	String d=rs.getString(4);
	    	String e=rs.getString(5);
	    	int f=rs.getInt(6);
	    	String g=rs.getString(7);
	    	dto = new BoardDto(a,b,c,d,e,f,g);
	    	list.add(dto);
	    }
		} catch (SQLException e) {
        e.printStackTrace();
	         
	    } finally { 
	    	close(rs,pstmt, conn);      
	    }
		return list;
	}
	
	public void boardreg(String continent, String select, String title, String text) {
		
		Connection con = null;
        PreparedStatement pst = null;
        String sql = "insert into board values (board_seq.NEXTVAL,?,?,?,?,CURRENT_timestamp,0,'Jaeho')";
        try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, continent);
			pst.setString(2, select);
			pst.setString(3, title);
			pst.setString(4, text);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
	    	close(pst,con);
	    }
	}
	
	private void close(AutoCloseable... autoCloseables) {
	    for(AutoCloseable a :autoCloseables)
	        try { if(a!=null) a.close(); 
	        } catch(Exception e) { 
	        	e.printStackTrace(); 
	        }
	}
}
