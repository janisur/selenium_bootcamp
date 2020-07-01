package pageObject.day1;

import core.BaseFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChapterOnePage extends BaseFunc {

    public ChapterOnePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "html5div")
    private WebElement textBox;

    @FindBy(how = How.XPATH, using = "//div[@class='multiplewindow']")
    private WebElement textWindow;

    @FindBy(how = How.ID, using = "verifybutton")
    private WebElement verifyButton;

    @FindBy(how = How.CLASS_NAME, using = "mainheading")
    private WebElement mainHeading;

    @FindBy(how = How.CSS, using = "[id='selecttype']")
    private WebElement selectTypeDD;

    public void setTextBox(String textToSend) {
        textBox.clear();
        textBox.sendKeys(textToSend);
    }

    public String getTextOfTextBox() {
        return textBox.getText();
    }

    public String getTextOfTextWindow() {
        String text = textWindow.getText();
        return text;
    }

    public void getAttributeOfVerifyButton() {
        String value = verifyButton.getAttribute("value");
        System.out.println(value);
    }

    public void getCssValueOfMainHeading() {
        String cssValue = mainHeading.getCssValue("color");
        System.out.println(cssValue);
    }

    public String printCssValueOfMainHeading() {
        return mainHeading.getCssValue("color");

    }

    public void selectFromSelectTypeDD(String optionName) {
        selectByVisibleText(selectTypeDD, optionName);
    }

}