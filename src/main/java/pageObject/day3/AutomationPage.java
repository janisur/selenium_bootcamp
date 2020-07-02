package pageObject.day3;

import core.BaseFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AutomationPage extends BaseFunc {
    public AutomationPage (WebDriver driver) {
        super(driver);
    }

    @FindBy (how = How.XPATH, using = "//a[contains(@title,'Women')]")
    private WebElement buttonWomen;

    public void clickWomen() {
        buttonWomen.click();
    }

    @FindBy (how = How.XPATH, using = "//a[contains(@title,'View my shopping cart')]")
    private WebElement buttonCart;

    public void clickCart() {
        buttonCart.click();
    }


}
