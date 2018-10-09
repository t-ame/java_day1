package com.java.utils;

import java.io.IOException;
import java.util.Properties;

import com.java.exception.GeneralException;

public class PropertyUtil {

	public static Properties readPropertyFile() throws GeneralException {
		
		Properties p = new Properties();
		
		try {
			p.load(PropertyUtil.class.getResourceAsStream("classpath:/database.properties"));
		} catch (IOException e) {
			throw new GeneralException("Could not read property file: "+e.getMessage());
		}
		
		return p;
	}
	
	
}
