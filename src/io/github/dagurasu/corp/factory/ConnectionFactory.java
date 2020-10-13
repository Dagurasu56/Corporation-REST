package io.github.dagurasu.corp.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/corporation";
	static final String USER = "root";
	static final String PASSWORD = "";

	public Connection createConnection() {

		Connection con = null;

		try {

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);

		} catch (Exception e) {
			System.out.println("Error creating database connection: " + DB_URL);
			e.printStackTrace();
		}

		return con;
	}

	public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {

		try {

			if (con != null) {
				con.close();
			}

			if (ps != null) {
				ps.close();
			}

			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("Error closing connection to the database: " + DB_URL);
		}
	}

}
