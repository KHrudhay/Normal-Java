package com.hrudhay.JDBCprac;

import java.sql.*;

public class JDBCconnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/world&useSSL=true", user = "root", password = "Mental1@",
				query = "select * from city where CountryCode='IND'";
		Class.forName("com.mysql.jdbc.Driver");
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
