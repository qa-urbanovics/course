package page.object.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.object.BaseFunc;

import java.util.List;

public class HomePage {
    private final By ARTICLE  = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public String getTitleById(int id){
        return getArticleById(id).findElement(TITLE).getText().trim();
    }

    public ArticlePage openArticle(int id) {
        baseFunc.click(getArticleById(id));
        return new ArticlePage(baseFunc);
        //getArticleById(id).click();
    }

    public WebElement getArticleById(int id) {
        List<WebElement> articles = baseFunc.findElements(ARTICLE);
        Assertions.assertFalse(articles.isEmpty(), "There is no articles");
        return articles.get(id);
    }
}
