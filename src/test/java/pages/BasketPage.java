package pages;

import actions.Action;
import org.openqa.selenium.WebDriver;

public class BasketPage extends Action {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void verifyValue(String key, String value) {
        verifyElementValueText(key, value);
    }
}
