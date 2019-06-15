package com.xtkj.jspt3.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	static ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getCon() throws SQLException{
		return dataSource.getConnection();
	}
	
	public static void releaseCon(Connection con,PreparedStatement ps,ResultSet rs){
		try {
			con.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void releasePs(PreparedStatement ps,ResultSet rs){
		try {
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void closeCon(Connection con){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void closePs(PreparedStatement ps){
		try{
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void closeRs(ResultSet rs){
		try{
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
