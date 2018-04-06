package edu.ben.connection;

import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ConnectionPool {

	// JDBC Driver Name & Database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/assignmentracker";

	// JDBC Database Credentials
	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "password";

	private static GenericObjectPool gPool = null;

	public static DataSource setUpPool() throws Exception {
		Class.forName(JDBC_DRIVER);

		gPool = new GenericObjectPool();
		gPool.setMaxActive(10);

		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL + "?autoReconnect=true&useSSL=false",
				JDBC_USER, JDBC_PASS);

		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		return new PoolingDataSource(gPool);
	}

	public static GenericObjectPool getConnectionPool() {
		return gPool;
	}

	public static void printDbStatus() {
		System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: "
				+ getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
	}
}