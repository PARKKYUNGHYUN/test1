package com.javalac.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.javalac.spring.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/orcl");
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from mvc_board";
			stmt = conn.prepareStatement(query);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				int bId = resultSet.getInt("bId");
			}
			
		} catch (Exception e) {
			
		}finally {
			
		}
		
		return dtos;
	}
}
