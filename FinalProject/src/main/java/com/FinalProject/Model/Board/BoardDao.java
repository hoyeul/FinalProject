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
	
	public ArrayList<BoardDto> ArraySelect(int page,String continent,String type,String text,String name,int count) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        System.out.println("count="+count);
        int end =count-((page-1)*10);
        int start = count-(page*10)+1;       
        String sql = "select b_num,num,b_continent,b_select,b_title,to_char(b_date,'hh24:mi'),b_count,b_name from( ";
        sql+=" select rownum num,b_num ,b_continent,b_select,b_text,b_title,b_date,b_count,b_name from board where b_continent like ";
        sql+=" '%"+continent+"%' and b_select like '%"+type+"%' and b_name like '%"+name+"%' and (b_text like '%"+text+"%' or b_title like '%"+text+"%') )";
        sql+=" where num BETWEEN ? and ? order by num desc";
        
        ArrayList<BoardDto> list = new ArrayList<BoardDto>();
    	try {
    		conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rs  = pstmt.executeQuery();         
            while( rs.next()){
            BoardDto dto = new BoardDto();
            int a= rs.getInt(1);
            int h= rs.getInt(2);
            String b=rs.getString(3);
            String c=rs.getString(4);
            String d=rs.getString(5);
            String e=rs.getString(6);
            int f=rs.getInt(7);
            String g=rs.getString(8);
            dto = new BoardDto(a,h,b,c,d,e,f,g);
            list.add(dto);
            }
		} catch (SQLException e) {
			e.printStackTrace();
	    } finally { 
	    	close(rs,pstmt, conn);      
	    }
	return list;
	}

	public int count(String continent,String type,String text,String name) {
		Connection conn  =null;
		PreparedStatement pst =null;
		ResultSet  rs = null;	
		int num=0;
		try {
			conn  =dataSource.getConnection();
			String sql  = "select count(b_num) from board where b_continent like '%"+continent+"%' and b_select like '%"+type+"%' and b_name like '%"+name+"%' and (b_text like '%"+text+"%' or b_title like '%"+text+"%')";			
			pst= conn.prepareStatement(sql);
			 rs  =pst.executeQuery();			
			if( rs.next()) {
				 num  =rs.getInt(1);				
			}				
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}			
		return num;		
	}
	
	public BoardDto select(int b) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;	
		try {
			conn = dataSource.getConnection();
			String sql = "select b_num, num, b_continent, b_select,b_title, b_text, to_char(b_date,'yyyy-mm-dd hh24:mi:ss'), b_count, b_name from board where b_num = ? ";			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, b);
			rs = pst.executeQuery();			
			if( rs.next()) {
				int num =rs.getInt(1);
				int num2 = rs.getInt(2);
				String Continent = rs.getString(3);	
				String Select = rs.getString(4);
				String Title = rs.getString(5);
				String Text = rs.getString(6);
				String Date = rs.getString(7);
				int number = rs.getInt(8);
				String ida = rs.getString(9);
				dto = new BoardDto( num,num2 ,Continent,Select,Title,Text,Date,number,ida);
			}				
			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}			
		return dto;		
	}
	
	public void delet(int a) {
		Connection conn = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		ResultSet rs = null;	
		try {
			conn = dataSource.getConnection();
			String sql1 = "delete from CM where Cnum = ? ";	
			String sql2 = "delete from board where b_num = ? ";			
			pst1 = conn.prepareStatement(sql1);
			pst1.setInt(1, a);
			pst2 = conn.prepareStatement(sql2);
			pst2.setInt(1, a);
			rs = pst1.executeQuery();
			rs = pst2.executeQuery();
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close(pst1,pst2,rs,conn);	
		}				
	}

	public void update(BoardDto dto) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;	
		String sql = " UPDATE board SET b_continent=?, b_select=?, b_title=?, b_text=?, b_date = CURRENT_timestamp where b_num = ?";			
		try {
			conn = dataSource.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, dto.getContinent());
			pst.setString(2, dto.getSelect());
			pst.setString(3, dto.getTitle());
			pst.setString(4, dto.getText());
			pst.setInt(5, dto.getNum());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pst, conn);			
		}	
	}

	public void updateNum(int a , int b) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;	
		String sql = "UPDATE board SET b_count =? where b_num = ? ";
		try {
			conn = dataSource.getConnection();
			pst= conn.prepareStatement(sql);
			pst.setInt(1, a);
			pst.setInt(2, b);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pst, conn);			
		}	
	}
	
	public ArrayList<CommentDto> ArrayCM(int id) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select num, Cnum,RECM, text, name,to_char(C_date,'yyyy.mm.dd hh24:mi:ss') from CM where Cnum=? ORDER BY RECM,num";
        ArrayList<CommentDto> list = new ArrayList<CommentDto>();
        
		try {
	        conn = dataSource.getConnection();
	        pstmt = conn.prepareStatement(sql);	  
	        pstmt.setInt(1, id);
	        rs  = pstmt.executeQuery();         
	        while( rs.next()){
		        CommentDto dto = new CommentDto();
		        int a = rs.getInt(1);
		        int b = rs.getInt(2);
		        int c = rs.getInt(3);
		    	String d = rs.getString(4);
		    	String e = rs.getString(5);
		    	String f = rs.getString(6);
		    	dto = new CommentDto(a,b,c,d,e,f);
		    	list.add(dto);
	        }
		}catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(rs,pstmt, conn);      
		}
		return list;		  
	}
	
	public void deletCM(int a) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;	
		try {
			conn = dataSource.getConnection();
			String sql = "delete from CM  where num = ? ";			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, a);
			rs = pst.executeQuery();			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}				
	}
	
	public void update(CommentDto dto) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;	
		String sql = "UPDATE CM SET text =? where num  = ? ";			
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
	
	public void insert(CommentDto dto) {		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;	
		String sql = " insert into CM values(comment_seq.NEXTVAL,?,comment_seq2.NEXTVAL,?,'acorn2',CURRENT_timestamp) ";
		try {
			conn = dataSource.getConnection();			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dto.getCnum());
			pst.setString(2, dto.getText());
			pst.executeUpdate();		
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}				
	}
	
	public void ReplyCM(CommentDto dto,int s) {		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;	
		String sql = " insert into CM values(comment_seq.NEXTVAL,?,?,?,'ㅤㅤ↳acorn2',CURRENT_timestamp) ";
		try {
			conn = dataSource.getConnection();			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dto.getCnum());
			pst.setInt(2, s);
			pst.setString(3, "ㅤㅤ"+dto.getText());
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
        String sql = "insert into board values (board_seq.NEXTVAL,board_seq2.NEXTVAL,?,?,?,?,CURRENT_timestamp,0,'Jaeho')";
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
