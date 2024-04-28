package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
	@FindBy(xpath="//a[normalize-space()='View profile']")
	private WebElement pfbtn;

	@FindBy (xpath="//p[normalize-space()='Last updated today']")
	private WebElement text;
	// initialization

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void profilebtn() {
		pfbtn.click();
	}

	public String textName() {
		return text.getText();
	}
}
