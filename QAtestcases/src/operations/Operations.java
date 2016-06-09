package operations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;




import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Operations {

	WebDriver driver;
	public Operations(WebDriver driver)
	{
		this.driver = driver;
	}
	
	 public void LaunchApp() 
	 {		 
		 driver.navigate().to("http://ec2-52-90-174-90.compute-1.amazonaws.com:8080/home.php");
		 //Thread.sleep(4000);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();		 
	 }
	 
	public String readExcel(String Filepath, int sheetnum,String Columnname,int Row) throws BiffException, IOException
	{
		FileInputStream fs = new FileInputStream(Filepath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(sheetnum); // this is to get the access to Sheet1.
		String CellGetContent = null;
		int totalNoOfCols=sh.getColumns();
		for (int col = 0; col < totalNoOfCols; col++)
		{
			
			String colvaue=sh.getCell(col, 0).getContents();
			if (colvaue.equals(Columnname))
					{
						CellGetContent=sh.getCell(col, Row).getContents();
					}			
		}
		return CellGetContent;		
	}
	
	
	
		public void wait(int time)
		{
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
	
	
	
	ReadObject object = new ReadObject();
	
	public void Click(String repositoryFileName,String objectName,String objectType) throws Exception 
	{	
		driver.findElement(this.getObject(repositoryFileName,objectName,objectType)).click();
	}
	
	public void SetText(String repositoryFileName,String objectName,String objectType,String value) throws Exception 
	{
		driver.findElement(this.getObject(repositoryFileName,objectName,objectType)).sendKeys(value);	
	}
	
	public String GoToUrl(String repositoryFileName,String urlKeyName) throws IOException
	{
		Properties allObjects =  object.getObjectRepository(repositoryFileName);
		driver.get(allObjects.getProperty(urlKeyName));
		return urlKeyName;
	}
	
	public String GetText(String repositoryFileName,String objectName,String objectType) throws Exception
	{
		//Get text of an element
	return	driver.findElement(this.getObject(repositoryFileName,objectName,objectType)).getText();
	}
	public WebElement Select(String repositoryFileName,String objectName,String objectType,String value) throws Exception
	{
		//select in weblist
		WebElement weblist = driver.findElement(this.getObject(repositoryFileName,objectName,objectType));
		Select selectElement=new Select(weblist);
		selectElement.selectByValue(value);
		return weblist;
	}
	

	
	
	/*public selectRadioBtn(String repositoryFileName,String objectName,String objectType,String value)throws Exception
	{
		
	}*/
	
	/**
	 * Find element BY using object type and value
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private By getObject(String repositoryFileName,String objectName,String objectType) throws Exception
	{
		//Find by xpath
		Properties Login =  object.getObjectRepository(repositoryFileName);
		if(objectType.equalsIgnoreCase("XPATH")){
			
			return By.xpath(Login.getProperty(objectName));
		}
		//find by class
		else if(objectType.equalsIgnoreCase("CLASSNAME")){
			
			return By.className(Login.getProperty(objectName));
			
		}
		//find by name
		else if(objectType.equalsIgnoreCase("NAME")){
			
			return By.name(Login.getProperty(objectName));
			
		}
		//Find by css
		else if(objectType.equalsIgnoreCase("CSS")){
			
			return By.cssSelector(Login.getProperty(objectName));
			
		}
		//find by link
		else if(objectType.equalsIgnoreCase("LINK")){
			
			return By.linkText(Login.getProperty(objectName));
			
		}
		//find by partial link
		else if(objectType.equalsIgnoreCase("PARTIALLINK")){
			
			return By.partialLinkText(Login.getProperty(objectName));
			
		}
		else if(objectType.equalsIgnoreCase("ID"))
		{
			
			return By.id(Login.getProperty(objectName));
			
		}
		
		else
		{
			throw new Exception("Wrong object type");
		}
	}
}
