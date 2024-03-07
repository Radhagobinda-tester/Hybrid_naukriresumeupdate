package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Headline {
	//Declaration
		@FindBy(xpath=" (//span[contains(text(),'editOneTheme')])[2]")
		private WebElement edit;
		//// initialization
		public Headline(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
			public void EditBtn() {
				edit.click();
			}
		}

