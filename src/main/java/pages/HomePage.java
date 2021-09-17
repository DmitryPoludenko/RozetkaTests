package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,'button_color_green')]")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='lang__link ng-star-inserted']")
    private WebElement languageButton;

    @FindBy(xpath = "//li[@class='header-actions__item header-actions__item--cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//ul[@class='menu-categories menu-categories_type_main']//a[contains(text(), 'автотовар')]")
    private WebElement toolsAndCarGoodsButton;


    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void clickLanguageSwitchButton(){
        languageButton.click();
    }

    public WebElement returnCartButton(){
        return cartButton;
    }

    public void clickToolsAndCarGoodsButton(){
        toolsAndCarGoodsButton.click();
    }

}
