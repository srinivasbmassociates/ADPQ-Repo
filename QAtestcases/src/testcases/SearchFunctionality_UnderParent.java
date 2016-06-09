package testcases;

import java.util.List;

import operations.Operations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchFunctionality_UnderParent 
{

	public static void main(String[] args) throws Exception
	{
		WebDriver driver=new FirefoxDriver();
		  Operations LA=new Operations(driver);
		  LA.LaunchApp();
		  String username=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Login.xls", 0, "username", 1);//gets username from excel
		  String pwd=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Login.xls", 0, "password", 1);//gets password from excel
		  String role=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Login.xls", 0, "Role", 1);//gets role from excel
		  LA.SetText("Login", "userid", "XPATH", username);//sets username
		  LA.SetText("LOgin", "pwd", "XPATH", pwd);//sets password
		  LA.Select("Login", "Role", "XPATH", role);//sets role
		  LA.Click("Login", "submit", "xpath");//clicks on login button
		  Thread.sleep(3000);
		  Alert alert=driver.switchTo().alert();
		  String Verifytext=alert.getText();
		  if (Verifytext.equalsIgnoreCase("You are successfully authenticated!"))
		  {
			  System.out.println("Loged in--->pass");
		  }
		  else
		  {
			  System.out.println("unable to login--->fail/n");
		  }
		  alert.accept();	
		  Thread.sleep(4000);
		  LA.Click("Home", "search", "xpath");//clicks on search link
		  LA.SetText("Search", "zipcode", "Id", "90008");//sets zipcode
		  Thread.sleep(3000);
		  LA.Click("Search", "go", "xpath");//clicks on login button
		  LA.wait(10);
		  
		  WebElement table=driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div[2]/table/tbody"));
		  List<WebElement> rows=table.findElements(By.tagName("tr"));
		  int rcount=rows.size();
		  if (rcount>0)
		  {
			  System.out.println("Table Exists and number of rows:  "+rcount);
		  }
		  else
		  {
			  System.out.println("There is no table with this pincode");
		  }
		  driver.quit();
		  
		  //still we need to create the script for search operation verification waiting for zipcodes.
	}

}
