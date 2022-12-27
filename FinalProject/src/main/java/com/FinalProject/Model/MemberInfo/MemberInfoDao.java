package com.FinalProject.Model.MemberInfo;

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
public class MemberInfoDao {
	@Autowired
	DataSource ds;	
	
	Connection  con= null;
	PreparedStatement pst= null;
	ResultSet rs = null;
	
	//회원가입 정보 입력
	public void insert(MemberInfoDto dto ) {		
		String sql ="INSERT INTO login_info_221208 VALUES(login_seq.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			  con =ds.getConnection();
			  pst = con.prepareStatement(sql );
			  pst.setString(1, dto.getName());
			  pst.setString(2, dto.getJumin());
			  pst.setString(3, dto.getId());
			  pst.setString(4, dto.getPw());	
			  pst.setString(5, dto.getPhone());			  
			  pst.setString(6, dto.getEmail());			  
			  pst.setString(7, dto.getPostcode());
			  pst.setString(8, dto.getRoadAddress());
			  pst.setString(9, dto.getDetailAddress());
			  pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close( pst, con);			
		} 		
	}
	// 아이디 중복확인
	public int checkId(String id) {  
		String sql = "select * from login_info_221208 where id = ?"; // 입력값이 테이블에 있는지 확인
		int idCheck = 0;
	    try {
	    	con =ds.getConnection();
	    	pst = con.prepareStatement(sql);
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
			close(con, pst, rs);
		}
		return idCheck;
	}
	//로그인 회원 정보 조회
	public MemberInfoDto select(String sessionID) {
		MemberInfoDto dto = new MemberInfoDto();
		String sql = "select * from login_info_221208 where id = ?";
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, sessionID);
			rs = pst.executeQuery();
			if(rs.next()) {
				dto.setName(rs.getString(2));
				//dto.setJumin(rs.getString(3));
				dto.setId(rs.getString(4));	
				//dto.setPw(rs.getString(5));	
				dto.setPhone(rs.getString(6));	
				dto.setEmail(rs.getString(7));	
				dto.setPostcode(rs.getString(8));
				dto.setRoadAddress(rs.getString(9));
				dto.setDetailAddress(rs.getString(10));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return dto;
	}
	//수정된 회원정보 DB 입력
	public void update(MemberInfoDto dto) {
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
	//회원정보 삭제 및 탈퇴
	public void delete(String sessionID) {
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
		
		int pwCheck = 0;
	    try {
	    	con =ds.getConnection();
	    	pst = con.prepareStatement(sql);
	    	pst.setString(1, id);
			rs = pst.executeQuery();
			String pw = null;
			if(rs.next()) {
			pw = rs.getString(1);
			}
			if(old_pw.equals(pw)) {
				pwCheck = 1;  // 기존비밀번호가 일치하는 경우, 변경 가능
			} else {
				pwCheck = 0;  // 기존비밀번호가 일치하지 않는 경우, 변경불가 가능
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pst, rs);
		}
		return pwCheck;
	}
	
	public List<MemberInfoDto> searchMember(String id){
		String sql = " select id, grade from login_info_221208 where id like '%" + id + "%' order by grade ";
		List<MemberInfoDto> list = new ArrayList<MemberInfoDto>();
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				MemberInfoDto dto = new MemberInfoDto(rs.getString(1), rs.getString(2));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return list;
	}
	
	public void updateMember(String id, String grade) {
		String sql = " update login_info_221208 set grade = ? where id = ? ";
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, grade);
			pst.setString(2, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst, con);
		}
	}
	
	public void deleteMember(String id) {
		String sql = " delete from login_info_221208 where id = ? ";
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst, con);
		}
		
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
