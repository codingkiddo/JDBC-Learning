package com.jdbc.learning;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;

public class DatabaseContextFactory implements InitialContextFactory, InitialContextFactoryBuilder {

	@Override
	public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
		return new DatabaseContextFactory();
	}

	@Override
	public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
		return new DatabaseContext();
	}

}
