package com.FinalProject.Model.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegDao {
	@Autowired
	DataSource datasource;	
	
	//insert	
		public void insert(CustomerDto customer ) {		
			String sql ="insert into customer_tbl  values(?,?,?,?,?,?,?)";
			Connection  conn= null;
			PreparedStatement pst= null;		
			try {
				  conn =datasource.getConnection();
				  pst = conn.prepareStatement(sql );
				  pst.setString(1, customer.getUser_nm());
				  pst.setString(2, customer.getUser_id());
				  pst.setString(3, customer.getUser_pw());
				  pst.setString(4, customer.getUser_phone());	
				  pst.setString(5, customer.getUser_email());			  
				  pst.setString(6, customer.getUser_address());			  
				  pst.setString(7, customer.getUser_regnum());			  

				  pst.execute();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close( pst, conn);			
			} 		
		}
		public int checkId(String id) {  // 유저가 입력한 값을 매개변수로 한다
			String sql = "select * from customer_tbl where user_id = ?"; // 입력값이 테이블에 있는지 확인
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
					idCheck = 0;  // 이미 존재하는 경우, 생성 불가능
				} else {
					idCheck = 1;  // 존재하지 않는 경우, 생성 가능
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
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
