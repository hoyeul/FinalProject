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
	public BoardDto select(int b) {
		BoardDto dto = null;
		Connection conn  =null;
		PreparedStatement pst =null;
		ResultSet  rs = null;	
		String id =Integer.toString(b);
		try {
			conn  =dataSource.getConnection();
			String sql  = "select b_num,b_continent,b_select,b_title,b_text,to_char(b_date,'yyyy.mm.dd hh24:mi:ss'),b_count,b_name from board  where b_num = ? ";			
			pst= conn.prepareStatement(sql);
			pst.setString(1, id);
			 rs  =pst.executeQuery();			
			if( rs.next()) {
				int num  =rs.getInt(1);
				String Continent  = rs.getString(2);	
				String Select  = rs.getString(3);
				String Title  = rs.getString(4);
				String Text  = rs.getString(5);
				String Date  = rs.getString(6);
				int number  = rs.getInt(7);
				String ida  = rs.getString(8);
				dto = new BoardDto( num ,Continent,Select,Title,Text,Date,number,ida);					
			}				
			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}			
		return dto;		
	}
	public void delet(int a) {
		Connection conn  =null;
		PreparedStatement pst1 =null;
		PreparedStatement pst2 =null;
		ResultSet  rs = null;	
		try {
			conn  =dataSource.getConnection();
			String sql1  = "delete from CM  where Cnum = ? ";	
			String sql2  = "delete from board  where b_num = ? ";			
			pst1= conn.prepareStatement(sql1);
			pst1.setInt(1, a);
			pst2= conn.prepareStatement(sql2);
			pst2.setInt(1, a);
			 rs  =pst1.executeQuery();
			 rs  =pst2.executeQuery();
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close(  pst1,pst2,rs,conn);	
		}				
	}
	
	public void update(BoardDto dto) {
		Connection conn  =null;
		PreparedStatement pst =null;
		ResultSet  rs = null;	
		String sql  = "UPDATE board SET b_title=?, b_text=?, CURRENT_timestamp where b_num = ? ";			
		try {
			conn = dataSource.getConnection();
			pst= conn.prepareStatement(sql);
			pst.setString(1, dto.getTitle());
			pst.setString(2, dto.getText());
			pst.setString(3, dto.getDate());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}	
	}
	
	public void updateNum(int a , int b) {
		Connection conn  =null;
		PreparedStatement pst =null;
		ResultSet  rs = null;	
		String sql  = "UPDATE board SET b_count =? where b_num = ? ";			
		try {
			conn  =dataSource.getConnection();
			pst= conn.prepareStatement(sql);
			pst.setInt(1, a);
			pst.setInt(2, b);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}	
	}
	public ArrayList<CommentDto> ArrayCM(int id) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String sql = "SELECT * FROM CM where Cnum=?";
        ArrayList<CommentDto> list = new ArrayList<CommentDto>();
	try {
        conn = dataSource.getConnection();
        pstmt = conn.prepareStatement(sql);	  
        pstmt.setInt(1, id);
        rs  = pstmt.executeQuery();         
        while( rs.next()){
        CommentDto dto = new CommentDto();
        int a= rs.getInt(1);
        int b= rs.getInt(2);
    	String c=rs.getString(3);
    	String d=rs.getString(4);
    	String e=rs.getString(5);
    	dto = new CommentDto(a,b,c,d,e);
    	list.add(dto);
    }
   } catch (SQLException e) {
        e.printStackTrace();
         
    } finally { 
    	close(rs,pstmt, conn);      
    }
	return list;		  
}
	public void deletCM(int a) {
		Connection conn  =null;
		PreparedStatement pst =null;
		ResultSet  rs = null;	
		try {
			conn  =dataSource.getConnection();
			String sql  = "delete from CM  where num = ? ";			
			pst= conn.prepareStatement(sql);
			pst.setInt(1, a);
			 rs  =pst.executeQuery();			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}				
	}
	public void update(CommentDto dto) {
		Connection conn  =null;
		PreparedStatement pst =null;
		ResultSet  rs = null;	
		String sql  = "UPDATE CM SET text =? where num  = ? ";			
		try {
			conn = dataSource.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, dto.getText());
			pst.setInt(2, dto.getNum());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}	
	}
	public void  insert(CommentDto dto) {		
		Connection conn  =null;
		PreparedStatement pst =null;
		ResultSet  rs = null;	
		String sql  = " insert into CM values(comment_seq.NEXTVAL,?,?,'acorn2',CURRENT_timestamp) ";
		try {
			conn  =dataSource.getConnection();			
			pst= conn.prepareStatement(sql);
			pst.setInt(1, dto.getCnum());
			pst.setString(2, dto.getText());
			pst.executeUpdate();		
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}				
	}
	public void boardreg(String continent, String select, String title, String text) {
		
		Connection con = null;
        PreparedStatement pst = null;
        String sql = "insert into board values (board_seq.NEXTVAL,?,?,?,?,CURRENT_timestamp,0,'acorn2')";
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
