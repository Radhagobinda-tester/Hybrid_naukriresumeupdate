package testscripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.WebDriverDriverUtilies;
import pomPages.Headline;
import pomPages.HomePage;
import pomPages.NaukriLoginPage;
import pomPages.PopupWindow;

public class tc1 extends BaseClass {

	@Test
	public void tc1() throws IOException, InterruptedException {
		
		 NaukriLoginPage p = new NaukriLoginPage(driver);
	       
	        p.loginBtn();
	     
	        p.Emailtf(pdata.getPropertyfiledata("Email"));
	       
	        p.passwordtf(pdata.getPropertyfiledata("Password"));
	     
	        p.Submitbtn();
	        //Assert.assertTrue(p.Submitbtn().isDisplayed(), "Submit button is displayed");


	    HomePage pf = new HomePage(driver);
	  
	     pf.profilebtn();
	     
	     Headline h =new Headline(driver);
	     //Thread.sleep(3000);
	     try {
	            WebDriverDriverUtilies.alertPopup(driver);
	        } catch (Exception e) {
	            // Handle the exception here
	            e.printStackTrace(); // or log the exception
	        }
	     h.EditBtn();
	    PopupWindow headline = new  PopupWindow(driver);
	    headline.ClearText();
	   
	    headline.TextField(pdata.getPropertyfiledata("Heading"));
	   
	    
	   
	   headline.SubmitBtn();
	   
	   Reporter.log(driver.getTitle(),true);
		
	}
}
