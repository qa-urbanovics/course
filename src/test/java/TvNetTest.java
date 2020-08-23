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

public class TvNetTest {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[@itemprop = 'url']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'item--comments')]");
    private final By COMMENTS_PAGE_COUNT = By.xpath(".//span[contains(@class, 'article-comments')]");

    private final Logger LOGGER = LogManager.getLogger(TvNetTest.class); // OR -> this.getClass()

    @Test
    public void articleTitleCommentsCheck() {
        LOGGER.info("This test is checking titles and comment count");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");

        LOGGER.info("Opening browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening home page");
        driver.get("https://tvnet.lv");

        LOGGER.info("Getting all articles");
        List<WebElement> articles = driver.findElements(ARTICLE);

        //find 3rd
        LOGGER.info("Find 3rd articles");
        WebElement article = articles.get(2);

        LOGGER.info("Getting title");
       String homePageTitle = article.findElement(TITLE).getText();

        //find comments counts
        int homePageCommentsCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()) {
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }
        // debug
        // System.out.println(homePageTitle + " " + homePageCommentsCount);
        //click on it
        article.findElement(TITLE).click();

        //Wait for title
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));

        //find title

        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        //find comment count
        int articlePageCommentCount = Integer.parseInt(driver.findElement(ARTICLE_PAGE_COMMENTS).getText());


        //check
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentCount, "Wrong comment count");

        //open comment page
        driver.findElement(ARTICLE_PAGE_COMMENTS).click();

        //wait for title
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));

        //find title
        String commentsPageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        //find comments count
        int commentsPageCommentsCount = Integer.parseInt(driver.findElement(COMMENTS_PAGE_COUNT).getText());

        //check
        Assertions.assertTrue(homePageTitle.startsWith(commentsPageTitle), "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentsCount, "Wrong comment!");
    }

    private int parseCommentCount(String textToParse){
        textToParse = textToParse.substring(1,textToParse.length() -1);
        return Integer.parseInt(textToParse);


    }
}
