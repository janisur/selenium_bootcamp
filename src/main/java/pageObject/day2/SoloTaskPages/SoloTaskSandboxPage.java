package pageObject.day2.SoloTaskPages;

import core.BaseFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SoloTaskSandboxPage extends BaseFunc {
    public SoloTaskSandboxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'option[218]')]")
    private List<WebElement> size;

    public void chooseSize(String sizeOption) {
        for (WebElement element: size) {
            String sizeName = element.getText();
            if(sizeOption.contains(sizeName)) {
                element.click();
                break;
            }
        }
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'option[223][]')]")
    private List<WebElement> checkbox;

    public void chooseCheckbox(String checkboxOption) {
        for (WebElement element: size) {
            String checkboxName = element.getText();
            if(checkboxOption.contains(checkboxName)) {
                element.click();
                break;
            }
        }
    }

    @FindBy(how = How.XPATH, using = "//input[@id='input-option208']")
    private WebElement textInput;

    public void sendText1 (String textToSend) {
        textInput.clear();
        textInput.sendKeys(textToSend);
    }

    @FindBy(how = How.XPATH, using = "//select[@id='input-option217']")
    private WebElement selectTypeDD;

    public void selectFromSelectTypeDD(String optionName) {
        selectByVisibleText(selectTypeDD, optionName);
    }
}
