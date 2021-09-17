package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='goods-tile ng-star-inserted']")
    private List<WebElement> searchListItems;

    public List<WebElement> getSearchResultList (){
        return searchListItems;
    }
}
