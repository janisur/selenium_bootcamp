package classTests.day2.SoloTask;

import baseWebTest.BaseWebTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.day2.SoloTaskPages.SoloTaskSandboxPage;

public class SoloTaskSandbox extends BaseWebTest {

    @BeforeClass
    public void navigateTo() {
        navigateTo("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=42");
    }

    @Test
    public void sandboxTesting() {
        SoloTaskSandboxPage testPage = new SoloTaskSandboxPage(driver);

        testPage.chooseSize("Small");

        testPage.chooseCheckbox("Checkbox 1");

        testPage.sendText1("IS IT REALLY NOT WORKING TOO?");

        testPage.selectFromSelectTypeDD("Green\n" +
                "                                (+$1.20)\n" +
                "                 ");
    }
}
