import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SortingTest extends BaseTest{


    /* Sorting in ascending order by price
    1. Login to Reserved
    2. Enter key word in the search field
    2. CLick on the Sorting dropdown and choose to sort 'Price low to high'
    Expected results:
    2. Verify that items are sorted in ascending order by price
     */

        @Test
        public void sortItemsByPriceAscending() {
            ChromeDriver driver = openChromeDriver();
            try {
                print("1. Enter text into search field");
                HomePage homePage = new HomePage(driver);
                driver.manage().window().maximize();
                homePage.searchAndSubmit("haljina");

                print("Get first item price, before sorting");
                ProductResultsPage productResultsPage = new ProductResultsPage(driver);
                String firstItemPriceUnsorted = productResultsPage.getFirstItemPriceUnsorted();
                float priceUnsorted = Float.valueOf(firstItemPriceUnsorted.substring(0, firstItemPriceUnsorted.indexOf('R')).replaceAll("\\D+",""));
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                productResultsPage.clickCloseDiscountDialogButton();

                print("2. CLick on the Sorting dropdown and choose to sort 'Price low to high'");
                productResultsPage.clickSort();
                productResultsPage.clickSortItemByText();

                print("Again, get the first item price after sorting");
                String firstItemPriceSorted = productResultsPage.getFirstItemPriceSorted();
                float priceSorted = Float.valueOf(firstItemPriceSorted.substring(0, firstItemPriceSorted.indexOf('R')).replaceAll("\\D+",""));

                //napredna provera sortiranja gde se proverava ceo niz
                ArrayList<Float> itemPricesAfterSorting = productResultsPage.getAllITemPrices();
                assert homePage.isArraySortedInAscendingOrder(itemPricesAfterSorting) : "Error. Array is not sorted in ascending order";

                print("2. Verify that items are sorted in ascending order by price");
                //we are just checking if the first item price has changed and this is how we verify that list is sorted
                assert priceSorted<=priceUnsorted: "Error: Prices are not sorted in ascending order";

            }finally {
                driver.quit();
            }
        }

    }

