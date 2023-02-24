package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {
	private Connection connection = null;
	private Statement statement = null;
	
	public Connection getConnection() {return connection;}
	public Statement getStatement() {return statement;}
	
	public SQLConnector(String id, String pw, String databaseName) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, id, pw);
		
		statement = connection.createStatement();
	}
	
}
