package testscripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.WebDriverDriverUtilies;
import pomPages.HomePage;
import pomPages.NaukriLoginPage;
import pomPages.ProfilePage;

@Test
public class tc0 extends BaseClass {
    public void tc0() throws IOException, InterruptedException {
        
        NaukriLoginPage p = new NaukriLoginPage(driver);
        p.loginBtn();
        p.Emailtf(pdata.getPropertyfiledata("Email"));
        Thread.sleep(5000);
        p.passwordtf(pdata.getPropertyfiledata("Password"));
       
        p.Submitbtn();
    

        HomePage pf = new HomePage(driver);
         //Thread.sleep(5000);
        pf.profilebtn();
    
     
        ProfilePage up =new  ProfilePage(driver);
      /*  try {
            WebDriverDriverUtilies.alertPopup(driver);
        } catch (Exception e) {
            // Handle the exception here
            e.printStackTrace(); // or log the exception
        }
        */
        up.Upload();
       Thread.sleep(5000);
       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      // Runtime.getRuntime().exec("F:\\Autoit\\z.exe");
       Process process = Runtime.getRuntime().exec("F:\\Autoit\\z.exe");
       BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
       String line;
       while ((line = reader.readLine()) != null) {
           System.out.println(line);
           
       }

      

     //Runtime.getRuntime().exec("‪C:\\autoit\\m.exe");
    /* System.setProperty(LibraryLoader.JACOB_DLL_PATH, "path_to_jacob.dll");
     AutoItX autoIt = new AutoItX();

     // Wait for "Open" dialog and set focus to file input field
     autoIt.winWaitActive("Open");
     autoIt.controlFocus("Open", "", "Edit1");

     // Type the file path into the file input field
     autoIt.send("C:\\resume\\Radha Gobinda Dash recent.docx");

     // Click the "Open" button
     autoIt.controlClick("Open", "&Open", "Button1");
     */
    
       Thread.sleep(5000);
       
       Reporter.log(driver.getTitle(),true);
    }

}