package com.FinalProject.Model.Mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FinalProject.Model.Register.RegisterDto;

@Component
public class MypageDao {
	
	@Autowired
	DataSource ds;
	
	public RegisterDto select(String sessionID) {
		System.out.println(sessionID);
		RegisterDto dto = new RegisterDto();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from login_info_221208 where id = ?";
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, sessionID);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString(1));
				dto.setName(rs.getString(2));
				//dto.setJumin(rs.getString(3));
				dto.setId(rs.getString(4));	
				dto.setPw(rs.getString(5));	
				dto.setPhone(rs.getString(6));	
				dto.setEmail(rs.getString(7));	
				dto.setAddress(rs.getString(8));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return dto;
	}
	
	private void close(AutoCloseable ...autoCloseables) {
		for(AutoCloseable a: autoCloseables) {
			if(a!=null) {
				try {
					a.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
