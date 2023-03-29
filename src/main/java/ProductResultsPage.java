import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductResultsPage extends BasePage {

//    web elementi

    @FindBy(xpath = "//div[@class='header-title']")
    WebElement sortDropDown;

    @FindBy(xpath = "//li[contains(text(),'Sortiraj od niže cene ka višoj')]")
    WebElement sortButton;

    @FindBy(xpath = "//div[@class='close']")
    WebElement discountDialogButton;


//    constructor

    public ProductResultsPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.PRODUCT_RESULTS_PAGE_URL);
        print("Product Results Page");
        assert driver.getCurrentUrl().equals(Strings.PRODUCT_RESULTS_PAGE_URL) : "Wrong page. Expected "
                + Strings.PRODUCT_RESULTS_PAGE_URL + " . Actual " + driver.getCurrentUrl();
    }

    public String getFirstItemPriceUnsorted() {
        List<WebElement> items = driver.findElements(By.xpath("//ul[@class='infinite-hits__StyledInfiniteHits-tiohae-0 eEWTYo containerHearts']"));
        WebElement firstItem = items.get(0);
        WebElement firstItemPrice = firstItem.findElement(By.xpath("//div[@class='product-price__ProductPriceWrapper-sc-1ftsh9w-0 gUXUkb']"));
        return firstItemPrice.getText();


    }

    public String getFirstItemPriceSorted() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@data-testid='products-results']"));
        WebElement firstItem = items.get(0);
        WebElement firstItemPrice = firstItem.findElement(By.xpath("//div[@class='product-price__ProductPriceWrapper-sc-1ftsh9w-0 gUXUkb']"));
        return firstItemPrice.getText();


    }

//    public void sortItemsByText(String text) {
//        Select dropdown = new Select(sortDropDown);
//        dropdown.selectByVisibleText(text);
//    }

    public void clickSort() {
        print("clickSort");
        assert sortDropDown.isDisplayed() : "Sort dropdown is not present on page";
        sortDropDown.click();
    }
    public void clickSortItemByText() {
        print("ClickSortItemByText");
        assert sortButton.isDisplayed() : "Option opadajuce is not present on page";
        sortButton.click();
    }

    public ArrayList<Float> getAllITemPrices() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='search-content open full']"));
        ArrayList<Float> itemPrices = new ArrayList<>();
        for (WebElement item : items) {
            String itemPrice = item.findElement(By.xpath(".//div[@class='product-price__ProductPriceWrapper-sc-1ftsh9w-0 gUXUkb']")).getText();
            Float justFLoatValue = Float.valueOf(itemPrice.replaceAll("\\D+",""));
            itemPrices.add(justFLoatValue);
        }
        return itemPrices;
    }

    public void clickCloseDiscountDialogButton() {
        print("closeDiscountDialogButton");
        assert discountDialogButton.isDisplayed() : "Discount dialog button is not present on page";
        discountDialogButton.click();
}
}
