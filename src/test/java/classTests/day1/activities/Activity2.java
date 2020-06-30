package classTests.day1.activities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {
    private WebDriver driver;
    private String url = "http://book.theautomatedtester.co.uk/";

    @Before
    public void setDriver() {
        String userdirLib =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", userdirLib + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://book.theautomatedtester.co.uk/");
    }


    @Test
    public void practiceWithWebElement() {

        driver.get(url);

        //find element "Chapter 1" and  click on it
        // clear text from text box
        //  and send text to same text box

        WebElement chapterOne = driver.findElement(By.xpath("//a[@href='/chapter1']"));
        chapterOne.click();

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        textBox.clear();
        textBox.sendKeys("Sending some text... tralalala");

        //from element "Click this link to launch another window" print out text
//         [OPTION 1]
        System.out.println(driver.findElement(By.xpath("//div[@class='multiplewindow']")).getText());

        // [OPTION 2]
        //Webelement textWindow = driver.findElement(By.id("multiplewindow"));
        //String text = textWindow.getText();
        //        System.out.println(text);

        // [OPTION 3]
        //String textOfElement = driver.findElement(By.id("multiplewindow")).getText();
        //System.out.println(textOfElement);

        //from "Verify button" get attribute ( any you like) and print out
        System.out.println(driver.findElement(By.id("verifybutton")).getAttribute("value"));

        //from header " Selenium: Beginners Guide" get cssValue color also print out it
        System.out.println(driver.findElement(By.className("mainheading")).getCssValue("color"));


    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
