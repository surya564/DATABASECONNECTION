package com.to.Coonections2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GetAll {

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

			String sql = "select * from amazon";

			pmst = conn.prepareStatement(sql);

			ResultSet rs = pmst.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getInt("id") + "---" + rs.getString("firstname") + "----"
						+ rs.getString("lastname") + "-----" + rs.getString("username") + "-----"
						+ rs.getString("email") + "----" + rs.getString("password"));

			}

			scr.close();

			conn.close();

			pmst.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
