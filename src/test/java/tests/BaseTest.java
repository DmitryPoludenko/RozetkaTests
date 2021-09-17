package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.CartPopUpWindow;
import pages.HomePage;
import pages.SearchPage;
import pages.ToolsAndCarGoodsPage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String ROZETKA_URL = "https://rozetka.com.ua/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("firefox") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.31.228:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(ROZETKA_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchPage getSearchPage() {
        return new SearchPage(getDriver());
    }

    public ToolsAndCarGoodsPage getToolsAndCarGoodsPage() {
        return new ToolsAndCarGoodsPage(getDriver());
    }

    public CartPopUpWindow getCartPopUpWindow() {
        return new CartPopUpWindow(getDriver());
    }

}
