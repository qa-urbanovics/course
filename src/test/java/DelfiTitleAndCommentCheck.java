import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiTitleAndCommentCheck {

    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By ARTICLE_PAGE_COMENT_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//p[contains(@class, 'text-counter')]");
    private final By COMMENTS_PAGE_COUNT = By.xpath(".//span[contains(@class, 'article-comments')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());


    @Test

    public void articleTitleAndCommentCheck(){

        LOGGER.info("This test is checking titles and comment count");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");

        LOGGER.info("Opening browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening delfi page");
        driver.get("https://rus.delfi.lv");

        LOGGER.info("Getting all articles");
        List<WebElement> articles = driver.findElements(ARTICLE);

        LOGGER.info("Find 3rd articles");
        WebElement article = articles.get(2);

        LOGGER.info("Getting title");
        String homePageTitle = article.findElement(TITLE).getText();

        LOGGER.info("find Comments counts");
        int homePageCommentsCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()) {
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }
        // debug
        // System.out.println(homePageTitle + " " + homePageCommentsCount);

        LOGGER.info("Click on article title");
        article.findElement(TITLE).click();

        LOGGER.info("Waiting for title");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));

        LOGGER.info("Find article page title");
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        LOGGER.info("Find article page comments");
        int articlePageCommentCount = Integer.parseInt(driver.findElement(ARTICLE_PAGE_COMMENTS).getText());

        LOGGER.info("Check article and comment");
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Wrong title1!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentCount, "Wrong comment count1");

        LOGGER.info("Open comment page");
        driver.findElement(ARTICLE_PAGE_COMMENTS).click();

        LOGGER.info("Waiting article page title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_COMENT_PAGE_TITLE));

        LOGGER.info("Find artile title");
        String commentsPageTitle = driver.findElement(ARTICLE_PAGE_COMENT_PAGE_TITLE).getText();

        LOGGER.info("Find comment counts");
        int commentsPageCommentsCount = Integer.parseInt(driver.findElement(COMMENTS_PAGE_COUNT).getText());

        LOGGER.info("Check title and comment count in comment page");
        Assertions.assertTrue(homePageTitle.startsWith(commentsPageTitle), "Wrong title2!");
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentsCount, "Wrong comment2!");
    }
    private int parseCommentCount(String textToParse){
        textToParse = textToParse.substring(1,textToParse.length() -1);
        return Integer.parseInt(textToParse);


    }
}
