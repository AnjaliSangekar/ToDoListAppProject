package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.BO.UserBO;
import com.mysql.cj.protocol.Resultset;

public class Dao {

	
	public static Connection getConection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Todo", "root", "Codenera@123");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	public static int signup(UserBO ob1)
	{
		int status = 0;
		
		try
		{
			Connection con = Dao.getConection();
			
			String sql = "insert into signup(name, email, username, password) values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ob1.getName());
			ps.setString(2, ob1.getEmail());
			ps.setString(3, ob1.getUsername());
			ps.setString(4, ob1.getPassword());
			
			status = ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public static boolean loginvalid(String username, String phone)
	{
		boolean status = false;
		
		try
		{
			
			Connection con = Dao.getConection();
			
			String sql = "select * from signup where username=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, phone);
			
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}

}


