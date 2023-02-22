package edu.jdbcexone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExOne {
	
	private static void printData(ResultSet s, String[] x) throws SQLException {
		while (s.next()) {
			for(String a:x) System.out.printf("%10s|", s.getString(a));
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("JDBC Start");
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/malldb?useSSL=false&serverTimezone=Asia/Seoul",
					"root", "pw");
			
			if (conn != null) System.out.println("연결 성공");
			
			Statement statement = conn.createStatement();
			
			String[] query = {"userID",
							  "userName",
							  "birthYear",
							  "addr",
							  "mobile1",
							  "mobile2",
							  "height",
							  "mDate"};
			
			System.out.println("<userTbl 정보>");
			printData(statement.executeQuery("select * from userTbl"), query);
			
			String[] query2 = {"num",
					 		   "userID",
					 		   "prodName",
					 		   "groupName",
					 		   "price",
					 		   "amount"};
	
	System.out.println("\n<buyTbl 정보>");
	printData(statement.executeQuery("select * from buyTbl"), query2);
			
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
		}
		
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		
		finally {
			try {
				conn.close();
				System.out.println("연결을 해제합니다.");
			}
			catch (Exception e) {e.getStackTrace();}
		}
		
	}
}
