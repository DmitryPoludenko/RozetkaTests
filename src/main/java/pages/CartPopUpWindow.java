package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopUpWindow extends BasePage {

    public CartPopUpWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[@class='modal__heading']")
    private WebElement cartHeader;

    @FindBy(xpath = "//div[@class='cart-receipt ng-star-inserted']")
    private WebElement notEmptyCartIdentifier;

    public boolean isCartPopUpVisible() {
        return cartHeader.isDisplayed();
    }

    public boolean isCartNotEmpty() {
        return notEmptyCartIdentifier.isDisplayed();
    }

}
