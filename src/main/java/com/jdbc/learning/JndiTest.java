package com.jdbc.learning;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.naming.spi.NamingManager;

public class JndiTest {

	public static void main(String[] args) throws NamingException, SQLException {
		
		NamingManager.setInitialContextFactoryBuilder(new DatabaseContextFactory());
		
		JndiServiceBean bean = new JndiServiceBean();
		bean.startProcess();
	}

}
