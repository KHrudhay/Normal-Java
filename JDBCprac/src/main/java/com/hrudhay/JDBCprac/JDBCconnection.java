package com.hrudhay.JDBCprac;

import java.sql.*;

public class JDBCconnection {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/world", user = "root", password = "Mental1@",
				query = "select * from city where CountryCode='IND'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String result = rs.getString("Name");
		System.out.println(result);
		st.close();
		con.close();
	}

}
