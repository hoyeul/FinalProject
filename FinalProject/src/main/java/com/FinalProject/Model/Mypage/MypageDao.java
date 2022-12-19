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
	
	public RegisterDto Select(String sessionID) {
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
				//System.out.println(rs.getString(1));
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
	
	public void update(MypageDto dto) {
		System.out.println("updateDao");
		System.out.println(dto);
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "UPDATE login_info_221208 SET pw=?, phone=?, email=?, postcode=?, roadaddress=?, detailaddress=? WHERE id = ?";
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, dto.getPw());
			pst.setString(2, dto.getPhone());
			pst.setString(3, dto.getEmail());
			pst.setString(4, dto.getPostcode());
			pst.setString(5, dto.getRoadAddress());
			pst.setString(6, dto.getDetailAddress());
			pst.setString(7, dto.getId());

			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
	}
	
	//회원탈퇴
	public void delete(String sessionID) {
		System.out.println(sessionID);
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "DELETE FROM login_info_221208 WHERE id = ?";
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, sessionID);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
	}
	// 기존비밀번호 일치 확인
			public int checkOldPw(String id, String old_pw) {  
				String sql = "select pw from login_info_221208 where id = ?"; // 입력값이 테이블에 있는지 확인
				Connection  conn= null;
				PreparedStatement pst= null;
				ResultSet rs = null;
				int pwCheck = 0;
			    try {
			    	conn =ds.getConnection();
			    	pst = conn.prepareStatement(sql);
			    	pst.setString(1, id);
					rs = pst.executeQuery();
					String pw = null;
					if(rs.next()) {
					pw = rs.getString(1);
					}
					if(old_pw.equals(pw)) {
						pwCheck = 1;  // 기존비밀번호가 일치하는 경우, 변경 가능
						//System.out.println(pwCheck);
					} else {
						pwCheck = 0;  // 기존비밀번호가 일치하지 않는 경우, 변경불가 가능
						//System.out.println(pwCheck);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(conn, pst, rs);
				}
				return pwCheck;
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
