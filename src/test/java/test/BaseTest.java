package test;

import java.util.Properties;

import utils.ReadPropData;

public class BaseTest{
	
	public int statusCode_200OK = 200;
	public int statusCode_201OK = 201;
	public Properties prop;
	
	public BaseTest()
	{
		try {
			prop = ReadPropData.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
