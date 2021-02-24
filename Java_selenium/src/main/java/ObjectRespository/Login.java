package ObjectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{
	public Login(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")                   
    private WebElement usn;
    
   

	@FindBy(name="user_password")
    private WebElement pwd;
    
    public WebElement getUsn() {
		return usn;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLogin() {
		return login;
	}

	@FindBy(id="submitButton")
    private WebElement login;
    
    public void logincredentials(String username , String password) {           
		usn.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
	}

}
