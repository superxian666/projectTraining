package com.JavaMailTask.www;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public static final String filePath = "conf/config.properties";
	public static String getValue(String key) throws IOException {
		Properties properties = new Properties();
		
		FileInputStream fileInputStream  = new FileInputStream(filePath);
		
		properties.load(fileInputStream);
		
		fileInputStream.close();
		return properties.getProperty(key);
		
		
		
	}

}
