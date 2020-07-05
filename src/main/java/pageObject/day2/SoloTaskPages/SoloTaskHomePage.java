package pageObject.day2.SoloTaskPages;

import core.BaseFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SoloTaskHomePage extends BaseFunc {
    public SoloTaskHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle']")
    private List<WebElement> menuItems;

    public void selectMenuItem(String menuName) {
        for (WebElement element: menuItems) {
            String itemName = element.getText();
            if(menuName.equals(itemName)) {
                element.click();
                break;
            }
        }
    }

}
