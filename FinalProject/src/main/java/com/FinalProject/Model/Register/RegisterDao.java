package com.FinalProject.Model.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDao {
	@Autowired
	DataSource datasource;	
	
	Connection  conn= null;
	PreparedStatement pst= null;
	ResultSet rs = null;
	
	//회원가입 정보 입력
	public void insert(RegisterDto dto ) {		
		
		String sql ="INSERT INTO login_info_221208 VALUES(login_seq.nextval,?,?,?,?,?,?,?,?)";
				
		try {
			  conn =datasource.getConnection();
			  pst = conn.prepareStatement(sql );
			  pst.setString(1, dto.getName());
			  pst.setString(2, dto.getJumin());
			  pst.setString(3, dto.getId());
			  pst.setString(4, dto.getPw());	
			  pst.setString(5, dto.getPhone());			  
			  pst.setString(6, dto.getEmail());			  
			  pst.setString(7, dto.getPostcode());
			  pst.setString(8, dto.getAddress());
			  pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close( pst, conn);			
		} 		
	}
	
	// 아이디 중복확인
	public int checkId(String id) {  
		
		String sql = "select * from login_info_221208 where id = ?"; // 입력값이 테이블에 있는지 확인
		
		int idCheck = 0;
	    try {
	    	conn =datasource.getConnection();
	    	pst = conn.prepareStatement(sql);
	    	pst.setString(1, id);
			rs = pst.executeQuery();
					
			if(rs.next() || id.equals("")) {
				idCheck = 0;  // 이미 존재하는 경우, 생성 불가능
			} else {
				idCheck = 1;  // 존재하지 않는 경우, 생성 가능
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pst, rs);
		}
		return idCheck;
	}
	
	public List<RegisterDto> searchMember(String id){
		
		String sql = " select id, grade from login_info_221208 where id like '%"+id+"%' ";
		List<RegisterDto> list = new ArrayList<RegisterDto>();
		try {
			conn = datasource.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				RegisterDto dto = new RegisterDto(rs.getString(1), rs.getString(2));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pst, conn);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	private void close(AutoCloseable ...autoCloseables) {
		for( AutoCloseable   a:  autoCloseables) {
			try {
				if( a != null ) a.close();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
