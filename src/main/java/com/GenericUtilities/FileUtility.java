package com.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to read the data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author kishan
	 */
	public String readDataFromPropertyFile(String key)throws Throwable{
		FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}

}
