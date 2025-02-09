package steps;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;


@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IdeaSoftTest extends TestBase {

    @Test
    @Order(1)
    public void verifyHomePageUrlAndSearchProduct() {
        homePage.verifyUrl("https://qatestcase.myideasoft.com/");
        homePage.click("SearchInputLocator");
        homePage.inputSearchText("SearchInputLocator", "Ürün");
        homePage.click("SearchButtonLocator");
        homePage.click("ProductLocator");
    }

    @Test
    @Order(2)
    public void productDetailAndAddProduct() throws InterruptedException {
        productPage.addProduct(5, "PlusLocator");
        productPage.click("BasketButtonLocator");
        productPage.verifyText("BasketSuccessLocator", "SEPETİNİZE EKLENMİŞTİR");
        productPage.basketClick("BasketLocator");
    }

    @Test
    @Order(3)
    public void verifyBasketValue() {
        basketPage.verifyValue("BasketProductValueLocator", "5");
    }
}
