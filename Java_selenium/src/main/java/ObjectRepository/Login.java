package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login 
{
	@FindBy(name="user_name")
	private WebElement usn;
	
	@FindBy(name="user_password")
	private WebElement pwd;
	
	@FindBy(id="submitButton")
	private WebElement login;

	public WebElement getUsn() {
		return usn;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLogin() {
		return login;
	}

	
	public void logincredentials(String username,String password)
	{
		usn.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
	}
	

}
