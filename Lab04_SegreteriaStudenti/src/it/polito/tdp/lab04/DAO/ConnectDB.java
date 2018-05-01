package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static private final String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi?user=root&password=eugi";
	static private Connection connection = null;     
	
	//Pattern SINGLE TONE - istanza (connessione) condivisa con tutti quelli che la richiedono

	public static Connection getConnection() {

		try {
			if (connection == null) {
				connection = DriverManager.getConnection(jdbcUrl);
			}
			return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
