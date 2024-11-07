package ddtUsingXML;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNG_XMLTest 
{
	@Test
	public void sampleTest(XmlTest test)
	{
		System.out.println("execute sample test");
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
	}

}
