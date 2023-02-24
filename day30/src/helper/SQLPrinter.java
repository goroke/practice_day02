package helper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLPrinter {

	public static void printData(Statement statement, String query, String length) throws SQLException {
		
		ResultSet s = statement.executeQuery(query);
		ResultSetMetaData sm = s.getMetaData();
		List<String> columnHead = new ArrayList<>();
		
		String[] lengthArray = length.split(" ");
		
		int c;
		for(c = 0; c < sm.getColumnCount();) {
			String head = sm.getColumnLabel(c+1);
			if(c > 0) System.out.print("|");
			System.out.printf("%" + lengthArray[c++] + "s", head);
			columnHead.add(head);
		}
		
		
		System.out.println();
		
		while (s.next()) {
			c = 0;
			
			for(String a: columnHead) {
				if(c > 0) System.out.print("|");
				System.out.printf("%" + lengthArray[c++] + "s", s.getString(a));
			}
			
			System.out.println();
		}
	}
}
