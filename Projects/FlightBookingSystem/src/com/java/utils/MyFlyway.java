package com.java.utils;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;

public class MyFlyway extends Flyway {

	private BasicDataSource ds;
	private String url = "jdbc:oracle:thin:@localhost:1521:ORCL12C";
	private String username = "sys as sysdba";
	private String password = "oracle";
	private String driverName = "oracle.jdbc.driver.OracleDriver";

	static Flyway flyway = null;

	private MyFlyway() {
		super();
		configureDS();

		this.setBaselineOnMigrate(true);
		this.setValidateOnMigrate(true);
		this.setLocations("classpath:/migration");
		this.setDataSource(ds);
	}

	private void configureDS() {
		ds.setUrl(url);
		ds.setPassword(password);
		ds.setUsername(username);
		ds.setDriverClassName(driverName);
		ds.setMaxIdle(20);
		ds.setMaxConnLifetimeMillis(3000);
		ds.setMaxTotal(100);
		ds.setMaxWaitMillis(3000);
	}

	//confirm synchronized necessary...
	public static Flyway getFlyway() {
		if (flyway == null) {
			synchronized (MyFlyway.class) {
				if (flyway == null)
					flyway = new MyFlyway();
			}
		}
		return flyway;
	}

}
