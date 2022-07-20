package com.jdbc.learning;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JndiServiceBean {

	public void startProcess() throws NamingException, SQLException {
	
		DataSource ds = (DataSource) new InitialContext().lookup("jdbc/ds1");
		Connection connection  = ds.getConnection();
		connection.close();
	
		System.out.println("Done !!!");
	}
}
