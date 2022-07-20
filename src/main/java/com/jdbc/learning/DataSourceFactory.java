package com.jdbc.learning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceFactory {
	
	public static DataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
//		A DataSource object has properties that can be modified when necessary. 
//		For example, if the data source is moved to a different server, 
//		the property for the server can be changed. The benefit is that because 
//		the data source's properties can be changed, any code accessing that data 
//		source does not need to be changed.
//		What is DataSource in Jdbc what are its benefits?
//				The major benefit of Java DataSource is when it's used within 
//				a Context and with JNDI. With simple configurations we can create 
//				a Database Connection Pool that is maintained by the Container itself.
//		Why do we need connection pooling?
//				Using connection pools helps to both alleviate connection 
//				management overhead and decrease development tasks for data access. 
//				Each time an application attempts to access a backend store (such as a database), 
//				it requires resources to create, maintain, and release a connection to that datastore.
		MysqlDataSource mysqlDS = null;
		try {
			fis = new FileInputStream("/Users/vinodkumar/Documents/Technologies/Java/java-workspace/JDBC-Learning/src/main/resources/db.properties");
			props.load(fis);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}

	public static BasicDataSource getBasicDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		BasicDataSource ds = null;
		try {
			fis = new FileInputStream("/Users/vinodkumar/Documents/Technologies/Java/java-workspace/JDBC-Learning/src/main/resources/db.properties");
			props.load(fis);
			ds = new BasicDataSource();
			ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
			ds.setUrl(props.getProperty("MYSQL_DB_URL"));
			ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
			ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
			ds.setInitialSize(10); // The initial number of connections that
            // are created when the pool is started.
			ds.setMaxTotal(20); // The maximum number of active connections
            // that can be allocated from this pool

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
