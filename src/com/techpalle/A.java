package com.techpalle;

import java.sql.*;

public class A 
{
	Connection con = null;
	Statement s = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static String url = "jdbc:mysql://localhost:3306/jdbc";
	public static String  username = "root";
	public static String password = "Vandhu";
public void creating()
{
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 con = DriverManager.getConnection(url, username,password);
		 
		 s = con.createStatement();
		 
		 s.executeUpdate("create table student1(sno int primary key auto_increment, "
		 		+ "sname varchar(40) not null,sub varchar(40),email varchar(50) unique)");
		 } 
	catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	finally 
	{
		if(s!= null) 
		{
			try 
			{
				s.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		if(con != null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

public void inserting(String name, String sub, String email) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
    con = DriverManager.getConnection(url, username, password);
    
    ps = con.prepareStatement("insert into student1(sname, sub, email) values(?,?,?)");
    ps.setString(1, name);
    ps.setString(2, sub);
    ps.setString(3, email);
    
    ps.executeUpdate();
    
    ps.close();
    con.close();
    
}
public void updating(int no, String name, String sub, String email) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
    con = DriverManager.getConnection(url, username, password);
    
    ps = con.prepareStatement("update student1 set sname=?,sub=?, email=? where sno=?");
    ps.setString(1, name);
    ps.setString(2, sub);
    ps.setString(3, email);
    ps.setInt(4, no);
    
    ps.executeUpdate();
    
    ps.close();
    con.close();

}

public void deleting(int no) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
    con = DriverManager.getConnection(url, username, password);
    
    ps = con.prepareStatement("delete from student1 where sno = ?");
    ps.setInt(1, no);
    
    ps.executeUpdate();
    
    ps.close();
    con.close();

}

public void reading() throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
    con = DriverManager.getConnection(url, username, password);
    
    String qry = "select sname from student1";
    
    s = con.createStatement();   
    rs = s.executeQuery(qry);
    
    while(rs.next()) 
    {
    	System.out.println(rs.getString("sname"));
    }
    rs.close();
    s.close();
    con.close();

}




}
