package pageObject.day3;

import core.BaseFunc;
import model.Article;
import model.Items;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AutomationWomenPage extends BaseFunc {
    public AutomationWomenPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'product-name')]")
    private List<WebElement> itemsFull;

    public void clickItem(int i) {
        waitForTheListOfElements(itemsFull);

        itemsFull.get(i).click();
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'exclusive')]")
    private WebElement addToCartButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

//    public Items gettingItems(Integer i) {
//        Items item = new Items();
//
//        WebElement itemSelection = itemsFull.get(i);
//
//        String fname = itemSelection.findElements(By.xpath());
//        item.setItemName(fname);
//
//
//    itemSelection.click();
//    return item;
//    }

}
