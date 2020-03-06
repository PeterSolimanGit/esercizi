package it.objectmethod.world.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/world?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "root";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}