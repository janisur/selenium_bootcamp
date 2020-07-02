package classTests.day3;

import baseWebTest.BaseWebTest;
import classTests.day2.AlertTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.day3.AutomationPage;
import pageObject.day3.AutomationWomenPage;

public class AutomationSoloTest extends BaseWebTest {

    final Logger LOGGER = LogManager.getLogger(AlertTest.class);

    @BeforeClass
    public void navigateTo() {
        navigateTo("http://automationpractice.com/index.php");
    }

    @Test

    public void clickWomenAndBeyond() {
        AutomationPage homepage = new AutomationPage(driver);
        LOGGER.info("OMG, it actually works.. i' m clicking!!!");
        homepage.clickWomen();

        AutomationWomenPage womenPage = new AutomationWomenPage(driver);
        womenPage.clickItem(1);
        LOGGER.info("i can't believe i'm clicking again :O");

        womenPage.clickAddToCartButton();
        LOGGER.info("SMH, the item has been added to Cart" + "\n" + "there' s still time to push");

//        driver.navigate().refresh();
//        driver.navigate().back();

        AutomationPage homepage2 = new AutomationPage(driver);
        homepage2.clickWomen();

        AutomationWomenPage womenPage2 = new AutomationWomenPage(driver);
        womenPage2.clickItem(5);
        womenPage2.clickAddToCartButton();

        AutomationPage homepage3 = new AutomationPage(driver);
        homepage3.clickCart();
        LOGGER.info("2 items added (v) + navigated to shopping cart (v)" + "\n" +"\n" + "unfortunately, there's still quite a lot to do, but the time to push is running out. It's been a wild ride so far :D");


    }
}
