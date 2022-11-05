package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.DatabaseMetaData;

public class JDBCUtil {
	// - Tạo lớp connection
	public static Connection getConnection() {
		Connection c = null;

		try {
			// Đăng kí Mysql Driver với DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/demojava";
			String username = "root";
			String password = "";

			// Tạo kết nối
			c = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
