package app;

import java.sql.SQLException;
import helper.SQLPrinter;

public class Statistics extends Select {
	@Override
	protected void action() throws SQLException {
		SQLPrinter.printData(helper.getStatement(), "select avg(price) from goodsinfo", "-5 10 -8 2");
	}
	
	public static void main(String[] args) {
		new Statistics();
	}
}
