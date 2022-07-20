package com.jdbc.learning;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseContext extends InitialContext {

	static final String DB_URL1 = "jdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true&useSSL=false";
	static final String DB_URL2 = "jdbc:mysql://localhost:3306/sakila?allowPublicKeyRetrieval=true&useSSL=false";
	static final String USER = "root";
	static final String PASS = "12345678";
	
	public DatabaseContext() throws NamingException {
		super();
	}

	@Override
    public Object lookup(String name) throws NamingException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			DataSource ds1 = new LocalDataSource(DB_URL1, USER, PASS);
			DataSource ds2 = new LocalDataSource(DB_URL2, USER, PASS);
			
			Properties properties = new Properties();
			properties.put("jdbc/ds1", ds1);
			properties.put("jdbc/ds2", ds2);
			
			Object value = properties.get(name);
			return (value != null) ? value : super.lookup(name); 
		} catch (ClassNotFoundException e) {
			System.err.println("Lookup Problem " + e.getMessage());
            e.printStackTrace();

		}
		return null;
	}
}
