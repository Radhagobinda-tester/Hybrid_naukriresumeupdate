package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupWindow {
 @FindBy(id="resumeHeadlineTxt")
 private WebElement text;
 @FindBy(xpath="(//button[contains(text(),'Save')])[2]")
 private WebElement submit;

 public PopupWindow(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
 public void ClearText() {
	 text.clear();

 }

 public void SubmitBtn(){
	 submit.click();
 }


 public void TextField(String key) {
	 text.sendKeys(key);
 }
}
