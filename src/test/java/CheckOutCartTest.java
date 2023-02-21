import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckOutCartTest extends BaseTest{


    /**
     * Checkout the cart
     * steps:
     * 1. Navigate to home page
     * 2. click login icon
     * 3. On the login page enter credentials (valid username and password) and click confirmation button
     * 4. On the my account choose option moji povraćaji
     * <p>
     * Expected result:
     * 4. Verify that are shown error message
     */

    @Test
    public void CheckOutCart() {
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
            homePage.chooseMojiPovracajiOption();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);



            print("Verify that the error message is shown");
            ReturnPage returnPage = new ReturnPage (driver);

            /*String actualText = returnPage.getTexFromErrorMessage();
            assert actualText.equals(Strings.ERROR) : "Wrong text. " +
                    "Expected: " + Strings.ERROR + " Actual: " +actualText;
*/

            returnPage.scrollToBackToHomePage();
            returnPage.clickBackToHomePage();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            print("Verify that we are on Home page");
            assert driver.getCurrentUrl().equals(Strings.HOME_PAGE_URL) : "Wrong page. Expected "
                    + Strings.HOME_PAGE_URL + " . Actual " + driver.getCurrentUrl();



        }finally {
            driver.quit();
        }
    }
}

