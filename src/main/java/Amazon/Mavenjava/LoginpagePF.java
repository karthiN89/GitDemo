package Amazon.Mavenjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpagePF {
	WebDriver driver;
	public LoginpagePF(WebDriver driver2)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		/*By username=By.id("nav-link-accountList-nav-line-1");
		By password=By.id("ap_email");
		By login=By.id("continue");*/
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement username;
	
	@FindBy(id="ap_email")
	WebElement password;
	
	@FindBy(id="continue")
	WebElement go;
		
		public WebElement Emailid()
		{
			return username;
		}
		public WebElement Password()
		{
			return password;
		}
}	