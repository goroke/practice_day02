package edu.booksearchupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookSearchUpdate {
	
	private static void printData(ResultSet s, String x) throws SQLException {
		int c = 0;
		for(String a:x.split(" ")) System.out.printf("%s%-25s", (c++>0?"|":""), a);
		System.out.println();
		
		while (s.next()) {
			c = 0;
			for(String a:x.split(" ")) {
				if(c++>0) System.out.print("|");
				System.out.printf("%-25s", s.getString(a));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "pw");
			Statement  statement = conn.createStatement();

			// 정보 변경 전
			printData(statement.executeQuery("select * from book where id = 0;"), "id title publisher author");
			
			// 정보 변경
			statement.executeUpdate("update book set title='Harry Potter' where id = 0;");
			
			// 정보 변경 후
			printData(statement.executeQuery("select * from book where id = 0;"), "id title publisher author");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
