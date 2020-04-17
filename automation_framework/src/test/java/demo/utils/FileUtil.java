package demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtil{
	
	private static Properties properties = new Properties();
	private static InputStream inputStream;
	
	public static String readFromPropertyFile(String propertyFilePath, String propertyName) {
		try {
		    inputStream = new FileInputStream(propertyFilePath);
			properties.load(inputStream);
			return properties.getProperty(propertyName);
		} 
		catch (IOException io) {
			io.printStackTrace();
		}
		return null;
	}
}
