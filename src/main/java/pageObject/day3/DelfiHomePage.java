package pageObject.day3;

import core.BaseFunc;
import model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class DelfiHomePage extends BaseFunc {

    public DelfiHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'pale-sky py-3 px-2')]")
    private List<WebElement> menuItems;

    @FindBy(how = How.XPATH, using = "//h1[contains(@class, 'headline__title')]")
    private List<WebElement> articles;

    @FindBy (how = How.TAG_NAME, using = "article")
    private List<WebElement> articlesFull;

    public void selectMenuItem(String menuName) {
        for (WebElement element: menuItems) {
            String itemName = element.getText();
            if(menuName.equals(itemName)) {
                element.click();
                break;
            }
        }
    }

    public void clickArticles(int i) {
        articles.get(i).click();
    }
    // after public we specified that we want to return our Object model from Article.java
    public Article getArticleTitleAndComment(Integer i) {
        // Article = model Objects, and here we create a copy of it , in order to use.
        Article commentCount = new Article();
        // This line we selecting specific Article from Delfi Home Page to work with it.
        // get(i) - getting from list by index specific entry (in our case it Article).
        WebElement article = articlesFull.get(i);
        //Setting title name in Object model - method "setTitle()"
        //in set () we first looking for WebElement title (locators "h1") and getting text from it.
        String title = article.findElement(By.tagName("h1")).getText();
        commentCount.setTitle(title); // maucam iepriekseja koda rindina samekleto String title vertibu uz commentCoutn objektu no Article klases, ko izveidojam 44 rindina
        //We checking is comment number presented at the page.
        //List will not thow error in case if inside Article element does not exist comment element.
        List<WebElement> commentElements = article.findElements(By.xpath(".//a[contains(@class,'comment-count')]"));
        //is List of comment element is Empty or not.
        //if it is empty IF loop will ececute line with "commentCount.serCommentNumber(0);"
        if (commentElements.isEmpty()) {
            //if condition is TRUE, thsi code will be executed
            //letting know to our Object that comment amount is 0
            commentCount.setCommentNumber(0);
            //if it meets FALSE - started to work else code.
        } else {
            //in case of FLASE of IF condition, this part will be executed

            //This line we need to use our Comment Element (if it exists)
            WebElement comment = commentElements.get(0);// getting the first
            // Getting text number from Comment Ellement, to set it in Object model (Article)
            String commentNumberText = comment.getText();
            // commentCount = still name of our Object model, that we declared above ( Article commentCount = new Article();)
            // setCommentNumber - functions which set our result in Object mode (Article)
            commentCount.setCommentNumber(commentNumberText); // or replace lines 66, 68, 71 with commentCount.setCommentNumber(commentElements.get(0).getText());
            }
        article.click();
        //returning our Object model (Article.java) in order to use in Test class
        return commentCount;

    }


}
