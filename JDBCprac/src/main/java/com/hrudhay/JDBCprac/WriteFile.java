package com.hrudhay.JDBCprac;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class WriteFile {

	public static void main(String[] args) throws IOException, SQLException {
		File file = new File("World.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		JDBCconnection jcon = new JDBCconnection();
		ArrayList<String> result = jcon.jdbc();
		//pw.println(result);
		for(int i=0; i<result.size(); i++) {
			if(result.get(i)=="next1!") {
				pw.println("\n");
				continue;
			}
			pw.print(result.get(i)+"-----");
		}
		pw.close();
	}

}
