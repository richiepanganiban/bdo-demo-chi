package com.bdo.demo.dao;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.hsqldb.server.ServerConfiguration;

public class HSQLServerUtil {

	private HSQLServerUtil() {
		// Utility class
	}

	public static HSQLServerUtil getInstance() {
		return HSQL_SERVER_UTIL;
	}

	private static final Logger LOGGER = Logger.getLogger(HSQLServerUtil.class);

	private static final HSQLServerUtil HSQL_SERVER_UTIL = new HSQLServerUtil();

	private Server hsqlServer;

	public void start(String dbName) {
		HsqlProperties properties = new HsqlProperties();
		properties.setProperty("server.database.0", dbName);
		properties.setProperty("server.dbname.0", dbName);

		ServerConfiguration.translateDefaultDatabaseProperty(properties);

		hsqlServer = new Server();
		hsqlServer.setRestartOnShutdown(false);
		hsqlServer.setNoSystemExit(true);
		try {
			hsqlServer.setProperties(properties);
		} catch (IOException e) {
			LOGGER.info("IOException on setting Hsql Server Properties on BaseDaoTest");
		} catch (AclFormatException e) {
			LOGGER.info("AclFormatException on setting Hsql Server Properties on BaseDaoTest");
		}
		hsqlServer.start();
	}

	public void stop() {
		hsqlServer.stop();
	}
}
