package pom.InetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	
	public readConfig(){
		
		try {
		File src=new File("./ConfigurationFiles/config.properties");
		
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		}catch(Exception e) {
			
			System.out.println("Exception is  :"+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		
		String baseUrl=pro.getProperty("baseUrl");
		return baseUrl;
		
	}
    public String getUserName() {
		
    	String userName=pro.getProperty("userName");
		return userName;
		
	}
    public String getPassword() {
		
    	String password=pro.getProperty("password");
		return password;
		
	}
    public String getChropath() {
		
    	String chromepath=pro.getProperty("chromepath");
		return chromepath;
		
	}
    public String getFirefoxpath() {
		
    	String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
    public String getIEpath() {
		
    	String iepath=pro.getProperty("iepath");
		return iepath;
		
	}



}
