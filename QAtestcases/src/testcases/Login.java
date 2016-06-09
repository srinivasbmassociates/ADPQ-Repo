package testcases;
import operations.Operations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class Login {

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
			  System.out.print("Loged in--->pass");
		  }
		  else
		  {
			  System.out.print("unable to login--->fail");
		  }
		  alert.accept();	
		  driver.quit();
	}


}
