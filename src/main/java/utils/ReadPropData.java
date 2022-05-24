package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ReadPropData {
	
	public static Properties prop;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	
	
	public static Properties getData()
	{
		String fileDir = System.getProperty("user.dir");
		String fileName = "data.properties";
		String path = fileDir+"\\"+fileName;
		try {
			prop = new Properties();
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
