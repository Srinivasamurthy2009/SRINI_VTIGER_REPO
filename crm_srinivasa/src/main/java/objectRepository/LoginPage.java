package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.propertyFileUtility;

public class LoginPage {
//Create constructor.
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	propertyFileUtility putil = new propertyFileUtility();
	
	
//Code to @FindBy
	@FindBy(name = "user_name")
	private WebElement usernameTF;
	
	@FindBy(name = "user_password")
	private WebElement passwordTF;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

//Selected above code from line no 19 to 26 -> right clicked ->clicked Source-Generate Getters and Setter option and generated the below block of code.	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	
	public void login() throws IOException
	{
	String UNAME	= putil.readDataFromProperties("Username");
	String PWD	    = putil.readDataFromProperties("Password");
		
	usernameTF.sendKeys(UNAME);
	passwordTF.sendKeys(PWD);
	loginBtn.click();
	}
	
	public void login(String User, String pass)
	{
		usernameTF.sendKeys(User);
		passwordTF.sendKeys(pass);
		loginBtn.click();
	}
	
}

