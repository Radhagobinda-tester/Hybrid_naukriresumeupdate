package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukriLoginPage {

	//Declaration
@FindBy(id="login_Layer")
private WebElement LoginButton;
@FindBy(xpath ="(//input[@placeholder='Enter your active Email ID / Username'])")
private WebElement EmailTextField;
@FindBy(xpath ="(//input[@placeholder='Enter your password'])")
private WebElement PasswordTextField;
@FindBy(xpath ="(//button[text()='Login'])")
private WebElement Login;

// initialization

public NaukriLoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	//Declaration

	public void Emailtf(String key) {
		EmailTextField.sendKeys(key);
	}

	public void loginBtn() {
		LoginButton.click();
	}
	public void passwordtf(String key) {

	PasswordTextField.sendKeys(key);
	}


	public void Submitbtn() {
		Login.submit();
	}

	/*public WebElement Submitbtn() {
        return Login;
    }

	*/
}


