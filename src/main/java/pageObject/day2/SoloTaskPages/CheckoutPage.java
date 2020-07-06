package pageObject.day2.SoloTaskPages;

import core.BaseFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BaseFunc {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='guest']")
    private WebElement guestCheckout;

    public void chooseGuestCheckout() {
        waitElementAppeared(guestCheckout);
        guestCheckout.click();
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Continue']")
    private WebElement continueButton;

    public void clickContinueButton() {
        continueButton.click();
    }

    @FindBy(how = How.XPATH, using = "//input[@name='firstname']")
    private WebElement firstName;

    @FindBy(how = How.XPATH, using = "//input[@name='lastname']")
    private WebElement lastName;

    @FindBy(how = How.XPATH, using = "//input[@id='input-payment-email' and @name='email']")
    private WebElement email;

    @FindBy(how = How.XPATH, using = "//input[@name='telephone']")
    private WebElement telephone;

    @FindBy(how = How.XPATH, using = "//input[@name='address_1']")
    private WebElement address;

    @FindBy(how = How.XPATH, using = "//input[@name='city']")
    private WebElement city;

    @FindBy(how = How.XPATH, using = "//input[@name='postcode']")
    private WebElement postcode;


    public void populateBillingDetails(String firstNameText, String lastNameText, String emailText, String telephoneText, String addressText, String cityText, String postcodeText) {
        waitElementAppeared(firstName);
        firstName.sendKeys(firstNameText);
        lastName.sendKeys(lastNameText);
        email.sendKeys(emailText);
        telephone.sendKeys(telephoneText);
        address.sendKeys(addressText);
        city.sendKeys(cityText);
        postcode.sendKeys(postcodeText);
    }

    @FindBy(how = How.XPATH, using = "//select[@id='input-payment-country']")
    private WebElement countryDD;

    public void selectCountryDD(String countryName) {
        selectByVisibleText(countryDD, countryName);
        waitElementAppeared(regionDD);
    }

    @FindBy(how = How.XPATH, using = "//select[@id='input-payment-zone' and @name='zone_id']")
    private WebElement regionDD;

    public void selectRegionDD(String regionName) {
        waitElementAppeared(regionDD);
        selectByVisibleText(regionDD, regionName);
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Continue' and @id='button-guest']")
    private WebElement continueButtonTwo;

    public void clickContinueButtonTwo() {
        continueButtonTwo.click();
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Continue' and @id='button-shipping-method']")
    private WebElement continueButtonThree;

    public void clickContinueButtonThree() {
        continueButtonThree.click();
    }

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox' and @name='agree']")
    private WebElement agreeTOC;

    public void clickAgreeTOC() {
        waitElementAppeared(agreeTOC);
        agreeTOC.click();
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Continue' and @id='button-payment-method']")
    private WebElement continueButtonFour;

    public void clickContinueButtonFour() {
        continueButtonFour.click();
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Confirm Order' and @id='button-confirm']")
    private WebElement confirmOrderButton;

    public void clickConfirmOrderButton() {
        confirmOrderButton.click();
    }
}
