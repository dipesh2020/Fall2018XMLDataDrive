package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.HomePage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {
	
	@Test
	@Parameters({"Loginemail","password","FName","Company","Email","Phone","Address","City","State","Zip"})
	public void AddingContact(String Loginemail, String password, String FName, String Company, String Email, String Phone, String Address, String City, String State, String Zip) {
		
		WebDriver driver = BrowserFactory.browserName("chrome", "http://techfios.com/test/billing/?ng=login/");
		LoginPage logintotechfios = PageFactory.initElements(driver, LoginPage.class);
		//logintotechfios.Login("techfiosdemo@gmail.com", "abc123");
		logintotechfios.Login(Loginemail, password);
		
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		home.NavigateToAddContact();
		
		AddContactPage addcontact = PageFactory.initElements(driver, AddContactPage.class);
		//addcontact.fillingUpAddressForm("Dipesh", "HiveGlass", "dpace65@hotmail.com", "6824143173", "9126 conser st", "Overland Park", "Kansas", "66212");
		addcontact.fillingUpAddressForm(FName,Company,Email,Phone, Address, City, State, Zip);
		
		driver.close();
		driver.quit();
	}

}
