import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReturnPage extends BasePage{


// web elementi

    @FindBy(xpath = "//div[@data-testid='cusomer-account-error-header']")
    WebElement errorMessage;

    @FindBy(xpath = "//a[@data-testid='cusomer-account-error-link']")
    WebElement errorLink;

    @FindBy(xpath = "//a[@class='error-message__Link-ygmg60-3 bKRYiV']")
    WebElement backToHomePage;


    //    constructor
    public ReturnPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.RETURN_PAGE_URL);
        PageFactory.initElements(driver, this);
        assert driver.getCurrentUrl().equals(Strings.RETURN_PAGE_URL) : "User is not on Login page";}

//    metode



    public String getTexFromErrorMessage() {
        print("getTextFromErrorMessage");
        String text = errorMessage.getText();
        return text;
    }

    public void clickErrorLink() {
        assert errorLink.isDisplayed() : "Error link is not present";
        errorLink.click();
    }

    public void clickBackToHomePage() {
        assert backToHomePage.isDisplayed() : "Back to home page is not present";
        WebDriverWait wait = new WebDriverWait(driver, 10 );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-testid='cusomer-account-error-link']"))).click( );
        backToHomePage.click();
    }

    public void scrollToBackToHomePage() {
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].scrollIntoView(true);", backToHomePage);
    }
}