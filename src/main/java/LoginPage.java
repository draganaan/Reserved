import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{


//    web elementi

    @FindBy(xpath = "//input[@id='login[username]_id']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='login[password]_id']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='primary__PrimaryButtonComponent-sc-1pct4vx-0 fYiUIK']")
    WebElement signIn;

  /*  @FindBy(xpath = "//div[@class='action-btn__HorizontalActionButton-zbpc1mm-2 dwExhh']")
    WebElement personalAccount;*/



    //    metode nad drajverom
    ChromeDriver driver = null;

//    constructor
    public LoginPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.LOGIN_PAGE_URL);
        PageFactory.initElements(driver, this);
        assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "User is not on Login page";
    }
//metode na stranici

    public void sleepSendKeys( ) {

        try {
            Thread.sleep(300);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputEmail( ) {

        usernameField.click( );

        String email = Strings.EMAIL_FOR_SIGNIN;
        for (int i = 0; i < email.length(); i++) {

            char c = email.charAt(i);
            String s = new StringBuilder( ).append( c ).toString( );

            usernameField.sendKeys( s );
            sleepSendKeys( );
        }
    }

    /**
     * THIS Method input user password on signup page of LC WAIKIKI
     */

    public void inputPassword( ) {

        passwordField.click( );

        String password = Strings.PASSWORD_FOR_SIGNIN;
        for (int i = 0; i < password.length(); i++) {

            char c = password.charAt(i);
            String s = new StringBuilder( ).append( c ).toString( );

            passwordField.sendKeys( s );
            sleepSendKeys( );
        }
    }

    public void clickSignIn() {
        assert signIn.isDisplayed() : "Sign in is not present";
        signIn.click();
    }
}
