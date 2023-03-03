package com.to.Coonections2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class getbyid {

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

			String sql = "select * from amazon where password = ?";

			pmst = conn.prepareStatement(sql);

			System.out.println("user password : ");

			pmst.setString(1, scr.next());

			ResultSet rs = pmst.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "----"
						+ rs.getString(3) + "-----" + rs.getString(4) + "-----"
						+ rs.getString(5) + "----" + rs.getString(6));

			}

			scr.close();

			conn.close();

			pmst.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
