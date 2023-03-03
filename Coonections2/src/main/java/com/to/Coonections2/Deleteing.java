package com.to.Coonections2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Deleteing {

	public static final String Driver = "com.mysql.cj.jdbc.Driver";

	public static final String URL = "jdbc:mysql://localhost:3306/surya12";

	public static final String username = "root";

	public static final String password = "root";

	public static Connection conn;

	public static PreparedStatement pmst;
	
	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		
		try {
			
			Class.forName(Driver);
			
			conn = DriverManager.getConnection(URL, username, password);
			
			String sql ="delete from amazon where username = ?";
			
			pmst = conn.prepareStatement(sql);
			
			System.out.println("enter the username : ");
			
			pmst.setString(1, scr.next());
		
			int i = pmst.executeUpdate();
			
			if(i>0) {
				
				System.out.println("deleted successfully");
			}
			else
			{
				System.out.println("error");
			}
			
			scr.close();
			
			
			conn.close();
			
			pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
