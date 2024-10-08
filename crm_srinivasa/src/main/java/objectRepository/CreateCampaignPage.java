package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	WebDriver driver;

	public CreateCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(name = "campaignname")
	private WebElement campName;
	
	@FindBy(name = "closingdate")
	private WebElement closingDate;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getCampName() {
		return campName;
	}

	public WebElement getClosingDate() {
		return closingDate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}
