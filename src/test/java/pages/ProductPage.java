package pages;

import actions.Action;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Action {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProduct(int number, String key) {
        addToProduct(5, key);
    }

    public void basketClick(String key) throws InterruptedException {
        Thread.sleep(1000);
        clickElement(findElement(key));
    }

    public void verifyText(String key, String text) {
        verifyElementText(key, text);
    }




    public void click(String key) {
        clickElement(findElement(key));
    }
}
