package edu.bookdelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDelete {
	
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
			
			// 삭제 전
			printData(statement.executeQuery("select * from book"), "id title publisher author");
			
			// 1번 책을 삭제한다.
			statement.executeUpdate("delete from book where id=1");
			
			// 결과물
			printData(statement.executeQuery("select * from book"), "id title publisher author");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
