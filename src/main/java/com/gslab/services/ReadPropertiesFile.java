package com.gslab.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import utils.CurrentWorkingDirectory;
import constants.ErrorConstants;

public class ReadPropertiesFile {
	
	private String value;
	
	
	
	public String getValueFromPropertiesFile(String filename, String key) {
		Properties prop = new Properties();
		CurrentWorkingDirectory currentWorkingDirectory = new CurrentWorkingDirectory();
		try {
			// load a properties file
			String filePath = currentWorkingDirectory.getCurrentDirectoryPath() + filename;
			prop.load(new FileInputStream(filePath));

			// get the property value and print it out
			value = prop.getProperty(key);

		} catch (IOException ex) {
			System.out.println(ErrorConstants.FILE_NOT_FOUND + ": " + ex.getMessage());
		}
		return value;

	}

}
