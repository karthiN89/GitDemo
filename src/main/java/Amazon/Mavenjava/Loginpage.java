package Amazon.Mavenjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver2)
	{
		this.driver=driver;
	}

		By username=By.id("nav-link-accountList-nav-line-1");
		By password=By.id("ap_email");
		By login=By.id("continue");
		
		public WebElement Emailid()
		{
			return driver.findElement(username);
		}
		public WebElement Password()
		{
			return driver.findElement(password);
		}
}	