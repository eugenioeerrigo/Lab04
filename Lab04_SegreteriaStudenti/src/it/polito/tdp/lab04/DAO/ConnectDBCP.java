package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectDBCP {       //CONNECTION POOLING

	static private final String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi";
	static private HikariDataSource ds;     
	
	//Pattern SINGLE TONE - istanza (connessione) condivisa con tutti quelli che la richiedono

	public static Connection getConnection() {

		if(ds == null) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setUsername("root");
		config.setPassword("eugi");
		
		// configurazione MySQL
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		ds = new HikariDataSource(config);
		}
		
		try {
			
			return ds.getConnection();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
