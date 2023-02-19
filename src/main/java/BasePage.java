import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

//web elementi zajednički za sve stranice

    @FindBy(xpath = "//div[@class='action-btn__HorizontalActionButton-zbpc1m-2 dwExhh']")
    WebElement accountButton;
    @FindBy(xpath = "/data-selen=['login-submit']")

    WebElement signInButton;


//    metode nad drajverom

    ChromeDriver driver;

//constructor

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//metode na stranici

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickAccountButton() {
        print("clickAccountButton");
        assert accountButton.isDisplayed() : "Account button is not present on page";
        accountButton.click();
    }


    public void print(String s) {
        System.out.println(s);
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        actions.moveToElement(element).perform();
    }

    public void hoverClickOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        actions.moveToElement(element).click().perform();
    }

    public void clickSignInButton() {
        hoverOverElement(accountButton);
        hoverClickOverElement(signInButton);
    }


}