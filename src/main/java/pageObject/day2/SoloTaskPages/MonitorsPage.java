package pageObject.day2.SoloTaskPages;

import core.BaseFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MonitorsPage extends BaseFunc {
    public MonitorsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@onclick,'cart.add')]")
    private List<WebElement> addToCartButtons;

    public void clickItem(int i) {
        addToCartButtons.get(i).click();
    }

}
