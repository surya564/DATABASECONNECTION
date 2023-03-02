package com.to.Coonections2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class App1 {

	

    public static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    
    public static final String URL ="jdbc:mysql://localhost:3306/surya12";
    
    public static final String USERNAME ="root";
    
    public static final String PASSWORD ="root"; 

    public static Connection conn;

	  public static PreparedStatement pmst;
	
	
  public static void main( String[] args )
  {
  	
  	Scanner scr = new Scanner(System.in);
  	
      try {
			
      	Class.forName(DRIVER);
      	
      	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      	
      	System.out.println("enter the table : ");
      	
      	String sql ="create table "+scr.next()+"(id int , name varchar(20),city varchar(20))";
      	
      	pmst = conn.prepareStatement(sql);
      	
      	int i =pmst.executeUpdate();
      	
      	if(i==0) {
      		
      		System.out.println("successfully inserted");
      	}
      	else
      	{
      		System.out.println("error");
      	}
      	
      	pmst.close();
      	scr.close();
      	conn.close();
      	
		} catch (Exception e) {
			e.printStackTrace();
		}
  	
  	
  }
	
}
