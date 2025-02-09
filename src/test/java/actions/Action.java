package actions;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.helpers.Helper;

import java.time.Duration;


public class Action extends Helper {

    public WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));

    public Action(WebDriver driver) {
        super();
        this.webDriver = driver;
    }

    public void clickElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());
        }
    }

    public WebElement findElement(String key) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 9000) {
            try {
                return wait.until(ExpectedConditions.presenceOfElementLocated(getBy(key)));
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
        }
        Assert.fail("Element '" + key + "' not found.");
        return null;
    }

    public void verifyExpectedUrl(String expectedUrl) {
        String actualUrl = webDriver.getCurrentUrl();
        Assert.assertEquals("URL does not match!", expectedUrl, actualUrl);
    }

    public void inputText(String key, String text) {
        // Locate the input element by its ID
        WebElement inputElement = findElement(key);

        // Clear any existing text (optional)
        inputElement.clear();

        // Enter the text into the input element
        inputElement.sendKeys(text);
    }

    public void addToProduct(int quantity, String key) {
        WebElement element = findElement(key);
        for (int i = 0; i < quantity - 1; i++) {
            element.click();
        }
    }

    public void verifyElementText(String key, String expectedText) {
        try {
            WebElement element = findElement(key);
            String actualText = element.getText();
            if (actualText.equals(expectedText)) {
                System.out.println("Elementin metni başarıyla doğrulandı: " + actualText);
            } else {
                System.out.println("Beklenen metin: '" + expectedText + "', Ancak bulunan metin: '" + actualText + "'");
            }
        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }

    public void verifyElementValueText(String key, String expectedValue) {
        try {
            WebElement element = findElement(key);
            String actualValue = element.getAttribute("value");
            if (actualValue.equals(expectedValue)) {
                System.out.println("Elementin değeri başarıyla doğrulandı: " + actualValue);
            } else {
                System.out.println("Beklenen değer: '" + expectedValue + "', Ancak bulunan değer: '" + actualValue + "'");
            }
        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }


}
