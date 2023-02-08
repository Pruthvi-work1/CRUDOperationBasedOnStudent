package com.techpalle;

import java.sql.SQLException;

public class MyProgram {

	public static void main(String[] args) {
		A a = new A();
		
		//a.creating();
		
		try {
			//a.inserting("santhosh", "maths","santhu@gmail.com");
			//a.inserting("harish", "java","harish@gmail.com");
			
			//a.updating(4, "shoyab", "devops", "sona@gmail.com");
			
			//a.deleting(1);
			 a.reading();
			
			
		} 
		catch (ClassNotFoundException e) 
		{
		e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
       
	}

}
