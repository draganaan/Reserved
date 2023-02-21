import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{


//    web elementi

    @FindBy(xpath = "//button[@id='cookiebotDialogOkButton']")
    WebElement acceptCookies;

    @FindBy(xpath = "//div[@data-testid='account-info-logged-true']")
    WebElement draganaAccountButton;

    @FindBy(xpath = "//a[@data-testid='returns']")
    WebElement mojiPovracajiOption;


//constructor

    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.reserved.com/rs/sr/");
        print("Home page");
        assert driver.getCurrentUrl().equals(Strings.HOME_PAGE_URL) : "Wrong page. Expected "
                + Strings.HOME_PAGE_URL + " . Actual " + driver.getCurrentUrl();
        this.clickAcceptCookies();
    }

    public void clickAcceptCookies() {
        waitForElement(acceptCookies);
        acceptCookies.click();
    }
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String getNameFromDraganaAccountButton() {
        print("getNameFromDraganaAccountButton");
        String name = draganaAccountButton.getText();
        return name;
    }

    public void clickDraganaAccountButton() {
        print("clickDraganaAccountButton");
        assert draganaAccountButton.isDisplayed() : "Account button is not present on page";
        draganaAccountButton.click();
    }
   /* public void chooseMojiPovracajiOption() {
        hoverOverElement(draganaAccountButton);
        hoverClickOverElement(mojiPovracajiOption);
}*/

    public void chooseMojiPovracajiOption ( ) {


        Actions action = new Actions( driver );
        action.moveToElement( draganaAccountButton ).perform( );
        WebDriverWait wait = new WebDriverWait(driver, 10 );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='returns']"))).click( );
        mojiPovracajiOption.click( );
    }
}
