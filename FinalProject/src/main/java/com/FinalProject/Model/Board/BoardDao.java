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
	
	public ArrayList<BoardDto> ArraySelect(int page,String continent,String type,String text,String name,int count,String recommend) {
		
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        int end = count-((page-1)*10);
        int start = count-(page*10)+1;             
        
        String sql  = " select * from ( select rownum  num , bnum ,  b_continent,  b_select ,   b_title,   case when (to_char(SYSDATE,'dd')-to_char(b_date,'dd'))>=1 then to_char(b_date,'mm.dd') else to_char(b_date,'hh24:mi') end as b_date , b_count,  b_name ,total from "
                + " ( select  a.b_num  bnum,  b_continent, b_select, b_title, b_date, admin ,b_count, b_name ,b.B_NUM ,    nvl(sum(b.REC_UP) - sum(b.REC_DOWN),0) total  "
                + " from (select  b_num , b_continent, b_select, b_text, b_title, "
                + " b_date, b_count, b_name  ,   case when b_select like '공지' then 1  else 2 end as admin  from board where b_continent like '%"+continent+"%' "
                + " and b_select like '%"+type+"%' and b_name like '%"+name+"%' and (b_text like '%"+text+"%' or b_title like '%"+text+"%') ) a "
                + "  left outer join   board_recommend  b  on a.b_num = b.b_num group by   a.b_num,  b_continent, b_select, b_title, b_date, "
                + "  b_count, b_name ,b.B_NUM  ,admin order by admin desc , "+recommend+") ) where num between  ? and ? order by num desc";
        
        ArrayList<BoardDto> list = new ArrayList<BoardDto>();
    	try {
    		conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
             pstmt.setInt(1, start);
             pstmt.setInt(2, end);
            rs  = pstmt.executeQuery();         
            while( rs.next()){
            BoardDto dto = new BoardDto();
            int b_num= rs.getInt(1);
            int num= rs.getInt(2);
            String b_continent=rs.getString(3);
            String b_select=rs.getString(4);
            String b_title=rs.getString(5);
            String b_date=rs.getString(6);
            int b_count=rs.getInt(7);
            String b_name=rs.getString(8);
            String b_recommend = rs.getString(9);
            dto = new BoardDto(b_num,num,b_continent,b_select,b_title,b_date,b_count,b_name,b_recommend);
            list.add(dto);
            }
            
            
            System.out.print(  "count= " + list.size());
		} catch (SQLException e) {
			e.printStackTrace();
	    } finally { 
	    	close(rs,pstmt, conn);      
	    }
	return list;
	}
	
	public ArrayList<BoardDto> arrayRecent() {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;     
        String sql =" select b.b_num, b.num, b.b_continent, b.b_select, b.b_title, ";
        sql+=" case when (to_char(SYSDATE,'dd')-to_char(b.b_date,'dd'))>=1 then to_char(b.b_date,'mm.dd') else to_char(b.b_date,'hh24:mi') end as writetime, ";
        sql+=" b.b_count, b.b_name, nvl(sum(rec_up) - sum(rec_down),0)as rec_count ";
        sql+=" from (select ROWNUM Rnum, b_num, num , b_continent, b_select, b_title, b_date, b_count, b_name from board ORDER BY num desc, Rnum desc ) b ";
        sql+=" left outer join board_recommend br on b.B_NUM = br.B_NUM where rownum between 1 and 5 ";
        sql+=" group by  b.b_num, b.num, b.b_continent, b.b_select, b.b_title, b_date,b.b_count, b.b_name ";
        sql+=" ORDER BY writetime DESC ";
        
        ArrayList<BoardDto> list = new ArrayList<BoardDto>();
    	try {
    		conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs  = pstmt.executeQuery();         
            while( rs.next()){
            BoardDto dto = new BoardDto();
            int b_num= rs.getInt(1);
            int num= rs.getInt(2);
            String b_continent=rs.getString(3);
            String b_select=rs.getString(4);
            String b_title=rs.getString(5);
            String b_date=rs.getString(6);
            int b_count=rs.getInt(7);
            String b_name=rs.getString(8);
            String b_recommend = rs.getString(9);
            dto = new BoardDto(b_num,num,b_continent,b_select,b_title,b_date,b_count,b_name,b_recommend);
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
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;	
		int num = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "select count(b_num) from board where b_continent like '%"+continent+"%' and b_select like '%"+type+"%' and b_name like '%"+name+"%' and (b_text like '%"+text+"%' or b_title like '%"+text+"%')";			
			pst = conn.prepareStatement(sql);
			 rs = pst.executeQuery();			
			if( rs.next()) {
				num = rs.getInt(1);				
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
			String sql = " select b.b_num, b.num, b.b_continent, b.b_select, b.b_title, b.b_text, to_char(b.b_date,'yyyy-mm-dd hh24:mi:ss'), b.b_count, b.b_name, nvl(sum(rec_up),0) as upcnt, nvl(sum(rec_down),0) as downcnt ";
				   sql+= " from board b left outer join board_recommend br on b.B_NUM = br.B_NUM where b.b_num = ? ";
				   sql+= " group by b.b_num, b.num, b.b_continent, b.b_select, b.b_title, b.b_text, to_char(b.b_date,'yyyy-mm-dd hh24:mi:ss'), b.b_count, b.b_name ";
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
				String upcnt = rs.getString(10);
				String downcnt = rs.getString(11);
				dto = new BoardDto( num,num2 ,Continent,Select,Title,Text,Date,number,ida,upcnt,downcnt);
			}				
			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}			
		return dto;		
	}
	
	public void delete(int a) {
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

	public void updateBoard(BoardDto dto, String freeboard_content) {
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
			pst.setString(4, freeboard_content);
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
	
	public void updateCM(CommentDto dto) {
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
		String sql = " insert into CM values(comment_seq.NEXTVAL,?,comment_seq2.NEXTVAL,?,?,CURRENT_timestamp) ";
		try {
			conn = dataSource.getConnection();			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dto.getCnum());
			pst.setString(2, dto.getText());
			pst.setString(3, dto.getName());
			// System.out.println("null????" + dto.getName());
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
		String sql = " insert into CM values(comment_seq.NEXTVAL,?,?,?,?,CURRENT_timestamp) ";
		try {
			conn = dataSource.getConnection();			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dto.getCnum());
			pst.setInt(2, s);
			pst.setString(3, "ㅤㅤ"+dto.getText());
			pst.setString(4, "ㅤ┖"+dto.getName());
			pst.executeUpdate();		
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);			
		}				
	}
	
	public void boardreg(String continent, String select, String title, String text, String id) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into board values (board_seq.NEXTVAL,board_seq2.NEXTVAL,?,?,?,?,CURRENT_timestamp,0,?)";
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, continent);
			pst.setString(2, select);
			pst.setString(3, title);
			pst.setString(4, text);
			pst.setString(5, id);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			close(pst,con);
		}
	}
	
	public int recUp(RecommendDto dto) {		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int upCount = 0;
		String sql = " insert into board_recommend values('1','0',?,?) ";
		String sql2 = " select sum(rec_up) from board_recommend where id = ? and b_num = ? ";
		try {
			conn = dataSource.getConnection();			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dto.getB_num());
			pst.setString(2, dto.getId());
			pst.executeUpdate();
			pst.close();
			
			pst = conn.prepareStatement(sql2);
			pst.setString(1, dto.getId());
			pst.setInt(2, dto.getB_num());
		    rs = pst.executeQuery();
		    if( rs.next()) {
		    	upCount = rs.getInt(1);
		    }
			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);		
		}
		return upCount;
	}
	
	public int recdown(RecommendDto dto) {		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int downcnt = 0;
		String sql = " insert into board_recommend values('0','1',?,?) ";
		String sql2 = " select sum(rec_down) from board_recommend where id = ? and b_num = ? ";
		try {
			conn = dataSource.getConnection();			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dto.getB_num());
			pst.setString(2, dto.getId());
			pst.executeUpdate();
			pst.close();
			
			pst = conn.prepareStatement(sql2);
			pst.setString(1, dto.getId());
			pst.setInt(2, dto.getB_num());
		    rs = pst.executeQuery();
		    if( rs.next()) {
		    	downcnt = rs.getInt(1);
		    }
			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);		
		}
		return downcnt;
	}
	
	public boolean recUpConfirm(RecommendDto dto) {
		boolean flag = true;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = " select * from board_recommend where rec_up = 1 and id = ? and b_num = ? ";
		try {
			conn = dataSource.getConnection();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setInt(2, dto.getB_num());
			rs = pst.executeQuery();
			
			if( rs.next()) {
				flag = false;
			}
			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);		
		}
		return flag;
	}
	
	public boolean recdownConfirm(RecommendDto dto) {
		boolean flag = true;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = " select * from board_recommend where rec_down = 1 and id = ? and b_num = ? ";
		try {
			conn = dataSource.getConnection();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setInt(2, dto.getB_num());
			rs = pst.executeQuery();
			
			if( rs.next()) {
				flag = false;
			}
			
		} catch (SQLException e) {		   
			e.printStackTrace();
		}finally {
			close( rs, pst, conn);		
		}
		return flag;
	}
	
	private void close(AutoCloseable... autoCloseables) {
	    for(AutoCloseable a :autoCloseables)
	        try { if(a!=null) a.close(); 
        } catch(Exception e) { 
        	e.printStackTrace(); 
        }
	}
	
}
