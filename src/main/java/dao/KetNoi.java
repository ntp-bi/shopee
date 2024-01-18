package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://LAPTOP-A8SPAK1P\\BI:1433;databaseName=QLSach;user=sa; password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
}
