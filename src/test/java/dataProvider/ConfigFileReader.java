package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	 private final String propertyFilePath= "config//test.properties";
	 

	 public ConfigFileReader(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("test.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getDriverPath(){
	 String driverPath = properties.getProperty("driverPath");
	 if(driverPath!= null) return driverPath;
	 else throw new RuntimeException("driverPath not specified in the test.properties file."); 
	 }
	 
	 public String getUserName() { 
	 String UserName = properties.getProperty("UserName");
	 if(UserName != null) return UserName;
	 else throw new RuntimeException("UserName not specified in the test.properties file."); 
	 }
	 
	 public String getPassword() {
	 String Password = properties.getProperty("Password");
	 if(Password != null) return Password;
	 else throw new RuntimeException("Password not specified in the test.properties file.");
	 }
	 
	 public String getEmailSubject() {
		 String Subject = properties.getProperty("subject");
		 if(Subject != null) return Subject;
		 else throw new RuntimeException("subject not specified in the test.properties file.");
		 }
	 
	 public String getEmailBody() {
		 String Body = properties.getProperty("body");
		 if(Body != null) return Body;
		 else throw new RuntimeException("Body not specified in the test.properties file.");
		 }
}
