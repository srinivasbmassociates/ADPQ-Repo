package operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {

	Properties allProperties = new Properties();
 
	public Properties getObjectRepository(String fileName) throws IOException{
		//Read object repository file
		InputStream stream = new FileInputStream(new File("D:\\selenium Projects\\java projects\\CHHS\\src\\pageobjects\\"+fileName+".properties"));
		//load all objects		
		allProperties.load(stream);
		 return allProperties;
	}
	
}
