package com.to.Coonections2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insertion {

//	crud operation
	
//	insertion   -- completed     -- update
//	deleting    -- completed     -- update
//	getbyid     -- completed     -- query
//	getall;     -- completed     -- query
//	update;     --incomplete
	
	
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

			String sql = "insert into amazon(firstname,lastname,username,email,password) values (?,?,?,?,?)";

			pmst = conn.prepareStatement(sql);
			
			System.out.println("enter the firstname : ");

			pmst.setString(1, scr.next());

			System.out.println("enter the lastname :");

			pmst.setString(2, scr.next());

			System.out.println("enter the username :");

			pmst.setString(3, scr.next());
			
			System.out.println("enter the email :");
			
			pmst.setString(4, scr.next());
			
			System.out.println("enter the password :");
			
			pmst.setString(5, scr.next());

			int i = pmst.executeUpdate();

			if (i > 0) {

				System.out.println("successfully inserted");
				
			} 
			else
			{
				System.out.println("error occured");
			}
			scr.close();

			conn.close();

			pmst.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
