package utils.helpers;

import org.junit.Assert;
import org.openqa.selenium.*;
import utils.driver.WebDrivers;
import utils.helpers.elementHelper.ElementMap;
import utils.helpers.elementHelper.ElementResponse;
import utils.helpers.elementHelper.Elements;

import java.util.concurrent.TimeUnit;


public class Helper {

    public WebDriver webDriver;
    WebDrivers webDrivers = new WebDrivers();

    public Helper() {
        webDriver = webDrivers.createAndGetDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    public void waitForGivenTime(int seconds) {
        long milliseconds = (seconds * 1000L);
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }
    }

    public By getBy(String key) {
        ElementResponse elementInfo = ElementMap.INSTANCE.findElementInfoByKey(key);
        return Elements.getElementInfoToBy(elementInfo);
    }

    public void tearDown() {
        webDriver.quit();
        WebDrivers.clearSession();
    }
}
