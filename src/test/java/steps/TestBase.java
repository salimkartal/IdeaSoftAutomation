package steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.BasketPage;
import pages.HomePage;
import pages.ProductPage;
import utils.driver.DriverFactory;

public class TestBase {
    protected static HomePage homePage;
    protected static ProductPage productPage;
    protected static BasketPage basketPage;
    protected static DriverFactory driverFactory;
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driverFactory = DriverFactory.getInstance();
        driver = driverFactory.getDriver();
        driverFactory.navigateToDomain(0);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
