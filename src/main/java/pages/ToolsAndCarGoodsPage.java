package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolsAndCarGoodsPage extends BasePage {

    public ToolsAndCarGoodsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='buy-button lite-tile__buy-button ng-star-inserted']")
    private WebElement addToCart;

    public void clickOnCartbutton() {
         addToCart.click();
    }
}
