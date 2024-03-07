package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	//Declaration
	@FindBy(xpath="//a[text()='Update']")
	private WebElement Attachcv;
	//// initialization
	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		public void Upload() {
			Attachcv.click();
		}
	}

