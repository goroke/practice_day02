package app;

import java.sql.SQLException;

import helper.SQLConnector;
import helper.SQLPrinter;

public class Select {
	protected SQLConnector helper = null;
	
	protected void action() throws SQLException {
		SQLPrinter.printData(helper.getStatement(), "select * from goodsinfo", "-5 10 -8 2");
	}

	public Select() {
		try {
			// connection, statement 객체는 SQLHelper 클래스 내부에서 처리합니다.
			helper = new SQLConnector("root", "pw", "malldb");
			action();
		}
		catch (ClassNotFoundException e)	{System.out.println("연결에 실패하였습니다.");}
		catch (SQLException e)				{System.out.println(e.toString());System.out.println("데이터베이스에 연결하지 못했습니다.\n계정이나 데이터베이스 이름을 확인해주세요.");}
	}
	
	public static void main(String[] args) {
		new Select();
	}
}
