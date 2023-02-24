package app;

import java.sql.SQLException;
import helper.SQLConnector;
import helper.SQLPrinter;

public class Insert {
	
	private static SQLConnector helper = null;

	private static void insert(String code, String name, int price, String maker) throws SQLException {
		StringBuilder sb = new StringBuilder("insert into goodsinfo value (");
		sb.append('\'')
		  .append(code).append("', '")
		  .append(name).append("', ")
		  .append(price).append(", '")
		  .append(maker).append("');");
		
		helper.getStatement().executeUpdate(sb.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// connection, statement 객체는 SQLHelper 클래스 내부에서 처리합니다.
			helper = new SQLConnector("root", "pw", "malldb");
			
			insert("10004", "로봇청소기", 1000000, "LG");
			insert("10005", "스마트폰", 350000, "SS");
			insert("10006", "세탁기", 800000, "DW");
			insert("10007", "휴대폰충전기", 12000, "SS");
			
			SQLPrinter.printData(helper.getStatement(), "select * from goodsinfo", "5 -10 8 -2");
		}
		catch (ClassNotFoundException e)	{System.out.println("연결에 실패하였습니다.");}
		catch (SQLException e)				{System.out.println(e.toString());System.out.println("데이터베이스 관련 오류가 발생하였습니다.");}
	}

}
