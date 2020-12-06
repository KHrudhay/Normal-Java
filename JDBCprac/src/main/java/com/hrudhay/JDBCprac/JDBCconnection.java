package com.hrudhay.JDBCprac;

import java.sql.*;
import java.util.ArrayList;

public class JDBCconnection {

	Connection con;
	Statement st;

	ArrayList<String> jdbc() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/world", user = "root", password = "new1@Pass",
				query = "SELECT * FROM city WHERE CountryCode='IND'";
		con = DriverManager.getConnection(url, user, password);
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		ArrayList<String> tData = new ArrayList<String>();
		for (int i = 1; i <= rsmd.getColumnCount() + 1; i++) {
			if (i == rsmd.getColumnCount() + 1) {
				tData.add("next1!");
				continue;
			}
			tData.add(rsmd.getColumnLabel(i));
		}
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount() + 1; i++) {
				if (i == rsmd.getColumnCount() + 1) {
					tData.add("next1!");
					continue;
				}
				tData.add(rs.getString(i));
			}
		}
		st.close();
		con.close();
		return tData;
	}

}
