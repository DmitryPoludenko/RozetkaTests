package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SmokeTests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 90;
    private static final String SEARCH_WORD = "Intertool";
    private static final String EXPECTED_LANGUAGE_WORD = "ua";

    @Test
    public void checkAddingToCartAndDeletingFromCart() throws InterruptedException {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);

        getHomePage().clickToolsAndCarGoodsButton();
        Thread.sleep(2000);
        getToolsAndCarGoodsPage().clickOnCartbutton();

        Actions action = new Actions(getDriver());
        action.moveToElement(getHomePage().returnCartButton()).click().pause(2000).build().perform();

        Assert.assertTrue(getCartPopUpWindow().isCartPopUpVisible());
        Assert.assertTrue(getCartPopUpWindow().isCartNotEmpty());

    }

    @Test
    public void checkIfSearchResultContainsSearchWord() {

        getHomePage().enterTextToSearchField(SEARCH_WORD);
        getHomePage().clickSearchButton();
        List<WebElement> listOfElements = getSearchPage().getSearchResultList();
        for (WebElement element : listOfElements) {
            Assert.assertTrue(element.getText().contains(SEARCH_WORD));
        }

    }

    @Test
    public void testLanguageChanging() {

        getHomePage().clickLanguageSwitchButton();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_LANGUAGE_WORD));

    }

}
