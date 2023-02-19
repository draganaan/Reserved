import com.google.common.annotations.VisibleForTesting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest{


        /**
         * Login into account
         * steps:
         * 1. Navigate to home page
         * 2. click login icon
         * 3. On the login page enter credentials (valid username and password) and click confirmation button
         * <p>
         * Expected result:
         * 4. Verify that the right name is shown on Personal account button
         */

       @Test
       public void loginWithValidCredentials() {
            ChromeDriver driver =  new ChromeDriver();
            try {
                HomePage homePage = new HomePage (driver);
                driver.manage().window().maximize();
                homePage.clickAccountButton();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                LoginPage loginPage = new LoginPage(driver);
                loginPage.inputEmail();
                loginPage.inputPassword();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                loginPage.clickSignIn();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


                print("Verify that the right name is shown");
                assert homePage.getNameFromDraganaAccountButton().equals("Dragana") : "Wrong text on icon. Expected: Dragana, Actual " + homePage.getNameFromDraganaAccountButton();
                /*String actualText = homePage.getNameFromAccountButton();
                assert actualText.contains(Strings.NAME) : "Wrong text. " +
                        "Expected: " + Strings.NAME + " Actual: " +actualText;*/


            }finally {
                driver.quit();
            }
        }
    }


