package com.example.demo.repository;

//import java.io.*;
import java.sql.*;

import com.example.demo.common.ConnectionHelper;

public class MovieRepository {
	
	public String getMovies() throws Exception {
		
//		String query = "\"SELECT DISTINCT m.\\\"Id\\\" AS \\\"MovieId\\\", m.\\\"Title\\\" AS \\\"MovieTitle\\\", m.\\\"Runtime\\\", m.\\\"YearOfRelease\\\", m.\\\"Image\\\", \" +\r\n"
//				+ "                \"AVG(r.\\\"Score\\\") AS \\\"AverageScore\\\", \" +\r\n"
//				+ "                \"COALESCE((SELECT STRING_AGG(g1.\\\"Title\\\", ',') FROM \\\"Genre\\\" g1 INNER JOIN \\\"MovieGenre\\\" mg1 ON mg1.\\\"GenreId\\\" = g1.\\\"Id\\\" "
//				+ "WHERE mg1.\\\"MovieId\\\" = m.\\\"Id\\\"), '') AS \\\"GenreTitle\\\", \" +\r\n"
//				+ "\"COALESCE(STRING_AGG(DISTINCT CONCAT(a.\\\"FirstName\\\", ' ', a.\\\"LastName\\\"), ', '), '') AS \\\"ActorNames\\\" \" +\r\n"
//				+ "\"FROM \\\"Movie\\\" m \" " + 
//				"LEFT JOIN \"MovieGenre\" mg ON mg.\"MovieId\" = m.\"Id\" " +
//                "LEFT JOIN \"Genre\" g ON g.\"Id\" = mg.\"GenreId\" " +
//                "LEFT JOIN \"ActorMovie\" am ON am.\"MovieId\" = m.\"Id\" " +
//                "LEFT JOIN \"Actor\" a ON a.\"Id\" = am.\"ActorId\" " +
//                "LEFT JOIN \"Review\" r ON r.\"MovieId\" = m.\"Id\" " +
//                "LEFT JOIN \"WatchList\" wl ON wl.\"MovieId\" = m.\"Id\" ";
		
		StringBuilder resultStr = new StringBuilder();
		String query = "SELECT * FROM \"Movie\"";
				
		Connection con = ConnectionHelper.getConnection();

		Statement st = con.createStatement();
		ResultSet result = st.executeQuery(query);
		while(result.next()) {
			String title = result.getString("Title");
			resultStr.append(title + " ");
		}
		
		con.close();
		return resultStr.toString();
	}
}
