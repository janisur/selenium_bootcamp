package classTests.day2.SoloTask;

import baseWebTest.BaseWebTest;
import classTests.day2.AlertTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.day2.SoloTaskPages.AppleMonitorPage;
import pageObject.day2.SoloTaskPages.MonitorsPage;
import pageObject.day2.SoloTaskPages.SoloTaskHomePage;

public class SoloTaskTest extends BaseWebTest {

    final Logger LOGGER = LogManager.getLogger(AlertTest.class);

    @BeforeClass
    public void navigateTo() {
        navigateTo("http://tutorialsninja.com/demo/");
    }

    @Test
    public void clickingComponents() {
        SoloTaskHomePage home = new SoloTaskHomePage(driver);
        home.selectMenuItem("Components");

        driver.findElement(By.linkText("Monitors (2)")).click();

        //driver.findElement(By.xpath("//a[contains(@href,'/product&path=25_28&product_id=42')]")).click();
        //driver.findElement(By.xpath("//img[contains(@src,'apple_cinema_30-228x228.jpg')]")).click();

        MonitorsPage monitor = new MonitorsPage(driver);
        monitor.clickItem(0);
        LOGGER.info("First three steps of the exercise are featured on this Test #1" + "\n" + "There was a problem i couldn't fix to actually implement next steps. However, in order to at least practice finding locators and populating forms the next TEST #2 was created.");
    }

    @Test
    public void populateForms() {
        driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=42");

        AppleMonitorPage appleMonitor = new AppleMonitorPage(driver);
        LOGGER.info("New Page Object class created " + "Trying to stick to the " + "1 Web Page = 1 Page java class" + " principle.");

        appleMonitor.chooseSize("6");

        appleMonitor.chooseCheckbox("8");

        appleMonitor.sendText1("IS IT REALLY NOT WORKING TOO?");

        appleMonitor.selectFromSelectTypeDD("Green\n" +
                "                                (+$1.20)\n" +
                "                 ");
        appleMonitor.writeInTextArea("PLEASE, just PLEASE - do this one time.");

        appleMonitor.uploadFile();

        LOGGER.info("After uploading! The uploading IS NOT working correctly.");

        String date = "1985-11-04";
        String time = "11:25";
        appleMonitor.setDatePicker(date);
        appleMonitor.setTimePicker(time);
        appleMonitor.setTimeAndDatePicker(date,time);

        appleMonitor.setQuantity("5");

        appleMonitor.clickAddToCartButton();
        LOGGER.info("All forms populated, but, unfortunately, uploading error is BLOCKING adding to cart :/");
    }
}

