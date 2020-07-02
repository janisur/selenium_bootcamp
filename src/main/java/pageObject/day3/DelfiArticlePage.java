//package pageObject.day3;
//
//import core.BaseFunc;
//import model.Article;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//
//import java.util.List;
//
//public class DelfiArticlePage extends BaseFunc {
//
//    public DelfiArticlePage(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy (how = How.XPATH, using = "//div[contains(@class, 'article-title mb-3 ')]")
//    private WebElement articleInside;
//
//    public Article getArticleTitleAndCommentInside() {
//        Article commentCountInside = new Article();
//
//        WebElement articleTitleInside = articleInside();
//        String title = articleInside.findElement(By.xpath("//h1[contains(@class, 'd-inline')]")).getText();
//        commentCountInside.setTitle(title);
//
//        List<WebElement> commentElements = articleInside.findElements(By.xpath("//a[contains(@class, 'text-red-ribbon')]"));
//        if (commentElements.isEmpty()) {
//            commentCountInside.setCommentNumber(0);
//        } else {
//            commentCountInside.setCommentNumber(commentElements.get(0).getText());
//        }
//        return commentCountInside;
//
//    }
//
//}
