package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HrCreateInsert 
{
	static String url ="jdbc:mysql://localhost:3306/jeejava";
    static String user ="root";
    static String pass ="admin";
    
    static String createtable = "create table hr(id int auto_increment primary key,name varchar(20),email varchar(30) unique not null,exp int ,mobile bigint not null)";

    static String insert ="insert into hr values (?,?,?,?,?)";
    
    static String delete ="delete from hr where id = ?";
    
    static String update = "update hr set name =?, email =? where id = ?";
    
    static Connection con = null;
    static Statement s = null;
    static PreparedStatement ps = null; 
    static ResultSet rs = null;
    public static void create() 
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con =DriverManager.getConnection(url,user,pass);
			s= con.createStatement();
			s.executeUpdate(createtable);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	finally
    	{
    		try {
				s.close();
				con.close();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    }

	public static void insert(int id , String name , String email, int exp , long mobile)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url,user,pass);
			ps = con.prepareStatement(insert);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setInt(4, exp);
			ps.setLong(5, mobile);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public static void delete(int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url,user,pass);
			ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void update(String name , String email , int id )

   {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	       con=DriverManager.getConnection(url, user, pass);
			
			ps = con.prepareStatement(update);
	        ps.setString(1, name);
	        ps.setString(2, email);
	        ps.setInt(3, id);
	        ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
		}
	
	public static ArrayList<Hr> display()
	{
		ArrayList<Hr> al = new ArrayList<Hr>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			 s = con.createStatement();
	    	 rs = s.executeQuery("select * from hr");
	    	 while(rs.next())
	    	 {
	    		 int id = rs.getInt("id");
	    		 String name = rs.getString("name");
	    		 String email = rs.getString("email");
	    		 int exp = rs.getInt("exp");
	    		 long mobile = rs.getLong("mobile");
	    		 Hr h = new Hr(id ,name ,email,exp ,mobile);
	    		 al.add(h);
	    	 }
	     
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
		
	}
	
}
