package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BO.ListBO;
import com.BO.ListBO1;
import com.mysql.cj.protocol.Resultset;

public class Listdao {

	public static Connection getConnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo", "root", "Codenera@123");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}

	
	public static int addlist(ListBO ob1)
	{
		int status = 0;
		
		try
		{
			Connection con = Listdao.getConnection();
			
			String sql = "insert into ToDoList(list) values(?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
		
			ps.setString(1, ob1.getList());
			
			status = ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public static List getdata()
	{
		ArrayList<ListBO> list = new ArrayList<ListBO>();
		
		try
		{
			Connection con = Listdao.getConnection();
			
			String sql = "select * from ToDoList";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ListBO ob = new ListBO();
				
				ob.setId(rs.getInt(1));
				
				ob.setList(rs.getString(2));
				
				list.add(ob);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static int delete(int id)
	{
		int status = 0;
		
		try 
		{
			Connection con = Listdao.getConnection();
			
			String sql = "delete from ToDoList where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	// REMOVE DATA
	
	public static int adddata(int id)
	{
		int result = 0;
		int status = 0;
 		try
		{
			Connection con = Listdao.getConnection();
			
			String sql = "INSERT into ToDoList2 (List) SELECT List from ToDoList where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			String sql1 = "Delete from ToDoList where id=?";
			
			PreparedStatement ps1 = con.prepareStatement(sql1);
			
			ps.setInt(1, id);
			//ps.setString(2, List);
			
			result = ps.executeUpdate();
			
			ps1.setInt(1, id);
			
			status = ps1.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static List getalldata()
	{
		ArrayList<ListBO1> list = new ArrayList<ListBO1>();
		
		try
		{
			Connection con = Listdao.getConnection();
			
			String sql = "select * from ToDoList2";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ListBO1 ob = new ListBO1();
				
				ob.setId(rs.getInt(1));
				
				ob.setList(rs.getString(2));
				
				list.add(ob);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static int movedelete(int id)
	{
		int status = 0;
		
		try 
		{
			Connection con = Listdao.getConnection();
			
			String sql = "delete from ToDoList2 where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	
	public static int movedata(int id)
	{
		int result = 0;
		int status = 0;
		
 		try
		{
			Connection con = Listdao.getConnection();
			
			String sql = "INSERT into ToDoList (List) SELECT List from ToDoList2 where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			String sql1 = "Delete from ToDoList2 where id=?";
			
			PreparedStatement ps1 = con.prepareStatement(sql1);
			
			ps.setInt(1, id);
			//ps.setString(2, List);
			
			result = ps.executeUpdate();
			
			ps1.setInt(1, id);
			
			status = ps1.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
}
