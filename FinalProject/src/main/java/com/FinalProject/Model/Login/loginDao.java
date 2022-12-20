package com.FinalProject.Model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class loginDao {

	@Autowired
	DataSource ds;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public int loginConfirm(loginDto dto) {
		
		String sql = " select pw from login_info_221208 where id = ? ";
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, dto.getId());
			rs = pst.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(dto.getPw())) return 1;
				else return 0;
			}else	return -1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return 0;
	}
	
	public String findID(loginDto dto) {
		
		String sql = " select id from login_info_221208 where name = ? and jumin = ? and email = ? ";
		String id = "";
		
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getJumin());
			pst.setString(3, dto.getEmail());
			rs = pst.executeQuery();
			
			if(rs.next()) {
				id = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return id;
	}
	
	public String findPW(loginDto dto) {
		
		String sql = " select pw from login_info_221208 where id = ? and name = ? and jumin = ? and email = ? ";
		String id = "";
		
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getName());
			pst.setString(3, dto.getJumin());
			pst.setString(4, dto.getEmail());
			rs = pst.executeQuery();
			
			if(rs.next()) {
				id = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return id;
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
