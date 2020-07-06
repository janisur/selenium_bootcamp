package classTests.day2.SoloTask;

import baseWebTest.BaseWebTest;
import classTests.day2.AlertTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.day2.SoloTaskPages.AppleMonitorPage;
import pageObject.day2.SoloTaskPages.CheckoutPage;
import pageObject.day2.SoloTaskPages.MonitorsPage;
import pageObject.day2.SoloTaskPages.SoloTaskHomePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SoloTaskTest extends BaseWebTest {

    final Logger LOGGER = LogManager.getLogger(AlertTest.class);

    public String firstNameText = "Andris";
    public String lastNameText = "Latkovskis";
    public String emailText = "andris.latkovskis@gmail.com";
    public String telephoneText = "0037129799855";
    public String addressText = "Ludzas 23";
    public String cityText = "Riga";
    public String postcodeText = "LV-1085";

    @BeforeClass
    public void navigateTo() {
        navigateTo("http://tutorialsninja.com/demo/");
    }

    @Test
    public void clickingComponents() {
        SoloTaskHomePage home = new SoloTaskHomePage(driver);
        home.selectMenuItem("Components");
        driver.findElement(By.linkText("Monitors (2)")).click();

        MonitorsPage monitor = new MonitorsPage(driver);
        monitor.clickItem(0);
        LOGGER.info("First three steps of the exercise are featured on this Test #1" + "\n" + "I encountered a problem i couldn't fix to proceed to the next steps. Execution continues in TEST #2 that i created in order to move on to practice finding locators and populating forms." + "\n" + "P.S. Later on when encountering similar problem at Checkout i found out that a waiter would most probably solve this problem.");
    }

    @Test
    public void populateForms() {
        driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=42");

        AppleMonitorPage appleMonitor = new AppleMonitorPage(driver);
        LOGGER.info("New Page Object class created " + "following the " + "1 Web Page = 1 Page java class" + " principle.");

        appleMonitor.chooseSize("6");

        appleMonitor.chooseCheckbox("9");

        appleMonitor.sendText1("IS IT REALLY NOT WORKING TOO?");

        appleMonitor.selectFromSelectTypeDD("Green\n" +
                "                                (+$1.20)\n" +
                "                 ");
        appleMonitor.writeInTextArea("Populating the text area.");

        WebElement element = driver.findElement(By.id("input-option222"));
        String jse = "arguments[0].value='apple_cinema.jpg'";
        ((JavascriptExecutor) driver).executeScript(jse, element);

        LOGGER.info("Upload completed!");

        String date = "1985-11-04";
        String time = "11:25";
        appleMonitor.setDatePicker(date);
        appleMonitor.setTimePicker(time);
        appleMonitor.setTimeAndDatePicker(date, time);

        appleMonitor.setQuantity("5");

        appleMonitor.clickAddToCartButton();
        LOGGER.info("All forms populated and item added to the cart!");

        appleMonitor.clickCartButton();
        appleMonitor.clickCheckoutLink();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        System.out.println(driver.getCurrentUrl());

        checkoutPage.chooseGuestCheckout();
        checkoutPage.clickContinueButton();
        checkoutPage.populateBillingDetails(firstNameText, lastNameText, emailText, telephoneText, addressText, cityText, postcodeText);
        checkoutPage.selectCountryDD("Afghanistan");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkoutPage.selectRegionDD("Farah");
        checkoutPage.clickContinueButtonTwo();
        Assertions.assertNotNull(driver.findElement(By.xpath("//input[@name='shipping_method']")).getText(), "There was a problem with some of the inputs!");
        checkoutPage.clickContinueButtonThree();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkoutPage.clickAgreeTOC();
        checkoutPage.clickContinueButtonFour();

        LOGGER.info("All forms populated - just one more confirmation and the order will be done!");

        checkoutPage.clickConfirmOrderButton();
        Assertions.assertEquals("Your order has been placed!", driver.findElement(By.xpath("//h1[contains(text(),'Your order has been placed!')]")).getText(), "Ooops.. something went wrong!");
        Assertions.assertEquals("0 item(s) - $0.00", driver.findElement(By.xpath("//span[@id='cart-total']")).getText(), "Ooops.. something went wrong here!");
    }
}

