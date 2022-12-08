package com.FinalProject.Model.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDao {
	@Autowired
	DataSource datasource;	
	
		//ȸ������ ���� �Է�
		public void insert(RegisterDto dto ) {		
			System.out.println("insert�޼ҵ�");
			String sql ="INSERT INTO login_info_221208 VALUES(login_seq.nextval,?,?,?,?,?,?,?)";
			Connection  conn= null;
			PreparedStatement pst= null;		
			try {
				  conn =datasource.getConnection();
				  pst = conn.prepareStatement(sql );
				  pst.setString(1, dto.getName());
				  pst.setString(2, dto.getJumin());
				  pst.setString(3, dto.getId());
				  pst.setString(4, dto.getPw());	
				  pst.setString(5, dto.getPhone());			  
				  pst.setString(6, dto.getEmail());			  
				  pst.setString(7, dto.getAddress());			  
				  pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close( pst, conn);			
			} 		
		}
		// ���̵� �ߺ�Ȯ��
		public int checkId(String id) {  
			String sql = "select * from login_info_221208 where id = ?"; // �Է°��� ���̺� �ִ��� Ȯ��
			Connection  conn= null;
			PreparedStatement pst= null;
			ResultSet rs = null;
			int idCheck = 0;
		    try {
		    	conn =datasource.getConnection();
		    	pst = conn.prepareStatement(sql);
		    	pst.setString(1, id);
				
				rs = pst.executeQuery();
						
				if(rs.next() || id.equals("")) {
					idCheck = 0;  // �̹� �����ϴ� ���, ���� �Ұ���
				} else {
					idCheck = 1;  // �������� �ʴ� ���, ���� ����
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(conn, pst, rs);
			}
			return idCheck;
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
