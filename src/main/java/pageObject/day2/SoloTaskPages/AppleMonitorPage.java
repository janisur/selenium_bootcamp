package pageObject.day2.SoloTaskPages;

import core.BaseFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AppleMonitorPage extends BaseFunc {
    public AppleMonitorPage(WebDriver driver) {
        super(driver);
    }

    //SIZE

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'option[218]')]")
    private List<WebElement> size;

    public void chooseSize(String sizeOption) {
        for (WebElement element : size) {
            String sizeName = element.getAttribute("value");
            if (sizeOption.contains(sizeName)) {
                element.click();
                break;
            }
        }
    }

    //CHECKBOX

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'option[223][]')]")
    private List<WebElement> checkbox;

    public void chooseCheckbox(String checkBoxName) {
        for (WebElement element : checkbox) {
            String itemName = element.getAttribute("value");
            if (checkBoxName.equals(itemName)) {
                element.click();
                break;
            }
        }
    }

    //TEXTBOX
    @FindBy(how = How.XPATH, using = "//input[@id='input-option208']")
    private WebElement textInput;

    public void sendText1(String textToSend) {
        textInput.clear();
        textInput.sendKeys(textToSend);
    }

    //DROPDOWN
    @FindBy(how = How.XPATH, using = "//select[@id='input-option217']")
    private WebElement selectTypeDD;

    public void selectFromSelectTypeDD(String optionName) {
        selectByVisibleText(selectTypeDD, optionName);
    }

    //TEXTAREA

    @FindBy(how = How.XPATH, using = "//textarea[@id='input-option209']")
    private WebElement textArea;

    public void writeInTextArea(String textAreaText) {
        textArea.sendKeys(textAreaText);
    }

    //UPLOAD

    @FindBy(how = How.ID, using = "button-upload222")
    private WebElement fileToUpload;

    String path = System.getProperty("user.dir") + "\\src\\resources\\apple_cinema.jpg";

    public void uploadFile() {
        fileToUpload.click();
//        fileToUpload.sendKeys(path);
        }

    //DATE PICKER

    public String date;

    @FindBy(how = How.XPATH, using = "//input[@id='input-option219']")
    private WebElement datePicker;

    public void setDatePicker(String date) {
        datePicker.clear();
        datePicker.sendKeys(date);
    }

    //TIME

    @FindBy(how = How.XPATH, using = "//input[@id='input-option221']")
    private WebElement timePicker;

    public void setTimePicker(String time) {
        timePicker.clear();
        timePicker.sendKeys(time);
    }

    //DATEANDTIME

    @FindBy(how = How.XPATH, using = "//input[@id='input-option220']")
    private WebElement timeAndDatePicker;

    public void setTimeAndDatePicker(String date, String time) {
        timeAndDatePicker.clear();
        timeAndDatePicker.sendKeys(date + " ",time);
    }

    //QUANTITY

    @FindBy(how = How.XPATH, using = "//input[@id='input-quantity']")
    private WebElement quantity;

    public void setQuantity(String number){
        quantity.clear();
        quantity.sendKeys(number);
    }

    //ADDTOCART

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-primary btn-lg btn-block')]")
    private WebElement addToCartButton;

    public void clickAddToCartButton(){
        addToCartButton.click();
    }
}
