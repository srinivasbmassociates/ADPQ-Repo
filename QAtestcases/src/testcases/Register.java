package testcases;

import operations.Operations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Register 
{

	public static void main(String[] args) throws Exception 
	{
		  WebDriver driver=new FirefoxDriver();//opening the browser
		  Operations LA=new Operations(driver);
		  LA.LaunchApp();//maximize and set URl
		  LA.wait(2);
		  LA.Click("Register","Regbtn","XPATH");//click on the Register button
		  LA.wait(2);//wait for pop up
		  String fname=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "First Name", 1);//gets firstname from excel
		  String lname=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Last Name", 1);//gets lastname from excel
		  String location=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Location", 1);//gets location from excel
		  String zipcode=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Zip Code", 1);//gets zipcode from excel
		  String dob=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "DOB", 1);//gets date of birth from excel
		  String gender=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Gender", 1);//gets gender from excel
		  String phone=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Phone", 1);//gets phone from excel
		  String email=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Email", 1);//gets email from excel
		  String pwd=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Password", 1);//gets password from excel
		  String cpwd=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Confirm Password", 1);//gets confirm password from excel
		  String RegAs=LA.readExcel("Z:\\bhaskar\\java projects\\CHHS\\TestData\\Register.xls", 0, "Register As", 1);//gets RegisterAs from excel
		  
		  LA.SetText("Register", "fname", "ID", fname);//sets first name
		  LA.SetText("Register", "lname", "ID", lname);//sets last name
		  LA.SetText("Register", "location", "ID", location);//sets loaction
		  LA.SetText("Register", "zipcode", "ID", zipcode);//sets zipcode
		  LA.SetText("Register", "dob", "ID", dob);//sets date of birth
		  
		  if (gender.equalsIgnoreCase("Male"))//sets gender 
		  {
			  LA.Click("Register", "gendermale", "XPATH");	
		  }
		  else
		  {
			  LA.Click("Register", "genderfemale", "XPATH");
		  }
		  LA.SetText("Register", "phone", "ID", phone);//sets phone
		  LA.SetText("Register", "email", "ID", email);//sets email
		  LA.SetText("Register", "pwd", "ID", pwd);//sets password
		  LA.SetText("Register", "cpwd", "ID", cpwd);//sets confirm password
		  LA.Select("Register", "RegAs", "ID", RegAs);//sets RegisterAs weblist
		  LA.Click("Register", "submit", "XPATH");	//clicks on the submit 
		  Thread.sleep(3000);
		  Alert alert=driver.switchTo().alert();
		  String Verifytext=alert.getText();//gets text from alert
		  if (Verifytext.equalsIgnoreCase("User has been successfully created."))
		  {
			  System.out.print("User created--->pass");
		  }
		  else
		  {
			  System.out.print("unable to create user--->fail");
		  }
		  alert.accept();//clicks on ok button of alert
		  driver.quit();//close the browser
	}

}
