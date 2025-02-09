# IdeaSoft Test Automation

This project is a test automation framework designed to perform manual and automated functional tests on the IdeaSoft e-commerce site. The project is structured using Java, Selenium, and JUnit 5 technologies with a Page Object Model (POM) architecture.

## Requirements

- Java 8 or higher
- Maven 3.6.0 or higher
- Google Chrome Browser
- ChromeDriver (should be compatible with your Google Chrome browser version)


## Project Content

  - Test Case 1: Verify Home Page URL and Search Product
    Test Name: verifyHomePageUrlAndSearchProduct
    Description: Verifies the home page URL and searches for the term "Product."
    Steps:
    Verify the home page URL.
    Enter "Product" in the search box and search.
    Click on the listed product.

  - Test Case 2: View Product Details and Add Product to Basket
    Test Name: productDetailAndAddProduct
    Description: Views the product details and adds 5 units of the product to the basket.
    Steps:
    Add 5 units of the product to the basket.
    Verify the "Added to your basket" message.
    Click the basket button.

  - Test Case 3: Verify Product Quantity in Basket
    Test Name: verifyBasketValue
    Description: Verifies the quantity of products in the basket.
    Steps:
    Check and verify the quantity of products in the basket.


## Author
Salim Kartal
