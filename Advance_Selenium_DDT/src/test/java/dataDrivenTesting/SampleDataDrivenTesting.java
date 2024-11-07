package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// Step1. get the Java representation of object of the physical file
		// Step2. using the Properties class to load the the keys & the values
		// Step3. Get the value based on the Key
		
		//Step1
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\FirstAdvanceSeleniumData.properties");
		
		// when we use FileInputStream class it will throw the FileNotFoundException
		
		//Step2
		Properties properties = new Properties();
		properties.load(fis);
		
		// when we use Properties class it will throw the IOException
		
		//Step3
		System.out.println(properties.getProperty("url"));
		// This gteProperty() method is Case sensitive, we have give same as it is
	}

}
