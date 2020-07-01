package classTests.day1.activities;

import baseWebTest.BaseWebTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.day1.ChapterOnePage;
import pageObject.day1.HomePage;

public class ChapterOneTest extends BaseWebTest {

    @BeforeClass
    public void navigateTo() {
        navigateTo("http://book.theautomatedtester.co.uk/");
    }

    @Test
    public void chapterOneTest() {
        HomePage homePage = new HomePage(driver);

        Assertions.assertTrue(homePage.chapterOne.isDisplayed(), "Chapter link not displayed");
        homePage.clickChapterOne();

        ChapterOnePage chapterPage = new ChapterOnePage(driver);
        chapterPage.setTextBox("Sending some text... tralalala");

        chapterPage.selectFromSelectTypeDD("Selenium IDE");

        Assertions.assertEquals("Sending some text... tralalala", chapterPage.getTextOfTextBox(), "Text not the same");
        chapterPage.getTextOfTextBox();

        chapterPage.getTextOfTextWindow();
        String textLink = chapterPage.getTextOfTextWindow();

        Assertions.assertNotNull(textLink);
        chapterPage.getAttributeOfVerifyButton();

        Assertions.assertNotEquals("yellow", chapterPage.printCssValueOfMainHeading());
        Assertions.assertFalse(chapterPage.printCssValueOfMainHeading().equals("yellow"), " some message");
        Assertions.assertTrue(!chapterPage.printCssValueOfMainHeading().equals("yellow"), " some other message");
        chapterPage.getCssValueOfMainHeading();
    }


}